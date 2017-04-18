package org.team4909.boxtop.subsystems;

import org.team4909.boxtop.RobotMap;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakePolycord extends Subsystem {
    private final edu.wpi.first.wpilibj.SpeedController intakeMotor = RobotMap.intakeIntakeMotor;
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

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}