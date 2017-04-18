package org.team4909.boxtop.commands.drive.semiauto;

import org.team4909.boxtop.Robot;
import org.team4909.utils.PID.PIDCommand;
import org.team4909.utils.PID.PIDConstants;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Rotate extends PIDCommand {
	double target;
	double maxPow;
	
	boolean hasRun = false;

	boolean useAlliance = false;
    public Rotate(double targetAngle) {
    	this.target = targetAngle; 
    	
    	this.pidController.changePIDGains(new PIDConstants(0.14, 0, 0.1, 0.6));
    }
    //Angles are based on red side, negate if blue
    public Rotate(double targetAngle, boolean usingAlliance) {
    		
    	this.target = targetAngle; 
    	
    	this.pidController.changePIDGains(new PIDConstants(0.14, 0, 0.1, 0.6));
    	useAlliance = usingAlliance;

    }
    
    protected void initialize(){
    	super.initialize();
    	if(useAlliance && Robot.drivetrain.isBlue() && !hasRun)
    		this.target = -this.target;
    	maxPow = 0;
    	hasRun=true;

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
