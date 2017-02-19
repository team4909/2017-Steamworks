package org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Rotate extends Command {
	double targetTime;
	double rP;
	double rI;
	double rD;
	double angle;
	PIDController rotatePID = new PIDController(rP,rI,rD,0.5);

    public Rotate(double target) {
    	this.angle = target; 
    }

    protected void initialize() {    
	    SmartDashboard.putBoolean("rotate", true);
		targetTime=Timer.getFPGATimestamp();
		rotatePID.resetPID();
    }

    protected void execute() {
    	rotatePID.atTarget=false;
    	rP=SmartDashboard.getNumber("rP", 0);
		rI=SmartDashboard.getNumber("rI", 0);
    	rD=SmartDashboard.getNumber("rD", 0);
    	rotatePID.changePIDGains(rP, rI, rD);

		double currentAngle=Robot.drivetrain.getNavX().getAngle();
		Robot.drivetrain.rotateRobot(angle, currentAngle, 4);
		
		if(!rotatePID.isDone()){
				targetTime=Timer.getFPGATimestamp(); 
		}
    }

    protected boolean isFinished() {
        return Timer.getFPGATimestamp()-targetTime>.5;
    }

    protected void end() {
    	SmartDashboard.putBoolean("rotate", false);

    }
}
