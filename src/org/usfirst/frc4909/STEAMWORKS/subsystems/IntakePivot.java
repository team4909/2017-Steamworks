package org.usfirst.frc4909.STEAMWORKS.subsystems;

import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.Potentiometer.PotentiometerPIDController;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.Potentiometer.PotentiometerPIDSubsystem;

public class IntakePivot extends PotentiometerPIDSubsystem {
	public IntakePivot(){}

	public PotentiometerPIDController getPotentiometerPIDController() {
		return RobotMap.intakePivotPotPIDController;
	}

}
