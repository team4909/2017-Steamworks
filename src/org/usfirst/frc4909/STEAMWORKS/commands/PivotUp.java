package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.PID.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class PivotUp extends Command {
	double targetTime;
	double pP;
	double pI;
	double pD;
	PIDController pivotPID = Robot.intake.pivotPID;
    public PivotUp() {
    	requires(Robot.intake);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putBoolean("pivot", true);
    	targetTime=Timer.getFPGATimestamp();
    	Robot.intake.resetPID();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	pivotPID.atTarget=false;
    	pP=SmartDashboard.getNumber("pP", 0);
    	pI=SmartDashboard.getNumber("pI", 0);
    	pD=SmartDashboard.getNumber("pD", 0);
    	pivotPID.changePIDGains(pP, pI, pD);

		double currentAngle=Robot.intake.getPivotAngle();
		SmartDashboard.putNumber("current angle",currentAngle);
		SmartDashboard.putNumber("Pivot PID out",pivotPID.calcPID(0, currentAngle, 2));
		Robot.intake.movePivot(0, currentAngle, 2);
		if(!pivotPID.isDone()){
				targetTime=Timer.getFPGATimestamp(); 
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Timer.getFPGATimestamp()-targetTime>.5;
    }

    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putBoolean("pivot", false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
