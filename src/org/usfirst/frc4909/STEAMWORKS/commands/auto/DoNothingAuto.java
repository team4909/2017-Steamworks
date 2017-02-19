package org.usfirst.frc4909.STEAMWORKS.commands.auto;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

public class DoNothingAuto extends Command {
    public DoNothingAuto() {
    	requires(Robot.climber);
    	requires(Robot.drivetrain);
    	requires(Robot.feeder);
    	requires(Robot.intake);
    	requires(Robot.loader);
    	requires(Robot.shooter);
    }

    protected boolean isFinished() {
        return true;
    }
}
