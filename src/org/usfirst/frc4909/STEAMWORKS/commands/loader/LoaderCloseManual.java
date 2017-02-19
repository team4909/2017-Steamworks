package org.usfirst.frc4909.STEAMWORKS.commands.loader;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

public class LoaderCloseManual extends Command {
    public LoaderCloseManual() {}
    
    protected void execute() {
    	Robot.loader.setSpeed(-.3);
    }
    protected boolean isFinished() {
        return !Robot.oi.manipulatorJoystick.getRawButton(10);
    }

    protected void end() {
    	Robot.loader.setSpeed(0);
    }
}