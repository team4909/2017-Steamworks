package org.usfirst.frc4909.STEAMWORKS.commands;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4909.STEAMWORKS.Robot;

public class ShiftCommand extends InstantCommand {
    public ShiftCommand() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {
    	Robot.drivetrain.shift();
    	SmartDashboard.putNumber("Shifts", SmartDashboard.getNumber("Shifts",0)+1);
    }
}