package org.usfirst.frc4909.STEAMWORKS.utils;

import org.usfirst.frc4909.STEAMWORKS.utils.PIDController;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;

public abstract class PotentiometerPIDSubsystem extends Subsystem {
	private double targetTime;
	
    public final PIDController potPIDcontroller = new PIDController(this.getPID());
	
	public abstract AnalogPotentiometer getPotentiometer();
	public abstract SpeedController getMotorController();
	
	public abstract PIDConstants getPID();
	public abstract double[] getPositions();
	
	public double getAngle(){
    	return this.getPotentiometer().get();
    }
	
	public void setSpeed(double speed){
		this.getMotorController().set(speed);
	}

	public void initPID(){
    	targetTime = Timer.getFPGATimestamp();
    	
    	potPIDcontroller.resetPID();
	}
	
	public void setPosition(int position){
		potPIDcontroller.atTarget = false;
		
		double targetAngle = this.getPositions()[position];
		double currentAngle = this.getAngle();
		
		this.getMotorController().set((potPIDcontroller.calcPID(targetAngle, currentAngle, 2)));
		
		if(!potPIDcontroller.isDone())
			targetTime = Timer.getFPGATimestamp();
	}
	
	public boolean isFinished(){
		return Timer.getFPGATimestamp() - targetTime > .5;
	}
}
