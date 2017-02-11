package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BoilerShot extends Command {
    public BoilerShot() {
        requires(Robot.shooter);
    }
    
    protected void initialize() {
    	SmartDashboard.putBoolean("ReadyToShoot", false);
    }

    protected void execute() {
		Robot.shooter.setRPM(Robot.config.boilerShotVelocity);
		
		SmartDashboard.putNumber("CurrentSpeed", Robot.shooter.getRPM());
		
		if(Robot.shooter.getRPM() >= Robot.config.boilerShotVelocity * Robot.config.boilerShotMinPercentage)
			SmartDashboard.putBoolean("ReadyToShoot", true);
    }
    
    protected void end() {
		Robot.shooter.setVoltage(0);
		
		SmartDashboard.putBoolean("ReadyToShoot", false);
    }
}