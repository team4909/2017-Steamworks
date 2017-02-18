package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 *
 */
public class DoNothingAuto extends Command {

    public DoNothingAuto() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.climber);
    	requires(Robot.drivetrain);
    	requires(Robot.feeder);
    	requires(Robot.intake);
    	requires(Robot.loader);
    	requires(Robot.shooter);
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	//Shift into high gear
    	Robot.drivetrain.shift(Value.kForward);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
}
