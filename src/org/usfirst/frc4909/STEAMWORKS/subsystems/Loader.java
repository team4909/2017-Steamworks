package org.usfirst.frc4909.STEAMWORKS.subsystems;

import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.PID.Potentiometer.PotentiometerPIDController;
import org.usfirst.frc4909.STEAMWORKS.PID.Potentiometer.PotentiometerPIDSubsystem;

public class Loader extends PotentiometerPIDSubsystem {
    public PotentiometerPIDController getPotentiometerPIDController(){
    	return RobotMap.loaderPotPIDController;
    }
}