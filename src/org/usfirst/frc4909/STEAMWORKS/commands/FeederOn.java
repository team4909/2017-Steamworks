package org.usfirst.frc4909.STEAMWORKS.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4909.STEAMWORKS.Robot;

public class FeederOn extends Command {
    public FeederOn() {
    	requires(Robot.feeder);
    }

    protected void initialize() {
    	if(!SmartDashboard.getBoolean("Ready To Shoot", true) && 
           !SmartDashboard.getBoolean("ShooterOverride",true))
    		end();
    }

    protected void execute() {
    	Robot.feeder.startFeed();

    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
