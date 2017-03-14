package org.usfirst.frc4909.STEAMWORKS.commands.shooter;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BoilerShot extends Command {
    public BoilerShot() {
        requires(Robot.shooter);
    }
    
    protected void initialize() {
//    	SmartDashboard.putBoolean("Ready to Shoot", false);
    	Robot.shooter.enable();
    }

    protected void execute() {
    	//Robot.shooter.setRPM(270.0);
    	if(!SmartDashboard.getBoolean("Shooter Manual Override", false)){
			Robot.shooter.setRPM(3500);
			SmartDashboard.putNumber("Current Shooter RPM", RobotMap.shooterMotorController.getSpeed());
			
			if(RobotMap.shooterMotorController.getSpeed() >= 3500.0 * 0.8)
				SmartDashboard.putBoolean("Ready to Shoot", true);
	    }
    	else{
    		double adjustedAxis = (-Robot.oi.climberJoystick.getRawAxis(3)+1)/2;

//    		double adjustedAxis = 5000*(-Robot.oi.climberJoystick.getRawAxis(3)+1)/2;
//    		SmartDashboard.putNumber("SetRPM", adjustedAxis);
//			SmartDashboard.putNumber("Current Shooter RPM", RobotMap.shooterMotorController.getSpeed());

        	if(adjustedAxis<.15)
        		adjustedAxis=0;
        	
//        	Robot.shooter.setVoltage(adjustedAxis);
			SmartDashboard.putBoolean("Ready to Shoot", true);

			Robot.shooter.setRPM(adjustedAxis);

    	}
    		
    }
    
    protected void end() {
		Robot.shooter.setVoltage(0);
		Robot.shooter.disable();
		SmartDashboard.putBoolean("Ready to Shoot", false);
    }
}