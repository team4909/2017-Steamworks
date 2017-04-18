package org.team4909.boxtop.commands.drive;

import org.team4909.boxtop.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class InvertDrive extends InstantCommand {
    public InvertDrive() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    	Robot.drivetrain.robotDrive.invert();
    }
}