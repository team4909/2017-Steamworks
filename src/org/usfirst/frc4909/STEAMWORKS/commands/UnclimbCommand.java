package org.usfirst.frc4909.STEAMWORKS.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4909.STEAMWORKS.Robot;

public class UnclimbCommand extends Command {

    public UnclimbCommand() {
        requires(Robot.climber);
    }

    protected void initialize() {}

    protected void execute() {
    	Robot.climber.climb(Robot.config.getUnclimberMaxSpeed());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.climber.climb(0);
    }

    protected void interrupted() {
    	end();
    }
}