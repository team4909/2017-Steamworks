package org.usfirst.frc4909.STEAMWORKS.subsystems;

import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.PID.PIDController;
import org.usfirst.frc4909.STEAMWORKS.utils.Subsystem;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;

public class Loader extends Subsystem {
	private final double lP = 0.005;
	private final double lI = 0;
	private final double lD = 0;
	
	private final AnalogPotentiometer loaderPivotPot = RobotMap.loaderPivotPot;
    private final SpeedController loaderMotor = RobotMap.loaderMotor;

    private final PIDController loaderPID = new PIDController(lP,lI,lD,0.3);

	public void dropGear() {
		loaderPID.resetPID();
	    
    	SmartDashboard.putNumber("lP", lP);
    	SmartDashboard.putNumber("lI", lI);
    	SmartDashboard.putNumber("lD", lD);
    	
    	double targetTime=Timer.getFPGATimestamp();
    	while(Timer.getFPGATimestamp()-targetTime<.5){
    		loaderPID.atTarget=false;
    		//lP=SmartDashboard.getNumber("lP", 0);
    		//lI=SmartDashboard.getNumber("lI", 0);
        	//lD=SmartDashboard.getNumber("lD", 0);
        	loaderPID.changePIDGains(lP, lI, lD);

    		double currentAngle=getAngle();
    		SmartDashboard.putNumber("current pot angle",getAngle());
    		//SmartDashboard.putNumber("nPID out",loaderPID.calcPID(, getAngle(), 3));

    		loaderMotor.set(loaderPID.calcPID(145, currentAngle, 2));
    		if(!loaderPID.isDone()){
    				targetTime=Timer.getFPGATimestamp();
    				
    		}
    	}
    	
    	SmartDashboard.putBoolean("straight", false);
	}

	public void holdGear() {
		loaderPID.resetPID();
	    
    	SmartDashboard.putNumber("lP", lP);
    	SmartDashboard.putNumber("lI", lI);
    	SmartDashboard.putNumber("lD", lD);
    	
    	double targetTime=Timer.getFPGATimestamp();
    	while(Timer.getFPGATimestamp()-targetTime<.5){
    		loaderPID.atTarget=false;
    		//lP=SmartDashboard.getNumber("lP", 0);
    		//lI=SmartDashboard.getNumber("lI", 0);
        	//lD=SmartDashboard.getNumber("lD", 0);
        	loaderPID.changePIDGains(lP, lI, lD);

    		double currentAngle=getAngle();
    		SmartDashboard.putNumber("current pot angle",getAngle());
    		

    		loaderMotor.set(loaderPID.calcPID(0, currentAngle, 2));
    		if(!loaderPID.isDone()){
    				targetTime=Timer.getFPGATimestamp();
    				
    		}
    	}
    	
    	SmartDashboard.putBoolean("straight", false);
	}

	public void catchGear() {
		loaderPID.resetPID();
	    
    	SmartDashboard.putNumber("lP", lP);
    	SmartDashboard.putNumber("lI", lI);
    	SmartDashboard.putNumber("lD", lD);
    	
    	double targetTime=Timer.getFPGATimestamp();
    	while(Timer.getFPGATimestamp()-targetTime<.5){
    		loaderPID.atTarget=false;
    		//lP=SmartDashboard.getNumber("lP", 0);
    		//lI=SmartDashboard.getNumber("lI", 0);
        	//lD=SmartDashboard.getNumber("lD", 0);
        	loaderPID.changePIDGains(lP, lI, lD);

    		double currentAngle=getAngle();
    		SmartDashboard.putNumber("current pot angle",getAngle());
    		//SmartDashboard.putNumber("nPID out",loaderPID.calcPID(, currentAngle(), 3));

    		loaderMotor.set(loaderPID.calcPID(55, currentAngle, 2));
    		if(!loaderPID.isDone()){
    				targetTime=Timer.getFPGATimestamp();
    				
    		}
    	}
    	
    	SmartDashboard.putBoolean("straight", false);
	}
	
	public double getAngle(){
    	return loaderPivotPot.get();
    }
	
	public void moveLoader(double target, double currentAngle, double threshold){
		loaderMotor.set((loaderPID.calcPID(target, currentAngle, threshold)));
	}
}