package org.usfirst.frc4909.STEAMWORKS.commands.loader;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

public class LoaderOpenManual extends Command {
    public LoaderOpenManual() {}
    
    protected void execute() {
    	Robot.loader.setSpeed(-0.3);
    }
    protected boolean isFinished() {
        return !Robot.oi.manipulatorJoystick.getRawButton(9);
    }

    protected void end() {
    	Robot.loader.setSpeed(0);
    }
}
