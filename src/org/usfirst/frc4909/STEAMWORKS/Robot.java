package org.usfirst.frc4909.STEAMWORKS;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4909.STEAMWORKS.subsystems.*;

public class Robot extends IterativeRobot {
    Command autonomousCommand;

    public static OI oi;
    public static Drivetrain drivetrain;
    public static Climber climber;
    public static Intake intake;
    public static Feeder feeder;
    public static Shooter shooter;
    public static Loader loader;
   
    public void robotInit() {
    	RobotMap.init();
        drivetrain = new Drivetrain();
        climber = new Climber();
        intake = new Intake();
        feeder = new Feeder();
        shooter = new Shooter();
        loader = new Loader();
        oi = new OI();
        
        SmartDashboard.putBoolean("ShooterOverride", false);
    }

    public void disabledInit(){

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    public void testPeriodic() {
        LiveWindow.run();
    }
}
