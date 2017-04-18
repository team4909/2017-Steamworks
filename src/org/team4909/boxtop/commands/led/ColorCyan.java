package org.team4909.boxtop.commands.led;

import org.team4909.boxtop.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ColorCyan extends InstantCommand {

    public ColorCyan() {
        super();
        requires(Robot.leds);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.leds.setColor(false, true, true);
    }

}