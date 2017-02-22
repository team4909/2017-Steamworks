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
import org.usfirst.frc4909.STEAMWORKS.subsystems.*;
import org.usfirst.frc4909.STEAMWORKS.vision.Pipeline;

import com.ctre.CANTalon.TalonControlMode;

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
        camera.setExposureManual(20);
        
        visionThread = new VisionThread(camera, new Pipeline(), pipeline -> {
            SmartDashboard.putBoolean("Is Empty", pipeline.filterContoursOutput().isEmpty());
            if (!pipeline.filterContoursOutput().isEmpty()) {
                Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
                synchronized (imgLock) {
                    SmartDashboard.putNumber("Center X", (r.x + (r.width / 2)));
                    SmartDashboard.putNumber("Center Y", (r.y + (r.height / 2)));
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
        Scheduler.getInstance().run();
    }

    public void teleopInit() {}

    
    public void teleopPeriodic() {
    	SmartDashboard.putNumber("pivot angle", Robot.intakePivot.getAngle());
    	SmartDashboard.putNumber("shooter rpm", Robot.shooter.getRPM());
    	
        Scheduler.getInstance().run();
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}
