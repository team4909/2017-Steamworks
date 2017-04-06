package org.usfirst.frc4909.STEAMWORKS.subsystems;

import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.commands.intake.PivotControl;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.Position.PotentiometerPIDController;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.Position.PotentiometerPIDSubsystem;

public class IntakePivot extends PotentiometerPIDSubsystem {
	public IntakePivot(){}
	
	public PotentiometerPIDController getPotentiometerPIDController() {
		return RobotMap.intakePivotPotPIDController;
	}
	
    public void initDefaultCommand() {
        setDefaultCommand(new PivotControl());
    }

}
