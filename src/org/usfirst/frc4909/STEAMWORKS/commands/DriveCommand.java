package org.usfirst.frc4909.STEAMWORKS.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4909.STEAMWORKS.Robot;

public class DriveCommand extends Command {
    public DriveCommand() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.drivetrain.moveTank();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.drivetrain.stop();
    }
    
    protected void interrupted() {
    	end();
    }
}