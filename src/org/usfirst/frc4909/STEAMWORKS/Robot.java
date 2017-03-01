package org.usfirst.frc4909.STEAMWORKS;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc4909.STEAMWORKS.commands.auto.*;
import org.usfirst.frc4909.STEAMWORKS.commands.intake.PivotSched;
import org.usfirst.frc4909.STEAMWORKS.commands.loader.LoaderSched;
import org.usfirst.frc4909.STEAMWORKS.subsystems.*;
import org.usfirst.frc4909.STEAMWORKS.vision.GripPipeline;

public class Robot extends IterativeRobot {
    public static OI oi;
    
    public static Drivetrain drivetrain;
    public static Climber climber;
    public static IntakePolycord intakePolycord;
    public static IntakePivot intakePivot;
    public static Feeder feeder;
    public static Shooter shooter;
    public static Loader loader;
    
    private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	private VisionThread visionThread;
	private final Object imgLock = new Object();
  
    SendableChooser<Object> autoChooser;
    Command autonomousCommand;
   
    public void robotInit() {
    	RobotMap.init();
    	
        drivetrain = new Drivetrain();
        climber = new Climber();
        intakePivot = new IntakePivot();
        intakePolycord = new IntakePolycord();
        feeder = new Feeder();
        shooter = new Shooter();
        loader = new Loader();
        oi = new OI();
        
        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
        camera.setExposureManual(10);
        camera.setWhiteBalanceManual(4500);

        visionThread = new VisionThread(camera, new GripPipeline(), pipeline -> {
            SmartDashboard.putBoolean("Is Empty", pipeline.filterContoursOutput().isEmpty());
//            if (!pipeline.filterContoursOutput().isEmpty()) {
            
            if (pipeline.filterContoursOutput().size()>1) {

                Rect l = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
                Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(1));
                synchronized (imgLock) {
                    SmartDashboard.putNumber("Centel X L", (l.x + (l.width / 2)));
                    SmartDashboard.putNumber("Centel Y L", (l.y + (l.height / 2)));
                    SmartDashboard.putNumber("Center X R", (r.x + (r.width / 2)));
                    SmartDashboard.putNumber("Center Y R", (r.y + (r.height / 2)));
                    SmartDashboard.putNumber("Avg X", ((r.x + (r.height / 2)+ l.x + (l.width / 2))/2));

                }
            }
        });
        visionThread.start();
        
        // Autonomous Chooser
        autoChooser = new SendableChooser<Object>();
        autoChooser.addDefault("Do Nothing", new DoNothing());
        autoChooser.addObject("Break Baseline", new BreakBaseline());
        autoChooser.addObject("Place Front Gear with Encoders", new PlaceFrontGearEncoder());
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

    }

    public void disabledInit(){}

    public void disabledPeriodic() {
    	
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
    	autonomousCommand = (Command) autoChooser.getSelected();
    	
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
    	(new PivotSched()).start();
    	(new LoaderSched()).start();
    	
        Scheduler.getInstance().run();
    }

    public void teleopInit() {}

    
    public void teleopPeriodic() {
    	(new PivotSched()).start();
    	(new LoaderSched()).start();
    	//RobotMap.intakeIntakeMotor.set(.525);
    	SmartDashboard.putNumber("pivot angle", Robot.intakePivot.getAngle());
    	SmartDashboard.putNumber("loader angle", Robot.loader.getAngle());
    	SmartDashboard.putNumber("shooter rpm", Robot.shooter.getRPM());
    	
        Scheduler.getInstance().run();
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}
