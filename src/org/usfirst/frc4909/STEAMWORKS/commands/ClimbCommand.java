package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.utils.Command;
import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.config.Config;

public class ClimbCommand extends Command {
    public ClimbCommand() {
        requires(Robot.climber);
    }

    protected void execute() {
    	Robot.climber.climb(Robot.oi.getManipulatorJoystick().getThresholdAxis(1, Config.joystickDeadzone));
    }
    
    protected void end() {
    	Robot.climber.climb(0);
    }
}