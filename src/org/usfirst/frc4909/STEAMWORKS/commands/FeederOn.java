package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FeederOn extends Command {
    public FeederOn() {
    	requires(Robot.feeder);
    }

    protected void initialize() {
    	if(!SmartDashboard.getBoolean("Ready To Shoot", true) && !SmartDashboard.getBoolean("ShooterOverride",true))
    		end();
    }

    protected void execute() {
    	Robot.feeder.startFeed();
    }
}