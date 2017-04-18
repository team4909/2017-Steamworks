package org.team4909.boxtop.subsystems;

import org.team4909.boxtop.RobotMap;
import org.team4909.boxtop.commands.climb.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
    private final SpeedController climberMotorController = RobotMap.climberClimberMotorController;
    private final DigitalInput climbSwitch = RobotMap.climberSwitch;
    private final PowerDistributionPanel pdp= RobotMap.PDP;

    public void initDefaultCommand() {
    	setDefaultCommand(new ClimbManual());
    }
    
    public void climb(double speed){
    	climberMotorController.set(speed);
    }
    
    public boolean getSwitch() {
        return climbSwitch.get();
    }
    
    public double getCurrent(){
    	return pdp.getCurrent(3);
    }
}