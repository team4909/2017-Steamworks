package org.usfirst.frc4909.STEAMWORKS.utils;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.config.Config;
import org.usfirst.frc4909.STEAMWORKS.utils.Subsystem;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDController;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.NavX;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.RobotDrive;

public abstract class DrivetrainSubsystem extends Subsystem {
	private final PIDController rotatePID = new PIDController(0, 0, 0,.5);
	
	public abstract RobotDrive getRobotDrive();
	public abstract NavX getNavX();
	public abstract double getLeftEncDistance();
	public abstract double getRightEncDistance();
	
	public void moveTank(){
	    double leftY = Robot.oi.leftDriveJoystick.getThresholdAxis(1, Config.joystickDeadzone);
	    double rightY = Robot.oi.rightDriveJoystick.getThresholdAxis(1, Config.joystickDeadzone);
	    	
    	this.getRobotDrive().tankDrive(leftY, rightY);
    }
	
	public void moveArcade(){
	    double power = 	Robot.oi.leftDriveJoystick.getThresholdAxis(1, Config.joystickDeadzone);
		double rot = 	Robot.oi.leftDriveJoystick.getThresholdAxis(0, Config.joystickDeadzone);
	    	
    	this.getRobotDrive().arcadeDrive(power, rot);
    }
    
    public void stop(){
    	this.getRobotDrive().stop();
    }
    
    public void rotateRobot(double target, double currentAngle, double threshold){
		this.getRobotDrive().arcadeDrive(0, rotatePID.calcPID(target, currentAngle, threshold));
	}
}