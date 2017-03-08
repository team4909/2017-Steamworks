package org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDCommand;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDConstants;

public class DriveDistance extends PIDCommand {
	double target;
	double maxPow;

    public DriveDistance(double targetDist) {
    	this.target = targetDist; 
    	
    	this.pidController.changePIDGains(new PIDConstants(0.15, 0, 0, 0.8));
    }
    protected void initialize(){
    	super.initialize();
    	maxPow = 0;
    }
    protected void usePID() {
    	
		double leftDistance 	= Robot.drivetrain.getLeftEncDistance();
		double rightDistance 	= Robot.drivetrain.getRightEncDistance();
		
		double leftPow = this.pidController.calcPID(target, leftDistance, 2);
		double rightPow = this.pidController.calcPID(target, rightDistance, 2);

		if(Math.abs(leftPow)>maxPow)
			leftPow=maxPow*Math.signum(leftPow);
		if(Math.abs(rightPow)>maxPow)
			rightPow=maxPow*Math.signum(rightPow);
		
		maxPow+=Robot.drivetrain.voltageRamp(2);
		
		Robot.drivetrain.robotDrive.tankDrive(
			leftPow,
			rightPow
		);	
    }
}
