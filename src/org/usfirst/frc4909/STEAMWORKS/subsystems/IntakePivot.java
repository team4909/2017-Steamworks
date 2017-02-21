package org.usfirst.frc4909.STEAMWORKS.subsystems;

import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.Position.PotentiometerPIDController;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.Position.PotentiometerPIDSubsystem;

public class IntakePivot extends PotentiometerPIDSubsystem {
	public PotentiometerPIDController getPotentiometerPIDController() {
		return RobotMap.intakePivotPotPIDController;
	}

}
