package org.team4909.boxtop.commands.intake;

import org.team4909.boxtop.Robot;
import org.team4909.utils.EasyCommand;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PivotControl extends EasyCommand {
	boolean holdPosition;
	double location;
	public PivotControl() {
//		requires(Robot.intakePolycord);
		requires(Robot.intakePivot);
	}
	
	protected void initialize() {
    	Robot.intakePivot.initPID();
    	holdPosition=false;
    	location=Robot.intakePivot.getAngle();
    }

    protected void execute() {
    		SmartDashboard.putNumber("Intake Pivot Setpoint", location);
    		if(SmartDashboard.getBoolean("Intake Pivot Manual Override",false)){
    			if(Robot.oi.manipulatorGamepad.getThresholdAxis(1, .25)>0)
    				Robot.intakePivot.setSpeed(Robot.oi.manipulatorGamepad.getThresholdAxis(1, 0.25)*0.2);
    			else
    				Robot.intakePivot.setSpeed(Robot.oi.manipulatorGamepad.getThresholdAxis(1, 0.25)*0.5);

    		}
    else{
    		if(Robot.oi.manipulatorGamepad.getThresholdAxis(1, .25)==0){
    			SmartDashboard.putBoolean("Hold Intake Position", true);
    			if(Robot.oi.manipulatorGamepad.getRawButton(5)){
        			Robot.intakePivot.setPosition(0);
        			holdPosition=false;
    			}
    			else if(!holdPosition){
    				location=Robot.intakePivot.getAngle();
        			Robot.intakePivot.setPosition(location);

    				holdPosition=true;
    			}
    			else
    				Robot.intakePivot.setPosition(location);
    		}
    		
    		else{
    			holdPosition=false;
    			SmartDashboard.putBoolean("Hold Intake Position",false);
    			if(Robot.oi.manipulatorGamepad.getThresholdAxis(1, .25)>0)
    				Robot.intakePivot.setSpeed(Robot.oi.manipulatorGamepad.getThresholdAxis(1, 0.25)*0.2);
    			else
    				Robot.intakePivot.setSpeed(Robot.oi.manipulatorGamepad.getThresholdAxis(1, 0.25)*0.5);
    		}
    }
    }

    protected boolean isFinished() {
        return false; //return Robot.intakePivot.isFinished();
    }
}
