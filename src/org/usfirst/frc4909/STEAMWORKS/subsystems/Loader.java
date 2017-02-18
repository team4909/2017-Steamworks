package org.usfirst.frc4909.STEAMWORKS.subsystems;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.PID.PIDController;
import org.usfirst.frc4909.STEAMWORKS.utils.Subsystem;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;

public class Loader extends Subsystem {
	private double targetTime;
	
	private final double lP = 0.08;
	private final double lI = 0;
	private final double lD = 0;
		
	private final AnalogPotentiometer loaderPivotPot = RobotMap.loaderPivotPot;
    private final SpeedController loaderMotor = RobotMap.loaderMotor;

    public final PIDController loaderPID = new PIDController(lP,lI,lD,0.3);

	public double getAngle(){
    	return loaderPivotPot.get();
    }
	
	public void setSpeed(double speed){
		loaderMotor.set(speed);
	}
	
	public void initPID(){
    	targetTime = Timer.getFPGATimestamp();
    	
    	loaderPID.resetPID();
	}
	
	public void setPosition(int position){
		loaderPID.atTarget = false;
		
		double targetAngle = Robot.config.loaderAngles[position];
		double currentAngle = Robot.loader.getAngle();
		
		loaderMotor.set((loaderPID.calcPID(targetAngle, currentAngle, 2)));
		
		if(!loaderPID.isDone())
			targetTime = Timer.getFPGATimestamp();
	}
	
	public boolean isFinished(){
		return Timer.getFPGATimestamp()-targetTime > .5;
	}
}