package org.usfirst.frc4909.STEAMWORKS.subsystems;

import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.commands.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Climber extends Subsystem {
    private final SpeedController climberMotorController = RobotMap.climberClimberMotorController;
    private final DigitalInput climbSwitch = RobotMap.climberSwitch;
    private final PowerDistributionPanel PDP = RobotMap.PDP;

    public void initDefaultCommand() {
    	setDefaultCommand(new ClimbCommand());
    }
    
    public void climb(double speed){
    	SmartDashboard.putNumber("Current", PDP.getCurrent(11));
    	
    	climberMotorController.set(speed);
    }
    
    public boolean getSwitch() {
        return (climbSwitch.get());
    }
}