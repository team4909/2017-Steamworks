package org.usfirst.frc4909.STEAMWORKS;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc4909.STEAMWORKS.config.Config;
import org.usfirst.frc4909.STEAMWORKS.subsystems.*;

public class Robot extends IterativeRobot {
    public static OI oi;
    public static Drivetrain drivetrain;
    public static Climber climber;
    public static Intake intake;
    public static Feeder feeder;
    public static Shooter shooter;
    public static Loader loader;
    
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
