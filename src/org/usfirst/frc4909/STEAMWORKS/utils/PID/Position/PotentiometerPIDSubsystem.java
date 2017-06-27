package org.usfirst.frc4909.STEAMWORKS.utils.PID.Position;

import org.usfirst.frc4909.STEAMWORKS.utils.Subsystem;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class PotentiometerPIDSubsystem extends Subsystem {
	private double targetTime;
	public int targetPosition = 0;
	
    public final PIDController potPIDcontroller = new PIDController(this.getPotentiometerPIDController());
    
	public abstract PotentiometerPIDController getPotentiometerPIDController();
	
	public double getAngle(){
    	return this.getPotentiometerPIDController().getPot().get();
    }
	
	public void setSpeed(double speed){
		this.getPotentiometerPIDController().getMotor().set(speed);
	}

	public void initPID(){
    		targetTime = Timer.getFPGATimestamp();
    	
    		potPIDcontroller.resetPID();
	}
	
	public void setTargetPosition(int position){
		targetPosition = position;
	}
	
	public void setPosition(int position){
		potPIDcontroller.atTarget = false;
		
		double targetAngle = this.getPotentiometerPIDController().getPositions()[position];
		double currentAngle = this.getAngle();
		double pow = potPIDcontroller.calcPID(targetAngle, currentAngle, 2);
		this.getPotentiometerPIDController().getMotor().set(pow);
		
		if(!potPIDcontroller.isDone())
			targetTime = Timer.getFPGATimestamp();
	}
	//true for + slow, false for - slow
	public void setPosition(int position, boolean slowDirection){
		potPIDcontroller.atTarget = false;
		
		double targetAngle = this.getPotentiometerPIDController().getPositions()[position];
		double currentAngle = this.getAngle();
		double pow = potPIDcontroller.calcPID(targetAngle, currentAngle, 2);
		if(pow>0 && slowDirection)
			pow=pow*.9;
		else if (pow<0 && !slowDirection)
			pow=pow*.9;
		this.getPotentiometerPIDController().getMotor().set(pow);
		
		if(!potPIDcontroller.isDone())
			targetTime = Timer.getFPGATimestamp();
	}
	
	public void setPosition(double location){
		potPIDcontroller.atTarget = false;
		
		double targetAngle = location;
		double currentAngle = this.getAngle();
		double pow = potPIDcontroller.calcPID(targetAngle, currentAngle, 2);
		this.getPotentiometerPIDController().getMotor().set(pow);
		SmartDashboard.putNumber("potpow", pow);
		
//		if(!potPIDcontroller.isDone())
			targetTime = Timer.getFPGATimestamp();
	}

	
	public boolean isFinished(){
		return Timer.getFPGATimestamp() - targetTime > .5;
	}
}
