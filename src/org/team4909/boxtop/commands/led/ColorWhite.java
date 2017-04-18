package org.team4909.boxtop.commands.led;

import org.team4909.boxtop.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ColorWhite extends InstantCommand {

    public ColorWhite() {
        super();
        requires(Robot.leds);
        }

    // Called once when the command executes
    protected void initialize() {
    Robot.leds.setColor(true, true, true);;
    }

}
