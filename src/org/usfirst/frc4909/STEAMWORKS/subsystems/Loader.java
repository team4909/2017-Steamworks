package org.usfirst.frc4909.STEAMWORKS.subsystems;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.utils.PIDConstants;
import org.usfirst.frc4909.STEAMWORKS.utils.PotentiometerPIDSubsystem;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController; 

public class Loader extends PotentiometerPIDSubsystem {
    public AnalogPotentiometer getPotentiometer(){
    	return RobotMap.loaderPivotPot;
    }
    
    public SpeedController getMotorController(){
    	return RobotMap.loaderMotor;
    }
    
    public double[] getPositions(){
    	return Robot.config.loaderAngles;
    }
    
    public PIDConstants getPID(){
    	return new PIDConstants(0.08, 0, 0, 0.3);
    }
}