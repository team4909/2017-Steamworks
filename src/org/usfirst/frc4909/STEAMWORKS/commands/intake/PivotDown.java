package org.usfirst.frc4909.STEAMWORKS.commands.intake;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

public class PivotDown extends Command {
	public PivotDown() {
		requires(Robot.intakePolycord);
		requires(Robot.intakePivot);
	}
	
	protected void initialize() {
    	Robot.intakePivot.initPID();
    }

    protected void execute() {
    	Robot.intakePivot.setPosition(1);
    }

    protected boolean isFinished() {
        return false; //Robot.intakePivot.isFinished();
    }
}
