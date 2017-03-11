package org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDCommand;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDConstants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Rotate extends PIDCommand {
	double target;
	double maxPow;
	boolean autoRan;


	boolean useAlliance = false;
    public Rotate(double targetAngle) {
        autoRan=false;

    	this.target = targetAngle; 
    	
    	this.pidController.changePIDGains(new PIDConstants(0.14, 0, 0.1, 0.6));
    }
    //Angles are based on red side, negate if blue
    public Rotate(double targetAngle, boolean usingAlliance) {
        autoRan=false;

    	this.target = targetAngle; 
    	
    	this.pidController.changePIDGains(new PIDConstants(0.14, 0, 0.1, 0.6));
    	useAlliance = usingAlliance;

    }
    
    protected void initialize(){
    	super.initialize();
    	if(useAlliance && Robot.drivetrain.isBlue() && !autoRan)
    		this.target = -this.target;
    	maxPow = 0;
    	autoRan=true;


    }
    protected void usePID() {
    	SmartDashboard.putNumber("Auto Stage", target);

    	double currentAngle = Robot.drivetrain.navx.getAngle();
    	
    	if(Math.abs(target - currentAngle) > 180)
    		target = target + (currentAngle / Math.abs(currentAngle))*360;
    	
    	SmartDashboard.putNumber("Current Angle", currentAngle);
    	double pow = this.pidController.calcPID(target, currentAngle, 1.5);
		if(Math.abs(pow)>maxPow)
			pow=maxPow*Math.signum(pow);
		
		maxPow+=Robot.drivetrain.voltageRamp(.75);

    	Robot.drivetrain.robotDrive.arcadeDrive(
			0, // Power
			pow // Rot.
		);
    }
}
