package org.usfirst.frc4909.STEAMWORKS.commands.intake;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class IntakeIn extends InstantCommand {
    public IntakeIn() {
        super();
        
        requires(Robot.intakePolycord);
    }

    public void start() {
    	super.start();
    	
    	Robot.intakePolycord.intakeIn();
    }
    
    protected void end() {
    	Robot.intakePolycord.intakeStop();
    }
}
