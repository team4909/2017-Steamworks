package org.team4909.boxtop.commands.intake;

import org.team4909.boxtop.Robot;
import org.team4909.utils.EasyCommand;

public class Pivot extends EasyCommand {
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
