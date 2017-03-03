package org.usfirst.frc4909.STEAMWORKS.commands.intake;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

public class Pivot extends Command {
	public Pivot() {}
	
	protected void initialize() {
        if(Robot.intakePivot.targetPosition == 0)
			Robot.intakePivot.targetPosition = 1;
        else
	        Robot.intakePivot.targetPosition = 0;
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }
}
