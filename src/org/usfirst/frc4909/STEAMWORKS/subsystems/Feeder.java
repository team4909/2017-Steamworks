package org.usfirst.frc4909.STEAMWORKS.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.commands.*;

public class Feeder extends Subsystem {
    private final SpeedController feederMotor = RobotMap.feederFeederMotor;
    
    public void startFeed(){
    	feederMotor.set(0.5);
    }
    
    public void stopFeed(){
    	feederMotor.set(0);
    }

    public void initDefaultCommand() {}
}