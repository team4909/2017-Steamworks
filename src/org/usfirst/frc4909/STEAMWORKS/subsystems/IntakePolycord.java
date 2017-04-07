package org.usfirst.frc4909.STEAMWORKS.subsystems;

import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.utils.Subsystem;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.motorcontrollers.SpeedController;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class IntakePolycord extends Subsystem {
    private final SpeedController intakeMotor = RobotMap.intakeIntakeMotor;
    private final PowerDistributionPanel pdp = RobotMap.PDP; 
    public void intakeIn(double power){
    	intakeMotor.set(power);
    }
    
    public void intakeOut(){
    	intakeMotor.set(-.7);
    }
    
    public void intakeStop(){
    	intakeMotor.set(0);
    }
    
    public double getCurrent(){
    	return pdp.getCurrent(13);
    	
    }
}