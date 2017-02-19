package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Rotate extends Command {
	double targetTime;
	double rP;
	double rI;
	double rD;
	double angle;
	PIDController rotatePID = new PIDController(rP,rI,rD,0.5);

    public Rotate(double target) {
    	this.angle = target; 
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {    
    SmartDashboard.putBoolean("rotate", true);
	targetTime=Timer.getFPGATimestamp();
	rotatePID.resetPID();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	rotatePID.atTarget=false;
    	rP=SmartDashboard.getNumber("rP", 0);
		rI=SmartDashboard.getNumber("rI", 0);
    	rD=SmartDashboard.getNumber("rD", 0);
    	rotatePID.changePIDGains(rP, rI, rD);

		double currentAngle=Robot.drivetrain.getNavX().getAngle();
		SmartDashboard.putNumber("current angle",currentAngle);
		SmartDashboard.putNumber("rotate PID out",rotatePID.calcPID(angle, currentAngle, 4));
		Robot.drivetrain.rotateRobot(angle, currentAngle, 4);
		if(!rotatePID.isDone()){
				targetTime=Timer.getFPGATimestamp(); 
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Timer.getFPGATimestamp()-targetTime>.5;
        }

    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putBoolean("rotate", false);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
