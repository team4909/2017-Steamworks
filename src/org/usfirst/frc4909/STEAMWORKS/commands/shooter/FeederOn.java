package org.usfirst.frc4909.STEAMWORKS.commands.shooter;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FeederOn extends Command {
    public FeederOn() {
    	requires(Robot.feeder);
    }

    public void start() {
    	super.start();
    	
    	if(SmartDashboard.getBoolean("Ready To Shoot", false))
        	Robot.feeder.startFeed();
    }

    protected void end() {
    	Robot.feeder.stopFeed();
    }
}