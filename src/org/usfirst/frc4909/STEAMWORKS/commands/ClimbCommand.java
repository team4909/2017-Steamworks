package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.utils.Command;
import org.usfirst.frc4909.STEAMWORKS.Robot;

public class ClimbCommand extends Command {
    public ClimbCommand() {
        requires(Robot.climber);
    }

    protected void execute() {
//    	Robot.climber.climb(Robot.config.climberMaxSpeed);
    	Robot.climber.climb(Robot.oi.getManipulatorJoystick().getRawAxis(1));

    }
    
    protected void end() {
    	Robot.climber.climb(0);
    }
}