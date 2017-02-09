package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class UnsetInversionDrive extends InstantCommand {
    public UnsetInversionDrive() {
        super();
    }

    protected void initialize() {
    	Robot.drivetrain.setInversion(false);
    }
}