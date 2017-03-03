package org.usfirst.frc4909.STEAMWORKS.commands.climb;

import org.usfirst.frc4909.STEAMWORKS.utils.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4909.STEAMWORKS.Robot;

public class ClimbCommand extends Command {
    public ClimbCommand() {
        requires(Robot.climber);
    }

    protected void execute() {
    	Robot.climber.climb(1.0);
    	SmartDashboard.putBoolean("Climber Limit Switch State", Robot.climber.getSwitch());

    }
    
    protected boolean isFinished(){
    	return Robot.climber.getSwitch();
    }
    
    protected void end() {
    	Robot.climber.climb(0);
    }
}