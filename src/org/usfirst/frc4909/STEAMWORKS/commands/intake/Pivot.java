package org.usfirst.frc4909.STEAMWORKS.commands.intake;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

public class Pivot extends Command {
	public Pivot() {
		requires(Robot.intakePolycord);
		requires(Robot.intakePivot);
	}
	
	protected void initialize() {
    	Robot.intakePivot.initPID();
    }

    protected void execute() {
    	if(Robot.intakePivot.currentPosition != 0)
    		Robot.intakePivot.setPosition(0);
    	else
    		Robot.intakePivot.setPosition(1);
    }

    protected boolean isFinished() {
        return Robot.intakePivot.isFinished();
    }
}
