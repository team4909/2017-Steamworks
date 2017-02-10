package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class DropGear extends InstantCommand {
    public DropGear() {
        super();
        
        requires(Robot.loader);
    }

    protected void initialize() {
    	Robot.loader.dropGear();
    }
}