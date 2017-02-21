package org.usfirst.frc4909.STEAMWORKS.commands.shooter;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class StopShooting extends InstantCommand {
    public StopShooting() {
    	requires(Robot.feeder);
    	requires(Robot.shooter);
    }

    protected void initialize() {
    	Robot.feeder.stopFeed();
    }
}