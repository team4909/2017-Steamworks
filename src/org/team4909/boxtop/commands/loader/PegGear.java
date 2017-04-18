package org.team4909.boxtop.commands.loader;

import org.team4909.boxtop.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PegGear extends Command {
    public PegGear() {
//    	requires(Robot.loader);
    }

    protected void initialize() {
    	Robot.loader.targetPosition = 3;
    	SmartDashboard.putString("Loader Position", "Prep for Peg");
    	
    }

    protected void execute() {}

    protected boolean isFinished() {
        return true;
    }
}
