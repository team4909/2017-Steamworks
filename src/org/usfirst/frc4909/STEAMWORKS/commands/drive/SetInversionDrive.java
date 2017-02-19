package org.usfirst.frc4909.STEAMWORKS.commands.drive;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class SetInversionDrive extends InstantCommand {
    public SetInversionDrive() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    	Robot.drivetrain.setInversion(true);
    }
}