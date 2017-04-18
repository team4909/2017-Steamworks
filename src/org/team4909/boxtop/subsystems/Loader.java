package org.team4909.boxtop.subsystems;

import org.team4909.boxtop.RobotMap;
import org.team4909.utils.PID.Position.PotentiometerPIDController;
import org.team4909.utils.PID.Position.PotentiometerPIDSubsystem;

public class Loader extends PotentiometerPIDSubsystem {
    public PotentiometerPIDController getPotentiometerPIDController(){
    	return RobotMap.loaderPotPIDController;
    }
}