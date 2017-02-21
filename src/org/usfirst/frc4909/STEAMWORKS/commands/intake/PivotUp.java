package org.usfirst.frc4909.STEAMWORKS.commands.intake;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

public class PivotUp extends Command {
	public PivotUp() {
//		requires(Robot.intakePolycord);
//		requires(Robot.intakePivot);
	}

	protected void initialize() {
    	Robot.intakePivot.initPID();
    }

    protected void execute() {
    	Robot.intakePivot.setPosition(0);
    }

    protected boolean isFinished() {
        return false; //return Robot.intakePivot.isFinished();
    }
}
