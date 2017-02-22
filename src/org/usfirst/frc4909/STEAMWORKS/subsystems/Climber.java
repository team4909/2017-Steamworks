package org.usfirst.frc4909.STEAMWORKS.subsystems;

import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.commands.climb.*;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem {
    private final SpeedController climberMotorController = RobotMap.climberClimberMotorController;
    private final DigitalInput climbSwitch = RobotMap.climberSwitch;

    public void initDefaultCommand() {
    	//setDefaultCommand(new ClimbManual());
    }
    
    public void climb(double speed){
    	climberMotorController.set(speed);
    }
    
    public boolean getSwitch() {
        return (climbSwitch.get());
    }
}