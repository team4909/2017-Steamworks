package org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class ShiftingRobotDrive extends RobotDrive {
	private DoubleSolenoid shiftSolenoid;
	
	public ShiftingRobotDrive(SpeedController leftMotor, SpeedController rightMotor, boolean inverted, boolean safety, DoubleSolenoid sol) {
		super(leftMotor, rightMotor, inverted, safety);
		
		shiftSolenoid = sol;
	}
	public ShiftingRobotDrive(SpeedController frontLeftMotor, SpeedController rearLeftMotor,
			SpeedController frontRightMotor, SpeedController rearRightMotor, boolean inverted, boolean safety, DoubleSolenoid sol) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor, inverted, safety);
		
		shiftSolenoid = sol;
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
