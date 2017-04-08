package org.usfirst.frc4909.STEAMWORKS;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.opencv.core.Mat;
import org.usfirst.frc4909.STEAMWORKS.commands.auto.*;
import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.InvertToState;
import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.ShiftToState;
import org.usfirst.frc4909.STEAMWORKS.commands.intake.PivotSched;
import org.usfirst.frc4909.STEAMWORKS.commands.intake.PivotTime;
import org.usfirst.frc4909.STEAMWORKS.commands.loader.LoaderSched;
import org.usfirst.frc4909.STEAMWORKS.subsystems.*;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain.ShiftingRobotDrive.Gear;

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
    public static CvSink cvSinkIntakeFPSThrottleInput;
    public static CvSource cvSinkIntakeFPSThrottle;
    public static VideoSink server;
    
    double lastFrameSent;
    
    boolean isLoaderSide;

    private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	private VisionThread visionThread;
  
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
        	 loaderCam.setExposureManual(50);
        	 loaderCam.setWhiteBalanceManual(4500);
        	 
        	 intakeCam = CameraServer.getInstance().startAutomaticCapture(1);
        	 intakeCam.setResolution(IMG_WIDTH, IMG_HEIGHT);
        	 
             cvSinkIntakeFPSThrottleInput = CameraServer.getInstance().getVideo(intakeCam);
             cvSinkIntakeFPSThrottleInput.setEnabled(true);
             
             cvSinkIntakeFPSThrottle = CameraServer.getInstance().putVideo("intakeCamLowFPS", IMG_WIDTH, IMG_HEIGHT);
        	 
        	 new Thread(() -> {
                 Mat cameraMat = new Mat();
                 
                 while(!Thread.interrupted()) {
                	 try{
                		 //double timeSinceLastFrameSent = Timer.getFPGATimestamp() - lastFrameSent;
                		 //if(timeSinceLastFrameSent > 0.125){
	                	 
                		 if((Timer.getFPGATimestamp() - lastFrameSent) > 0.125){
		                	 cvSinkIntakeFPSThrottleInput.grabFrame(cameraMat);
		
		                	 cvSinkIntakeFPSThrottle.putFrame(cameraMat);
		                	 lastFrameSent = Timer.getFPGATimestamp();
	                	 }
                	} catch (Exception e) {}
                 }
             }).start();
        	 
        	 server = CameraServer.getInstance().getServer();
        	 
        	 cvSinkLoader = new CvSink("loadCamcv");
        	 cvSinkLoader.setSource(loaderCam);
        	 cvSinkLoader.setEnabled(true);
        	 
        	 cvSinkIntake = new CvSink("intakeCamcv");
        	 cvSinkIntake.setSource(intakeCam);
        	 cvSinkIntake.setEnabled(true);
		} catch (Exception e) {}

//        visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
//            SmartDashboard.putBoolean("Is Empty", pipeline.filterContoursOutput().isEmpty());
////            if (!pipeline.filterContoursOutput().isEmpty()) {
//            
//            if (pipeline.filterContoursOutput().size()>1) {
//                Rect l = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
//                Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(1));
//                synchronized (imgLock) {
//                    SmartDashboard.putNumber("Centel X L", (l.x + (l.width / 2)));
//                    SmartDashboard.putNumber("Centel Y L", (l.y + (l.height / 2)));
//                    SmartDashboard.putNumber("Center X R", (r.x + (r.width / 2)));
//                    SmartDashboard.putNumber("Center Y R", (r.y + (r.height / 2)));
//                    SmartDashboard.putNumber("Avg X", ((r.x + (r.height / 2)+ l.x + (l.width / 2))/2));
//
//                }
//            }
//        });

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
//    	autonomousCommand = (Command) new PlaceMiddleGearEncoder();

        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
    	(new PivotSched()).start();
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
//    	(new PivotSched()).start();
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
    
    public void stop() {
        Thread waitThread = visionThread;
        visionThread = null;
        waitThread.interrupt();
    }
}
