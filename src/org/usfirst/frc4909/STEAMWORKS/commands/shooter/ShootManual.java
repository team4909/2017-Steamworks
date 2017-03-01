package org.usfirst.frc4909.STEAMWORKS.commands.shooter;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShootManual extends Command {

    public ShootManual() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double adjustedAxis = (Robot.oi.climberJoystick.getRawAxis(3)+1)/2;
    	if(adjustedAxis<.15)
    		adjustedAxis=0;
    	
    	if(SmartDashboard.getBoolean("Shooter Manual Override", false))
    		Robot.shooter.setVoltage(adjustedAxis);
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
