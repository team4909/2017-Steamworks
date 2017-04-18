package org.team4909.boxtop.commands.loader;

import org.team4909.boxtop.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DropGear extends Command {
    public DropGear() {
//    	requires(Robot.loader);
    }

    protected void initialize() {
    	Robot.loader.targetPosition = 2;
    	SmartDashboard.putString("Loader Position", "Place");

    }

    protected void execute() {}

    protected boolean isFinished() {
        return true;
    }
}
