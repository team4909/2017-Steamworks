package org.team4909.boxtop.commands.climb;

import org.team4909.boxtop.Robot;
import org.team4909.utils.EasyCommand;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ClimbCommand extends EasyCommand {
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