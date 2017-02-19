package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class HoldGear extends Command {
    public HoldGear() {
    	requires(Robot.loader);
    }

    protected void initialize() {
    	Robot.loader.initPID();
    }

    protected void execute() {
    	Robot.loader.setPosition(0);
    }

    protected boolean isFinished() {
        return Robot.loader.isFinished();
    }
}
