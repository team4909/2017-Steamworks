package org.usfirst.frc4909.STEAMWORKS;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.vision.VisionThread;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc4909.STEAMWORKS.config.Config;
import org.usfirst.frc4909.STEAMWORKS.subsystems.*;
import org.usfirst.frc4909.STEAMWORKS.vision.Pipeline;

public class Robot extends IterativeRobot {
    public static OI oi;
    public static Drivetrain drivetrain;
    public static Climber climber;
    public static Intake intake;
    public static Feeder feeder;
    public static Shooter shooter;
    public static Loader loader;
    private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	
	private VisionThread visionThread;
	private double centerX = 0.0;
	private RobotDrive drive;
	
	private final Object imgLock = new Object();
    public static Config config;
   
    public void robotInit() {
    	RobotMap.init();
        drivetrain = new Drivetrain();
        climber = new Climber();
        intake = new Intake();
        feeder = new Feeder();
        shooter = new Shooter();
        loader = new Loader();
        oi = new OI();
        
        UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
        camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
        
        visionThread = new VisionThread(camera, new Pipeline(), pipeline -> {
            if (!pipeline.filterContoursOutput().isEmpty()) {
                Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
                synchronized (imgLock) {
                    centerX = r.x + (r.width / 2);
                }
            }
        });
        
        visionThread.start();
        
        config = new Config();
    }

    public void disabledInit(){}

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {}

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {}

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}
