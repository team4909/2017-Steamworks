package org.usfirst.frc4909.STEAMWORKS.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc4909.STEAMWORKS.Robot;

public class StopShooting extends Command {
    public StopShooting() {
        requires(Robot.feeder);
    	requires(Robot.shooter);
    }

    protected void initialize() {
    	Robot.feeder.stopFeed();    	
    }
    
    protected void execute() {}

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
