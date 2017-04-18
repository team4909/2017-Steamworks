package org.team4909.boxtop.commands.intake;

import org.team4909.boxtop.Robot;
import org.team4909.utils.EasyCommand;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PivotSched extends EasyCommand {
	public PivotSched() {
//		requires(Robot.intakePolycord);
		requires(Robot.intakePivot);
	}
	
	protected void initialize() {
    	Robot.intakePivot.initPID();
    }

    protected void execute() {
    	if(SmartDashboard.getBoolean("Intake Pivot Manual Override", false))
    		Robot.intakePivot.setSpeed(Robot.oi.manipulatorGamepad.getThresholdAxis(1, 0.15)*0.25);
    	else
    		Robot.intakePivot.setPosition(Robot.intakePivot.targetPosition,true);
    	
    	SmartDashboard.putBoolean("Intake Pivot Down", Robot.intakePivot.targetPosition==1);
    }

    protected boolean isFinished() {
        return false; //return Robot.intakePivot.isFinished();
    }
}
