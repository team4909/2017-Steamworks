package org.usfirst.frc4909.STEAMWORKS.commands.climb;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ClimbManual extends Command {

    public ClimbManual() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.climber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.climber.getSwitch() && !SmartDashboard.getBoolean("Climber Limit Switch Disable", false) && Robot.oi.climberJoystick.getThresholdAxis(1)>=0)
    		Robot.climber.climb(0);
    	
    	else
    		Robot.climber.climb(Robot.oi.climberJoystick.getThresholdAxis(1));
    	
    	SmartDashboard.putBoolean("Climber Limit Switch State", Robot.climber.getSwitch());
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
}
