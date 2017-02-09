package org.usfirst.frc4909.STEAMWORKS.subsystems;

import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.PID.PIDController;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Loader extends Subsystem {
	private final double lP = 0.005;
	private final double lI = 0;
	private final double lD = 0;
	
	private final AnalogPotentiometer loaderPivotPot = RobotMap.loaderPivotPot;
    private final SpeedController loaderMotor = RobotMap.loaderMotor;

    private final PIDController loaderPID = new PIDController(lP,lI,lD,0.3);
    
    public void initDefaultCommand() {}
}

