package org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDCommand;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDConstants;

public class DriveStraightAuto extends PIDCommand {
	double target;

    public DriveStraightAuto(double targetDist) {
    	this.target = targetDist; 
    	
    	this.pidController.changePIDGains(new PIDConstants(0.15, 0, 0, 0.8));
    }

    protected void usePID() {
		double leftDistance 	= Robot.drivetrain.getLeftEncDistance();
		double rightDistance 	= Robot.drivetrain.getRightEncDistance();

		Robot.drivetrain.robotDrive.tankDrive(
			this.pidController.calcPID(target, leftDistance, 2),
			this.pidController.calcPID(target, rightDistance, 2)
		);	
    }
}
