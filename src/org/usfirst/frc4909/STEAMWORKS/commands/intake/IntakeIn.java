package org.usfirst.frc4909.STEAMWORKS.commands.intake;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class IntakeIn extends InstantCommand {
    public IntakeIn() {
        super();
        
        requires(Robot.intakePolycord);
    }

    protected void initialize() {
    	Robot.intakePolycord.intakeIn();
    }

}
