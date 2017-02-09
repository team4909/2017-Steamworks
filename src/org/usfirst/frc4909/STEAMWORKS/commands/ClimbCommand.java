package org.usfirst.frc4909.STEAMWORKS.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4909.STEAMWORKS.Robot;

public class ClimbCommand extends Command {
    public ClimbCommand() {
        requires(Robot.climber);
    }
    
    protected void initialize() {}

    protected void execute() {
    	// double speed = Robot.oi.getManipulatorJoystick().getY();
    	// double speed = (Robot.oi.getClimberSpeed() - 1.0)/2.0;
    	double speed = .53;
    	
    	Robot.climber.climb(speed);
    	
    	SmartDashboard.putNumber("Rspeed", speed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.climber.climb(0);
    }

    protected void interrupted() {
    	end();
    }
}
