package org.usfirst.frc4909.STEAMWORKS.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;

import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.commands.drive.*;
import org.usfirst.frc4909.STEAMWORKS.utils.DrivetrainSubsystem;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDConstants;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDController;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.NavX;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.RobotDrive;

public class Drivetrain extends DrivetrainSubsystem {
	//in inches
	private double wheelDiameter = 4.0;
	private double pulsesPerRev = 1440.0;
    
    private final Encoder leftEncoder = RobotMap.drivetrainLeftEncoder;
    private final Encoder rightEncoder = RobotMap.drivetrainRightEncoder;
    
    private final DoubleSolenoid shiftSolenoid = RobotMap.shiftSolenoid;
    
    private final double ENCODER_CONSTANT = 3.0;
   
    public void initDefaultCommand() {
        setDefaultCommand(new DriveCommand());
    }

	public RobotDrive getRobotDrive() {
		return RobotMap.drivetrainRobotDrive;
	}
	
	public NavX getNavX(){
    	return RobotMap.navx;
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
    
    /*** Work on Moving Everything Below this into the Shared Drivetrain Code, After Being Tested***/
    private final PIDConstants encPIDConstants = new PIDConstants(0.15, 0, 0, 0.8);
    private final PIDController encPID = new PIDController(encPIDConstants);
    
    public void driveStraight(double target, double leftDistance, double rightDistance, double threshold){
		this.getRobotDrive().tankDrive(encPID.calcPID(target, leftDistance, threshold),encPID.calcPID(target, rightDistance, threshold));
	}
}