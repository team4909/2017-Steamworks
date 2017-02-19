package org.usfirst.frc4909.STEAMWORKS.subsystems;

import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.utils.Subsystem;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.motorcontrollers.SpeedController;

public class IntakePolycord extends Subsystem {
    private final SpeedController intakeMotor = RobotMap.intakeIntakeMotor;
    
    public void intakeIn(){
    	intakeMotor.set(.525);
    }
    
    public void intakeOut(){
    	intakeMotor.set(-.525);
    }
    
    public void intakeStop(){
    	intakeMotor.set(0);
    }
}