package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class DropGear extends Command {
    public DropGear() {
    	requires(Robot.intake);
    }

    protected void initialize() {
    	Robot.loader.initPID();
    }

    protected void execute() {
    	Robot.loader.setPosition(2);
    }

    protected boolean isFinished() {
        return Robot.loader.isFinished();
    }
}
