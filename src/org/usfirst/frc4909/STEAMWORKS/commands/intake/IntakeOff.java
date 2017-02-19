package org.usfirst.frc4909.STEAMWORKS.commands.intake;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class IntakeOff extends InstantCommand {
	public IntakeOff() {
        super();
    
        requires(Robot.intakePolycord);
    }

    protected void initialize() {
    	Robot.intakePolycord.intakeStop();
    }

}
