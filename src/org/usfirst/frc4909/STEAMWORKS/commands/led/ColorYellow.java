package org.usfirst.frc4909.STEAMWORKS.commands.led;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ColorYellow extends InstantCommand {

    public ColorYellow() {
        super();
        requires(Robot.leds);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.leds.setColor(true, true, false);
    }

}
