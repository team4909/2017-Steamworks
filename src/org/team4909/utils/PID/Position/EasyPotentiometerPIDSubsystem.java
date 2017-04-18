package org.team4909.utils.PID.Position;

import org.team4909.utils.PID.EasyPIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public abstract class EasyPotentiometerPIDSubsystem extends Subsystem {
	private double targetTime;
	public int targetPosition = 0;
	
    public final EasyPIDController potPIDcontroller = new EasyPIDController(this.getPotentiometerPIDController());
    
	public abstract EasyPotentiometerPIDController getPotentiometerPIDController();
	
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
