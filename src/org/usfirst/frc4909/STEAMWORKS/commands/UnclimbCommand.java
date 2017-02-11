package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.utils.Command;
import org.usfirst.frc4909.STEAMWORKS.Robot;

public class UnclimbCommand extends Command {
    public UnclimbCommand() {
        requires(Robot.climber);
    }

    protected void execute() {
    	Robot.climber.climb(Robot.config.unclimberMaxSpeed);
    }

    protected void end() {
    	Robot.climber.climb(0);
    }
}