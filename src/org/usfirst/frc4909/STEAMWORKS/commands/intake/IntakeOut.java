package org.usfirst.frc4909.STEAMWORKS.commands.intake;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class IntakeOut extends InstantCommand {
    public IntakeOut() {
        super();

        requires(Robot.intakePolycord);
    }

    protected void initialize() {
    	Robot.intakePolycord.intakeOut();
    }
}
