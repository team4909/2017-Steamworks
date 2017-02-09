package org.usfirst.frc4909.STEAMWORKS.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc4909.STEAMWORKS.Robot;

public class AutonomousCommand extends Command {
    public AutonomousCommand() {
        requires(Robot.drivetrain);
    }
    
    protected void initialize() {}
    
    protected void execute() {}
    
    protected boolean isFinished() {
        return false;
    }
    
    protected void end() {}
    
    protected void interrupted() {}
}