package org.usfirst.frc4909.STEAMWORKS.commands.auto;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

public class BreakBaseline extends Command {
    public BreakBaseline() {
    	requires(Robot.climber);
    	requires(Robot.drivetrain);
    	requires(Robot.feeder);
    	requires(Robot.intakePolycord);
    	requires(Robot.intakePivot);
    	requires(Robot.loader);
    	requires(Robot.shooter);
    }

    protected boolean isFinished() {
        return true;
    }
}
