package org.team4909.boxtop.subsystems;

import org.team4909.boxtop.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Feeder extends Subsystem {
    private final SpeedController feederMotor = RobotMap.feederFeederMotor;

    public void startFeed(){
    	feederMotor.set(-0.5);
    }
    
    public void stopFeed(){
    	feederMotor.set(0);
    }

	@Override
	protected void initDefaultCommand() {}
}