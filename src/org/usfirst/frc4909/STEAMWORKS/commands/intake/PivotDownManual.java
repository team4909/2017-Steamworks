package org.usfirst.frc4909.STEAMWORKS.commands.intake;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

public class PivotDownManual extends Command {
    public PivotDownManual() {
    	requires(Robot.intakePivot);
    }
    
    protected void execute() {
    	Robot.intakePivot.setSpeed(-0.3);
    }
    
    protected boolean isFinished() {
    	return true; //return !Robot.oi.manipulatorJoystick.getRawButton(9);
    }

    protected void end() {
    	Robot.intakePivot.setSpeed(0);
    }
}
