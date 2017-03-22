package org.usfirst.frc4909.STEAMWORKS.commands.loader;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LoaderSched extends Command {
	public LoaderSched() {
		requires(Robot.loader);
	}
	
	protected void initialize() {
    	Robot.loader.initPID();
    }

    protected void execute() {
    	if(SmartDashboard.getBoolean("Loader Pivot Manual Override", false))
    		Robot.loader.setSpeed(Robot.oi.manipulatorGamepad.getThresholdAxis(3, 0.15)*0.4);
    	else
    		Robot.loader.setPosition(Robot.loader.targetPosition);
    }

    protected boolean isFinished() {
        return false; //return Robot.loader.isFinished();
    }
}
