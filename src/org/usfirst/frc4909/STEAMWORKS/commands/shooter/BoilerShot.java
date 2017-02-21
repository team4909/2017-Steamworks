package org.usfirst.frc4909.STEAMWORKS.commands.shooter;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BoilerShot extends Command {
    public BoilerShot() {
        requires(Robot.shooter);
    }
    
    protected void initialize() {
    	SmartDashboard.putBoolean("Ready To Shoot", false);
    }

    protected void execute() {
		Robot.shooter.setRPM(2900.0);
		
		SmartDashboard.putNumber("Current Shooter RPM", Robot.shooter.getRPM());
		
		if(Robot.shooter.getRPM() >= 2900.0 * 0.9)
			SmartDashboard.putBoolean("Ready To Shoot", true);
    }
    
    protected void end() {
		Robot.shooter.setVoltage(0);
		
		SmartDashboard.putBoolean("Ready To Shoot", false);
    }
}