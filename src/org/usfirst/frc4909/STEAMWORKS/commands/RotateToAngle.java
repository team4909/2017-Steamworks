package org.usfirst.frc4909.STEAMWORKS.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4909.STEAMWORKS.Robot;

public class RotateToAngle extends Command {
    public RotateToAngle() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {}

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

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	SmartDashboard.putBoolean("rotate", false);

    }

    protected void interrupted() {}
}
