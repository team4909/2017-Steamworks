package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CatchGear extends Command {
    public CatchGear() {
    	requires(Robot.intake);
    }

    protected void initialize() {
    	Robot.loader.initPID();
    }

    protected void execute() {
    	Robot.loader.setPosition(1);
    }

    protected boolean isFinished() {
        return Robot.loader.isFinished();
    }
}
