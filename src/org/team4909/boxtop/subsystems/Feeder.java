package org.team4909.boxtop.subsystems;

import org.team4909.boxtop.RobotMap;
import org.team4909.utils.Subsystem;

import edu.wpi.first.wpilibj.SpeedController;

public class Feeder extends Subsystem {
    private final SpeedController feederMotor = RobotMap.feederFeederMotor;

    public void startFeed(){
    	feederMotor.set(-0.5);
    }
    
    public void stopFeed(){
    	feederMotor.set(0);
    }
}