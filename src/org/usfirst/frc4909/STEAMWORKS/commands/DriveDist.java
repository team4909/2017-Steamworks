package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveDist extends Command {

    public DriveDist() {
    	requires(Robot.drivetrain);
    }
    
    protected void initialize() {}

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

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	SmartDashboard.putBoolean("straight", false);
    }

    protected void interrupted() {}
}