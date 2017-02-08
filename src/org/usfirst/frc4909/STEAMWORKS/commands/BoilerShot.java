package org.usfirst.frc4909.STEAMWORKS.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.RobotMap;

public class BoilerShot extends Command {
    public BoilerShot() {
    	requires(Robot.shooter);
        
        // Change this to set target velocity for the shooter, in RPMs
    }
    
    protected void initialize() {
    	SmartDashboard.putNumber("Target Velocity", 2900.0);
    	SmartDashboard.putBoolean("IsReadyToShoot", false);
        
		Robot.shooter.shooterPID.resetPID();
    }

    protected void execute() {
		Robot.shooter.setRPM(SmartDashboard.getNumber("Target Velocity", 2900.0));
        
		SmartDashboard.putNumber("currentSpeed", Robot.shooter.getRPM());
		
        if(Robot.shooter.getRPM() >= SmartDashboard.getNumber("Target Velocity", 2900.0) * 0.9)
			SmartDashboard.putBoolean("IsReadyToShoot", true);
    }

    protected boolean isFinished() {
    	return false;
    }

    protected void end() {
		Robot.shooter.shooterPID.resetPID();
		Robot.shooter.setRPM(0);
		
		SmartDashboard.putBoolean("IsReadyToShoot", false);
    }

    protected void interrupted() {
    	end();
    }
}
