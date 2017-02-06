package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class RotateToAngle extends Command {

    public RotateToAngle() {
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.manipulatorJoystick.getRawButton(2))
    		Robot.drivetrain.rotateAngle(0);
    	else if(Robot.oi.manipulatorJoystick.getRawButton(3))
    		Robot.drivetrain.rotateAngle(90);
    	else if(Robot.oi.manipulatorJoystick.getRawButton(4))
    		Robot.drivetrain.rotateAngle(180);
    	else if(Robot.oi.manipulatorJoystick.getRawButton(5))
    		Robot.drivetrain.rotateAngle(-90);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putBoolean("rotate", false);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
