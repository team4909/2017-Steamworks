package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class ShiftDownCommand extends InstantCommand {
    public ShiftDownCommand() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {}
}