package org.team4909.boxtop.commands.drive;

import org.team4909.boxtop.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShiftCommand extends InstantCommand {
    public ShiftCommand() {
        requires(Robot.drivetrain);
    }

    protected void initialize() {
    	Robot.drivetrain.robotDrive.shift();
    	
    	SmartDashboard.putNumber("Times Shifted", SmartDashboard.getNumber("Times Shifted", 0) + 1);
    }
}