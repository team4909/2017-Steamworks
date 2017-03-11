package org.usfirst.frc4909.STEAMWORKS.commands.led;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.subsystems.LEDControl;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ColorBlue extends InstantCommand {

    public ColorBlue() {
        super();
        requires(Robot.leds);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.leds.setColor(false, false, true);
    }

}
