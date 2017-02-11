package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.PID.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraight extends Command {
	double targetTime;
	double sP;
	double sI;
	double sD;
	double distance;
	PIDController straightPID = new PIDController(sP,sI,sD,0.5);

    public DriveStraight(double target) {
    	this.distance = target; 
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {    
    SmartDashboard.putBoolean("straight", true);
	targetTime=Timer.getFPGATimestamp();
	straightPID.resetPID();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	straightPID.atTarget=false;
    	sP=SmartDashboard.getNumber("sP", 0);
		sI=SmartDashboard.getNumber("sI", 0);
    	sD=SmartDashboard.getNumber("sD", 0);
    	straightPID.changePIDGains(sP, sI, sD);

		double leftDistance=Robot.drivetrain.getLeftEncDistance();
		double rightDistance=Robot.drivetrain.getRightEncDistance();

		SmartDashboard.putNumber("left distance",leftDistance);
		SmartDashboard.putNumber("right distance", rightDistance);
		SmartDashboard.putNumber("straight PID out",straightPID.calcPID(distance, (leftDistance + rightDistance)/2, 2));
		Robot.drivetrain.driveStraight(distance, leftDistance, rightDistance, 2);
		if(!straightPID.isDone()){
				targetTime=Timer.getFPGATimestamp(); 
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Timer.getFPGATimestamp()-targetTime>.5;
        }

    // Called once after isFinished returns true
    protected void end() {
    	SmartDashboard.putBoolean("straight", false);

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
