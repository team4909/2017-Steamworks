package org.usfirst.frc4909.STEAMWORKS.commands.led;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ColorGreen extends InstantCommand {

    public ColorGreen() {
        super();
       requires(Robot.leds);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.leds.setColor(false, true, false);
    }

}
