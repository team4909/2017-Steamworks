package org.usfirst.frc4909.STEAMWORKS.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4909.STEAMWORKS.Robot;

public class ShiftUpCommand extends Command {
	protected boolean shifted = false;

    public ShiftUpCommand() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {
    	shifted = true;
    }

    protected void execute() {}

    protected boolean isFinished() {
        return shifted;
    }

    protected void end() {}

    protected void interrupted() {}
}