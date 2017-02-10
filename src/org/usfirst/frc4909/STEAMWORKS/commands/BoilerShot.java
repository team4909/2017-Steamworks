package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BoilerShot extends Command {
    public BoilerShot() {
        requires(Robot.shooter);
    }
    
    protected void initialize() {
    	SmartDashboard.putNumber("Target Velocity",2900.0);
    	SmartDashboard.putBoolean("ReadyToShoot", false);
		Robot.shooter.shooterPID.resetPID();
    }

    protected void execute() {
		Robot.shooter.setRPM(SmartDashboard.getNumber("Target Velocity", 2900.0));
		
		SmartDashboard.putNumber("currentSpeed", Robot.shooter.getRPM());
		
		if(Robot.shooter.getRPM() >= SmartDashboard.getNumber("Target Velocity", 2900.0)*0.9)
			SmartDashboard.putBoolean("ReadyToShoot", true);
    }
    
    protected void end() {
		Robot.shooter.shooterPID.resetPID();
		Robot.shooter.setRPM(0);
		
		SmartDashboard.putBoolean("ReadyToShoot", false);
    }
}