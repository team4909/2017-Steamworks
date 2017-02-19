package org.usfirst.frc4909.STEAMWORKS.subsystems;

import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.utils.Subsystem;

import edu.wpi.first.wpilibj.SpeedController;

public class Intake extends Subsystem {
    private final SpeedController intakeMotor = RobotMap.intakeIntakeMotor;
    private final SpeedController centerMotor = RobotMap.intakeCenterMotor;
    
    public void intakeIn(){
    	intakeMotor.set(.525);
    	centerMotor.set(-.8);
    }
    
    public void intakeOut(){
    	intakeMotor.set(-.525);
    	centerMotor.set(.8);
    }
    
    public void intakeStop(){
    	intakeMotor.set(0);
    	centerMotor.set(0);
    }
}