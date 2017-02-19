package org.usfirst.frc4909.STEAMWORKS.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.commands.drive.*;
import org.usfirst.frc4909.STEAMWORKS.utils.Subsystem;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain.NavX;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain.RobotDrive;

public class Drivetrain extends Subsystem {
	//in inches
	private double wheelDiameter = 4.0;
	private double pulsesPerRev = 1440.0;

	public RobotDrive robotDrive = RobotMap.drivetrainRobotDrive;
	public NavX navx = RobotMap.navx;
	
    private final Encoder leftEncoder = RobotMap.drivetrainLeftEncoder;
    private final Encoder rightEncoder = RobotMap.drivetrainRightEncoder;
    
    private final DoubleSolenoid shiftSolenoid = RobotMap.shiftSolenoid;
    
    private final double ENCODER_CONSTANT = 3.0;
   
    public void initDefaultCommand() {
        setDefaultCommand(new DriveCommand());
    }

	public void moveTank(){
	    double leftY = Robot.oi.leftDriveJoystick.getThresholdAxis(1);
	    double rightY = Robot.oi.rightDriveJoystick.getThresholdAxis(1);
	    	
    	robotDrive.tankDrive(leftY, rightY);
    }
	
	public void moveArcade(){
	    double power = 	Robot.oi.leftDriveJoystick.getThresholdAxis(1);
		double rot = 	Robot.oi.leftDriveJoystick.getThresholdAxis(0);
	    	
		robotDrive.arcadeDrive(power, rot);
    }
    
    public void stop(){
    	robotDrive.stop();
    }
	
    public double getLeftEncDistance(){
    	return ENCODER_CONSTANT*(leftEncoder.getRaw()/pulsesPerRev)*(Math.PI*wheelDiameter);
    }
    
    public double getRightEncDistance(){
    	return ENCODER_CONSTANT*(rightEncoder.getRaw()/pulsesPerRev)*(Math.PI*wheelDiameter);
    }
    
    public void shift(){
    	if(shiftSolenoid.get() == Value.kReverse)
        	shiftSolenoid.set(Value.kForward);
    	else
        	shiftSolenoid.set(Value.kReverse);
    }
    
    public void shiftLow(){
    	shiftSolenoid.set(Value.kReverse);
    }
    
    public void shiftHigh(){
    	shiftSolenoid.set(Value.kForward);
    }
}