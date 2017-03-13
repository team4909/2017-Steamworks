package org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;

public class ShiftingRobotDrive extends RobotDrive {
	private DoubleSolenoid shiftSolenoid;
	private Solenoid shiftSolenoidSingle;
	private boolean single = false;

	public ShiftingRobotDrive(SpeedController leftMotor, SpeedController rightMotor, boolean inverted, boolean safety,
			DoubleSolenoid sol) {
		super(leftMotor, rightMotor, inverted, safety);

		shiftSolenoid = sol;
	}

	public ShiftingRobotDrive(SpeedController leftMotor, SpeedController rightMotor, boolean inverted, boolean safety,
			Solenoid sol) {
		super(leftMotor, rightMotor, inverted, safety);
		single = true;
		shiftSolenoidSingle = sol;
	}

	public ShiftingRobotDrive(SpeedController frontLeftMotor, SpeedController rearLeftMotor,
			SpeedController frontRightMotor, SpeedController rearRightMotor, boolean inverted, boolean safety,
			DoubleSolenoid sol) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor, inverted, safety);

		shiftSolenoid = sol;
	}

	public void shift() {
		if (single) {
			if(shiftSolenoidSingle.get() == true){
				shiftSolenoidSingle.set(false);
			}
			else
				shiftSolenoidSingle.set(true);

		} else if (shiftSolenoid.get() == Value.kReverse)
			shiftSolenoid.set(Value.kForward);
		else
			shiftSolenoid.set(Value.kReverse);
	}

	public static enum Gear {
		Low, High
	}
	
	public boolean getSingleState(){
		return shiftSolenoidSingle.get();
	}
	
	public Gear getState(){
		if(single){
		if(getSingleState())
			return Gear.High;
		return Gear.Low;
		}
		else
			if(shiftSolenoid.get() == Value.kForward){
				return Gear.High;
			}
		return Gear.Low;
	}

	public void shift(Gear gear) {
		if(single){
			if (gear == Gear.High)
				shiftSolenoidSingle.set(true);
			else
				shiftSolenoidSingle.set(false);
		}
		else if (gear == Gear.High)
			shiftSolenoid.set(Value.kForward);
		else
			shiftSolenoid.set(Value.kReverse);
	}
}
