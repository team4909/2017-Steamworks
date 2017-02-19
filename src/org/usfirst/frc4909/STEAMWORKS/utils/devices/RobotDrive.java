package org.usfirst.frc4909.STEAMWORKS.utils.devices;

import edu.wpi.first.wpilibj.SpeedController;

public class RobotDrive extends edu.wpi.first.wpilibj.RobotDrive {
	public RobotDrive(SpeedController leftMotor, SpeedController rightMotor) {
		super(leftMotor, rightMotor);
	}
	
	public RobotDrive(SpeedController leftMotor, SpeedController rightMotor, boolean inverted, boolean safety) {
		super(leftMotor, rightMotor);

		this.setInvertedMotor(RobotDrive.MotorType.kRearLeft, inverted);
	    this.setInvertedMotor(RobotDrive.MotorType.kRearRight, inverted);
	    
	    this.setSafetyEnabled(safety);
	}

	public RobotDrive(int frontLeftMotor, int rearLeftMotor, int frontRightMotor, int rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
	}

	public RobotDrive(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor, 
			SpeedController rearRightMotor, boolean inverted, boolean safety) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

		this.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, inverted);
	    this.setInvertedMotor(RobotDrive.MotorType.kFrontRight, inverted);
		this.setInvertedMotor(RobotDrive.MotorType.kRearLeft, inverted);
	    this.setInvertedMotor(RobotDrive.MotorType.kRearRight, inverted);
	    
	    this.setSafetyEnabled(safety);
	}
}
