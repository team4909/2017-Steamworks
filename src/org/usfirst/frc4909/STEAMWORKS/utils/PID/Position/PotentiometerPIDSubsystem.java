package org.usfirst.frc4909.STEAMWORKS.utils.PID.Position;

import org.usfirst.frc4909.STEAMWORKS.utils.Subsystem;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDController;

import edu.wpi.first.wpilibj.Timer;

public abstract class PotentiometerPIDSubsystem extends Subsystem {
	private double targetTime;
	public int currentPosition = -1;
	
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
	
	public void setPosition(int position){
		potPIDcontroller.atTarget = false;
		
		currentPosition = position;
		
		double targetAngle = this.getPotentiometerPIDController().getPositions()[position];
		double currentAngle = this.getAngle();
		
		this.getPotentiometerPIDController().getMotor().set((potPIDcontroller.calcPID(targetAngle, currentAngle, 2)));
		
		if(!potPIDcontroller.isDone())
			targetTime = Timer.getFPGATimestamp();
	}
	
	public boolean isFinished(){
		return Timer.getFPGATimestamp() - targetTime > .5;
	}
}
