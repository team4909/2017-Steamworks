package org.team4909.boxtop.commands.drive;

import org.team4909.boxtop.Robot;
import org.team4909.utils.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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