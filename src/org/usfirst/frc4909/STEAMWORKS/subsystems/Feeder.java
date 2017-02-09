package org.usfirst.frc4909.STEAMWORKS.subsystems;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.utils.Subsystem;

import edu.wpi.first.wpilibj.SpeedController;

public class Feeder extends Subsystem {
    private final SpeedController feederMotor = RobotMap.feederFeederMotor;

    public void startFeed(){
    	feederMotor.set(Robot.config.getFeederMaxSpeed());
    }
    
    public void stopFeed(){
    	feederMotor.set(0);
    }
}