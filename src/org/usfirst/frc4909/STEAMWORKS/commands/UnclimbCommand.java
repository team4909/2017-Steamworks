package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.utils.Command;
import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.config.Config;

public class UnclimbCommand extends Command {
    public UnclimbCommand() {
        requires(Robot.climber);
    }

    protected void execute() {
    	Robot.climber.climb(Config.unclimberMaxSpeed);
    }

    protected void end() {
    	Robot.climber.climb(0);
    }
}