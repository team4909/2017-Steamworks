package org.usfirst.frc4909.STEAMWORKS.commands.drive;

import org.usfirst.frc4909.STEAMWORKS.utils.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4909.STEAMWORKS.Robot;

public class DriveCommand extends Command {
    public DriveCommand() {
        requires(Robot.drivetrain);
        
    	SmartDashboard.putBoolean("Tank Drive Enabled", false);
    }

    protected void execute() {
    	boolean tankDrive = SmartDashboard.getBoolean("Tank Drive Enabled", false);
    	
    	if(tankDrive)
    		Robot.drivetrain.moveTank();
    	else
    		Robot.drivetrain.moveArcade();
    }
    
    protected void end() {
    	Robot.drivetrain.stop();
    }
}