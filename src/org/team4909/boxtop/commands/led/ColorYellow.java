package org.team4909.boxtop.commands.led;

import org.team4909.boxtop.Robot;

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
