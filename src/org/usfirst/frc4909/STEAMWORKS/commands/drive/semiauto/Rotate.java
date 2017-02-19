package org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDCommand;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDConstants;

public class Rotate extends PIDCommand {
	double target;

    public Rotate(double targetAngle) {
    	this.target = targetAngle; 
    	
    	this.pidController.changePIDGains(new PIDConstants(0, 0, 0, 0.5));
    }

    protected void usePID() {
		double currentAngle = Robot.drivetrain.navx.getAngle();
		
		Robot.drivetrain.robotDrive.arcadeDrive(
			0, // Power
			this.pidController.calcPID(target, currentAngle, 4) // Rot.
		);
    }
}
