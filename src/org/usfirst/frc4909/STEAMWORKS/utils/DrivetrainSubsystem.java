package org.usfirst.frc4909.STEAMWORKS.utils;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.config.Config;
import org.usfirst.frc4909.STEAMWORKS.utils.Subsystem;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDController;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;

public abstract class DrivetrainSubsystem extends Subsystem {
	private boolean inversion = false;
	
	private double rotateP = 0.00000;
	private double rotateI = 0.00000;
	private double rotateD = 0.00000;
	private final PIDController rotatePID = new PIDController(rotateP, rotateI, rotateD,.5);
	
	public abstract RobotDrive getRobotDrive();
	public abstract AHRS getNavX();
	public abstract double getLeftEncDistance();
	public abstract double getRightEncDistance();
	
	public void moveTank(){
	    double leftY = Robot.oi.getLeftDriveJoystick().getThresholdAxis(1, Config.joystickDeadzone);
	    double rightY = Robot.oi.getRightDriveJoystick().getThresholdAxis(1, Config.joystickDeadzone);
	    	
    	if(inversion)
        	this.getRobotDrive().tankDrive(-rightY, -leftY);
    	else
    		this.getRobotDrive().tankDrive(leftY, rightY);
    }
	
	public void moveArcade(){
		double rot = Robot.oi.getLeftDriveJoystick().getThresholdAxis(0, Config.joystickDeadzone);
	    double power = Robot.oi.getRightDriveJoystick().getThresholdAxis(1, Config.joystickDeadzone);
	    	
    	if(inversion) 
        	this.getRobotDrive().arcadeDrive(-power, -rot);
    	else
    		this.getRobotDrive().arcadeDrive(power, rot);
    }
    
    public boolean getInversion(){
    	return inversion;
    }
    
    public void setInversion(boolean newInversion){
    	inversion = newInversion;
    }
    
    public void stop(){
    	this.getRobotDrive().drive(0, 0);
    }
    
    /**
     * Rotate to a Given Angle using the NavX, and PID
     * @param angle Angle in degrees
     */
    public void rotateAngle(double angle, double rotateP, double rotateI, double rotateD){
    	// Default PID is 0.15, 0.0, 0.0
    	rotatePID.resetPID();

    	double targetTime=Timer.getFPGATimestamp();
    	while(Timer.getFPGATimestamp()-targetTime<.5){
    		rotatePID.atTarget=false;
    		
        	rotatePID.changePIDGains(rotateP, rotateI, rotateD);

    		double currentAngle = this.getNavX().getYaw();
    		if(Math.abs(angle-currentAngle) > 180)
    			angle = angle + (currentAngle / Math.abs(currentAngle))*360;
    		
    		this.getRobotDrive().arcadeDrive(0, rotatePID.calcPID(angle, currentAngle, 4));
    		
    		if(!rotatePID.isDone())
    			targetTime=Timer.getFPGATimestamp();
    	}
    }
    
    public void rotateRobot(double target, double currentAngle, double threshold){
		this.getRobotDrive().arcadeDrive(0, rotatePID.calcPID(target, currentAngle, threshold));
	}
}