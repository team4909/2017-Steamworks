package org.usfirst.frc4909.STEAMWORKS.commands.loader;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

/**
 *
 */
public class LoaderOpenManual extends Command {

    public LoaderOpenManual() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.loader.setSpeed(.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !Robot.oi.manipulatorJoystick.getRawButton(9);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.loader.setSpeed(0);
    }


}
