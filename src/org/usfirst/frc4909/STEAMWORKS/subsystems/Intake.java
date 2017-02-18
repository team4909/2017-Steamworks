package org.usfirst.frc4909.STEAMWORKS.subsystems;

import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.PID.PIDController;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake extends Subsystem {
	private double pP = 0.0005;
	private double pI = 0;
	private double pD = 0;

    private final AnalogPotentiometer pivotPot = RobotMap.intakePivotPot;
    private final SpeedController intakeMotor = RobotMap.intakeIntakeMotor;
    private final SpeedController centerMotor = RobotMap.intakeCenterMotor;
    private final SpeedController pivotMotor = RobotMap.intakePivotMotor;
    
    public final PIDController pivotPID = new PIDController(pP,pI,pD,0.3);

    public void intakeIn(){
    	intakeMotor.set(.5);
    	centerMotor.set(-.8);

    }
    public void intakeOut(){
    	intakeMotor.set(-.5);
    	centerMotor.set(.8);

    }
    public void intakeStop(){
    	intakeMotor.set(0);
    	centerMotor.set(0);

    }
    
    public void pivotUp(){
    	SmartDashboard.putBoolean("pivot", true);
    	double targetTime=Timer.getFPGATimestamp();
    	while(Timer.getFPGATimestamp()-targetTime<.5){
    		pivotPID.atTarget=false;
        	pP=SmartDashboard.getNumber("pP", 0);
        	pI=SmartDashboard.getNumber("pI", 0);
        	pD=SmartDashboard.getNumber("pD", 0);
        	pivotPID.changePIDGains(pP, pI, pD);

    		double currentAngle=getPivotAngle();
    		SmartDashboard.putNumber("current angle",currentAngle);
    		SmartDashboard.putNumber("PID out",pivotPID.calcPID(90, currentAngle, 3));

    		pivotMotor.set((pivotPID.calcPID(0, currentAngle, 3)));
    		if(!pivotPID.isDone()){
    				targetTime=Timer.getFPGATimestamp();
    				
    		}
    	}
    	
    	SmartDashboard.putBoolean("pivot", false);

    }
    public double getPivotAngle(){
    	return pivotPot.get();
    }
    public void initDefaultCommand() {}
    
    public void resetPID(){
    	pivotPID.resetPID();
    }

    public void movePivot(double target, double currentAngle, double threshold){
    	pivotMotor.set((pivotPID.calcPID(target, currentAngle, threshold)));
    }
}