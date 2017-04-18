package org.team4909.boxtop.commands.drive.semiauto;

import org.team4909.boxtop.Robot;
import org.team4909.boxtop.RobotMap;
import org.team4909.utils.PID.PIDCommand;
import org.team4909.utils.PID.PIDConstants;
import org.team4909.utils.PID.PIDController;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveDistance extends PIDCommand {
	double target;
	double initAngle;
	double maxPow;
	PIDController rotatePID =new PIDController( new PIDConstants(1, 0, 0, 0.4));
;

    public DriveDistance(double targetDist) {
    	this.target = targetDist; 
    	
    	this.pidController.changePIDGains(new PIDConstants(0.08, 0, 0, 1));

    	
    }
    protected void initialize(){
    	super.initialize();
    	RobotMap.drivetrainLeftEncoder.reset();
    	RobotMap.drivetrainRightEncoder.reset();

    	maxPow = 0;
//    	initAngle = Robot.drivetrain.navx.getYaw();
    	this.rotatePID.resetPID();
    	initAngle = Robot.drivetrain.navx.getYaw();
    	SmartDashboard.putNumber("Init Angle", initAngle);
    }
    protected void usePID() {
    	SmartDashboard.putNumber("Auto Stage", target);
    	
		double leftDistance 	= Robot.drivetrain.getLeftEncDistance();
		double rightDistance 	= Robot.drivetrain.getRightEncDistance();
		
		double leftPow = this.pidController.calcPID(target, leftDistance, 2);
		double rightPow = this.pidController.calcPID(target, rightDistance, 2);
		

		if(Math.abs(leftPow)>maxPow)
			leftPow=maxPow*Math.signum(leftPow);
		if(Math.abs(rightPow)>maxPow)
			rightPow=maxPow*Math.signum(rightPow);
		
		maxPow+=Robot.drivetrain.voltageRamp(1);
		
//		Robot.drivetrain.robotDrive.tankDrive(
//			leftPow,
//			rightPow
//		);	
		Robot.drivetrain.robotDrive.arcadeDrive(
				(leftPow+rightPow)/2,
				this.rotatePID.calcPID(initAngle, Robot.drivetrain.navx.getYaw(), 1)
			);	
		
    }
}
