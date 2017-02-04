package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class FeederOn extends Command {

    public FeederOn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(!SmartDashboard.getBoolean("Ready To Shoot", true) && !SmartDashboard.getBoolean("ShooterOverride",true)){
    		end();
    	}
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.feeder.startFeed();

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}