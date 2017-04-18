package org.team4909.boxtop.subsystems;

import org.team4909.boxtop.RobotMap;
import org.team4909.boxtop.commands.intake.PivotControl;
import org.team4909.utils.PID.Position.PotentiometerPIDController;
import org.team4909.utils.PID.Position.PotentiometerPIDSubsystem;

public class IntakePivot extends PotentiometerPIDSubsystem {
	public IntakePivot(){}
	
	public PotentiometerPIDController getPotentiometerPIDController() {
		return RobotMap.intakePivotPotPIDController;
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new PivotControl());
    }

}
