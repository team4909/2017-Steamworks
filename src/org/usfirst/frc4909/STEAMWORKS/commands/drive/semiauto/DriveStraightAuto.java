package org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDController;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraightAuto extends Command {
	double targetTime;
	double sP;
	double sI;
	double sD;
	double distance;
	PIDController straightPID = new PIDController(sP,sI,sD,0.5);

    public DriveStraightAuto(double target) {
    	this.distance = target; 
    }

    protected void initialize() {    
    	SmartDashboard.putBoolean("straight", true);
    	targetTime=Timer.getFPGATimestamp();
		straightPID.resetPID();
    }

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

    protected boolean isFinished() {
        return Timer.getFPGATimestamp()-targetTime>.5;
    }
}
