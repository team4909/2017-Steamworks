package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.utils.Command;
import org.usfirst.frc4909.STEAMWORKS.Robot;

public class DriveCommand extends Command {
    public DriveCommand() {
        requires(Robot.drivetrain);
    }

    protected void execute() {
    	Robot.drivetrain.moveTank();
    }
    
    protected void end() {
    	Robot.drivetrain.stop();
    }
}