package org.team4909.utils.devices.drivetrain;

import org.team4909.boxtop.Robot;

import edu.wpi.first.wpilibj.SpeedController;

public class EasyRobotDrive extends edu.wpi.first.wpilibj.RobotDrive {
	private boolean inversion = false;
	
	public EasyRobotDrive(SpeedController leftMotor, SpeedController rightMotor) {
		super(leftMotor, rightMotor);
	}
	
	public EasyRobotDrive(SpeedController leftMotor, SpeedController rightMotor, boolean inverted, boolean safety) {
		super(leftMotor, rightMotor);

		this.setInvertedMotor(EasyRobotDrive.MotorType.kRearLeft, inverted);
	    this.setInvertedMotor(EasyRobotDrive.MotorType.kRearRight, inverted);
	    
	    this.setSafetyEnabled(safety);
	}

	public EasyRobotDrive(int frontLeftMotor, int rearLeftMotor, int frontRightMotor, int rearRightMotor) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
	}

	public EasyRobotDrive(SpeedController frontLeftMotor, SpeedController rearLeftMotor, SpeedController frontRightMotor, 
			SpeedController rearRightMotor, boolean inverted, boolean safety) {
		super(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

		this.setInvertedMotor(EasyRobotDrive.MotorType.kFrontLeft, inverted);
	    this.setInvertedMotor(EasyRobotDrive.MotorType.kFrontRight, inverted);
		this.setInvertedMotor(EasyRobotDrive.MotorType.kRearLeft, inverted);
	    this.setInvertedMotor(EasyRobotDrive.MotorType.kRearRight, inverted);
	    
	    this.setSafetyEnabled(safety);
	}
	
	public void tankDrive(double leftY, double rightY){
		if(inversion) 
        	super.tankDrive(-rightY, -leftY);
    	else
    		super.tankDrive(leftY, rightY);
    }
	
	public void arcadeDrive(double power, double rot){
		if(inversion) 
        	super.arcadeDrive(-power, rot);
    	else
    		super.arcadeDrive(power, rot);
    }
	
	public void invert(){
		inversion = !inversion;
	     if(inversion){
	        	Robot.server.setSource(Robot.loaderCam);
	        	Robot.leds.setColor(false, true, false);
	        	Robot.leds.setClimbed(true);
	     }
	        else{
	        	Robot.server.setSource(Robot.intakeCam);
	        	Robot.leds.setColor(true, true, true);
	        	Robot.leds.setClimbed(false);
	        }
	}
	
	//true = intake side
	//false = gear side

	public void invert(boolean state){
		if(state){
        	Robot.server.setSource(Robot.loaderCam);
        	Robot.leds.setColor(false, true, false);
        	Robot.leds.setClimbed(true);

		}
        else{
        	Robot.server.setSource(Robot.intakeCam);
        	Robot.leds.setColor(true, true, true);
        	Robot.leds.setClimbed(false);
        }			
		inversion = state;
	}
	
	public void stop(){
		this.drive(0, 0);
	}
}
