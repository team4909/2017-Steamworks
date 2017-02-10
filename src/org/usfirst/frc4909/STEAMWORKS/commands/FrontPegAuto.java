package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class FrontPegAuto extends InstantCommand {
    public FrontPegAuto() {
        super();
    }

    protected void initialize() {
    	Robot.drivetrain.driveStraightEncoder(96);
    }
}