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
    	Robot.climber.climb(Robot.config.getClimberMaxSpeed());
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
