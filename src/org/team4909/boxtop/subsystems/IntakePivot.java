package org.team4909.boxtop.subsystems;

import org.team4909.boxtop.RobotMap;
import org.team4909.boxtop.commands.intake.PivotControl;
import org.team4909.utils.PID.Position.EasyPotentiometerPIDController;
import org.team4909.utils.PID.Position.EasyPotentiometerPIDSubsystem;

public class IntakePivot extends EasyPotentiometerPIDSubsystem {
	public IntakePivot(){}
	
	public EasyPotentiometerPIDController getPotentiometerPIDController() {
		return RobotMap.intakePivotPotPIDController;
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new PivotControl());
    }

}
