package org.usfirst.frc4909.STEAMWORKS.commands.intake;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class IntakeOff extends InstantCommand {

    public IntakeOff() {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.intake.intakeStop();
    }

}
