package org.usfirst.frc4909.STEAMWORKS.commands.loader;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CatchGear extends Command {
    public CatchGear() {
//    	requires(Robot.loader);
    }

    protected void initialize() {
    	Robot.loader.targetPosition = 1;
    	SmartDashboard.putString("Loader Position", "Catch");

    }

    protected void execute() {}

    protected boolean isFinished() {
        return true;
    }
}
