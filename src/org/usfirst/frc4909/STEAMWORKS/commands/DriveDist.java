package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveDist extends Command {

    public DriveDist() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*
    	if(Robot.oi.leftDriveJoystick.getRawButton(2))
    		Robot.drivetrain.driveStraightNavX(.5);
    	else if(Robot.oi.leftDriveJoystick.getRawButton(3))
    		Robot.drivetrain.driveStraightNavX(1);
    	else if(Robot.oi.leftDriveJoystick.getRawButton(4))
    		Robot.drivetrain.driveStraightNavX(2);
    	else if(Robot.oi.leftDriveJoystick.getRawButton(5))
    		Robot.drivetrain.driveStraightNavX(-1);
		*/

    	if(Robot.oi.leftDriveJoystick.getRawButton(2))
    		Robot.drivetrain.driveStraightEncoder(12);
    	else if(Robot.oi.leftDriveJoystick.getRawButton(3))
    		Robot.drivetrain.driveStraightEncoder(24);
    	else if(Robot.oi.leftDriveJoystick.getRawButton(4))
    		Robot.drivetrain.driveStraightEncoder(36);
    	else if(Robot.oi.leftDriveJoystick.getRawButton(5))
    		Robot.drivetrain.driveStraightEncoder(-12);

    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putBoolean("straight", false);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
