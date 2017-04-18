package org.team4909.boxtop;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.team4909.boxtop.commands.auto.*;
import org.team4909.boxtop.commands.drive.semiauto.InvertToState;
import org.team4909.boxtop.commands.drive.semiauto.ShiftToState;
import org.team4909.boxtop.commands.intake.PivotSched;
import org.team4909.boxtop.commands.intake.PivotTime;
import org.team4909.boxtop.commands.loader.LoaderSched;
import org.team4909.boxtop.subsystems.*;
import org.team4909.utils.devices.drivetrain.ShiftingRobotDrive.Gear;

public class Robot extends IterativeRobot {
    public static OI oi;
    
    public static Drivetrain drivetrain;
    public static Climber climber;
    public static IntakePolycord intakePolycord;
    public static IntakePivot intakePivot;
    public static Feeder feeder;
    public static Shooter shooter;
    public static Loader loader;
    public static LEDControl leds;
    
    public static UsbCamera loaderCam;
    public static UsbCamera intakeCam;
    public static CvSink cvSinkLoader;
    public static CvSink cvSinkIntake;
    public static VideoSink server;
    boolean isLoaderSide;

    
    private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	private VisionThread visionThread;
	private final Object imgLock = new Object();
  
    SendableChooser<Object> autoChooser;
    Command autonomousCommand;
    
    Preferences prefs;
   
    public void robotInit() {
    	RobotMap.init();
    	
        drivetrain = new Drivetrain();
        climber = new Climber();
        intakePivot = new IntakePivot();
        intakePolycord = new IntakePolycord();
        feeder = new Feeder();
        shooter = new Shooter();
        loader = new Loader();
        leds = new LEDControl();
        oi = new OI();
        
        try {
        	 loaderCam = CameraServer.getInstance().startAutomaticCapture(0);
        	 loaderCam.setResolution(IMG_WIDTH, IMG_HEIGHT);   
//             camera.setExposureManual(10);
        	 loaderCam.setExposureManual(50);
        	 loaderCam.setWhiteBalanceManual(4500);
        	 
        	 intakeCam = CameraServer.getInstance().startAutomaticCapture(1);
        	 intakeCam.setResolution(IMG_WIDTH, IMG_HEIGHT);   
        	 intakeCam.setFPS(6);
//             camera.setExposureManual(10);
//        	 intakeCam.setExposureManual(30);
//        	 intakeCam.setWhiteBalanceManual(1000);
        	 server = CameraServer.getInstance().getServer();
        	 cvSinkLoader = new CvSink("loadCamcv");
        	  cvSinkLoader.setSource(loaderCam);
        	  cvSinkLoader.setEnabled(true);
        	  cvSinkIntake = new CvSink("intakeCamcv");
        	  cvSinkIntake.setSource(intakeCam);
        	  cvSinkIntake.setEnabled(true);
		} catch (Exception e) {
			
		}

        // Autonomous Chooser
        autoChooser = new SendableChooser<Object>();
        autoChooser.addDefault("Do Nothing", new DoNothing());
        autoChooser.addObject("Break Baseline", new BreakBaseline());
        autoChooser.addObject("Place Front Gear with Encoders", new PlaceMiddleGearEncoder());
        autoChooser.addObject("Place Loading Station Side Auto", new PlaceLoaderGearEncoder());

        SmartDashboard.putData("Autonomous Mode Chooser", autoChooser);
        
        //Indicators Initialized
        SmartDashboard.putBoolean("Ready to Shoot", false);
        SmartDashboard.putBoolean("Agitator On", false);
        SmartDashboard.putBoolean("Intake Pivot Down", false);
        SmartDashboard.putBoolean("Climber Limit Switch State", false);
        SmartDashboard.putString("Loader Position", "Hold");
        
        //Manual Overrides Initialized
        SmartDashboard.putBoolean("Shooter Manual Override", false);
        SmartDashboard.putBoolean("Intake Pivot Manual Override", false);
        SmartDashboard.putBoolean("Loader Pivot Manual Override", false);
        SmartDashboard.putBoolean("Climber Limit Switch Disable", false);
        SmartDashboard.putBoolean("Intake Pop Out Disable", false);
        
       prefs=Preferences.getInstance();
    }

//    @SuppressWarnings("deprecation")
	public void disabledInit(){
//		stop();
//		visionThread.run();
	}
    
    public void disabledPeriodic() {
    	SmartDashboard.putNumber("pivot angle", Robot.intakePivot.getAngle());
    	SmartDashboard.putNumber("loader angle", Robot.loader.getAngle());
    	SmartDashboard.putNumber("shooter rpm", Robot.shooter.getRPM());
    	
    	Robot.drivetrain.navx.reset();
	        SmartDashboard.putNumber("Gear Detector Intake", RobotMap.intakeGearDetector.getVoltage());
	        SmartDashboard.putBoolean("Intake Gear", RobotMap.intakeGearDetector.getVoltage()<0.8);

        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
    	autonomousCommand = (Command) autoChooser.getSelected();

        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
    	(new LoaderSched()).start();
    	SmartDashboard.putNumber("Left Encoder Distance", drivetrain.getLeftEncDistance());
        SmartDashboard.putNumber("Right Encoder Distance", drivetrain.getRightEncDistance());
        SmartDashboard.putNumber("Current Angle", drivetrain.navx.getYaw());

        Scheduler.getInstance().run();
    }

    public void teleopInit() {
//        visionThread.start();
    	Robot.drivetrain.navx.zeroYaw();
    	new ShiftToState(Gear.Low).start();
    	RobotMap.drivetrainLeftEncoder.reset();
    	RobotMap.drivetrainRightEncoder.reset();
    	if(!SmartDashboard.getBoolean("Intake Pop Out Disable", false))
    		new PivotTime(.1).start();
    	new InvertToState(true).start();
    }

    
    public void teleopPeriodic() {
    	(new LoaderSched()).start();
//        SmartDashboard.putString("Gear Speed",Robot.drivetrain.robotDrive.getState().name());
//        SmartDashboard.putNumber("Left Encoder Distance", drivetrain.getLeftEncDistance());
//        SmartDashboard.putNumber("Right Encoder Distance", drivetrain.getRightEncDistance());
//    		RobotMap.intakeIntakeMotor.set(.525);
    		SmartDashboard.putNumber("pivot angle", Robot.intakePivot.getAngle());
   	 		SmartDashboard.putNumber("loader angle", Robot.loader.getAngle());
   	 		SmartDashboard.putNumber("shooter rpm", Robot.shooter.getRPM());
   	    	SmartDashboard.putNumber("Left Encoder Distance", drivetrain.getLeftEncDistance());
   	        SmartDashboard.putNumber("Right Encoder Distance", drivetrain.getRightEncDistance());
   	        //SmartDashboard.putBoolean("Gear Speed", Robot.drivetrain.robotDrive.getSingleState());
	        SmartDashboard.putBoolean("Intake Gear", RobotMap.intakeGearDetector.getVoltage()<1);

   	        SmartDashboard.putNumber("Gear Detector Intake", RobotMap.intakeGearDetector.getVoltage());
        Scheduler.getInstance().run();
        if(oi.driveGamepad.getRawButton(7))
        	isLoaderSide=!isLoaderSide;
   
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
    
    public void stop() {}
}
