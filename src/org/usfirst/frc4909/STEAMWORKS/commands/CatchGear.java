package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.PID.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class CatchGear extends Command {
	double targetTime;
	double lP;
	double lI;
	double lD;
	PIDController loaderPID = new PIDController(lP,lI,lD,0.3);
    public CatchGear() {
    	requires(Robot.intake);
        // Use requires() here to declare subsystem 
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	targetTime=Timer.getFPGATimestamp();
    	loaderPID.resetPID();
    	SmartDashboard.putBoolean("gear", true);
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	loaderPID.atTarget=false;
    	lP=SmartDashboard.getNumber("lP", 0);
		lI=SmartDashboard.getNumber("lI", 0);
    	lD=SmartDashboard.getNumber("lD", 0);
    	loaderPID.changePIDGains(lP, lI, lD);

		double currentAngle=Robot.loader.getAngle();
		SmartDashboard.putNumber("current angle",currentAngle);
		SmartDashboard.putNumber("loader PID out",loaderPID.calcPID(55, currentAngle, 2));
		Robot.loader.moveLoader(55, currentAngle, 2);
		if(!loaderPID.isDone()){
				targetTime=Timer.getFPGATimestamp(); 
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Timer.getFPGATimestamp()-targetTime>.5;
    }

    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putBoolean("gear", false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
   
}
