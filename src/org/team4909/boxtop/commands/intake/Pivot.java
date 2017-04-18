package org.team4909.boxtop.commands.intake;

import org.team4909.boxtop.Robot;
import org.team4909.utils.Command;

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
