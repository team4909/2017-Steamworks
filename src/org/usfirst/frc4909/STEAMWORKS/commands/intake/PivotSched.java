package org.usfirst.frc4909.STEAMWORKS.commands.intake;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

public class PivotSched extends Command {
	public PivotSched() {
		requires(Robot.intakePolycord);
		requires(Robot.intakePivot);
	}
	
	protected void initialize() {
    	Robot.intakePivot.initPID();
    }

    protected void execute() {
    	Robot.intakePivot.setPosition(Robot.intakePivot.targetPosition);
    }

    protected boolean isFinished() {
        return false; //return Robot.intakePivot.isFinished();
    }
}
