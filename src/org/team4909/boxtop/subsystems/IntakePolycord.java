package org.team4909.boxtop.subsystems;

import org.team4909.boxtop.RobotMap;
import org.team4909.utils.Subsystem;
import org.team4909.utils.devices.motorcontrollers.SpeedController;

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