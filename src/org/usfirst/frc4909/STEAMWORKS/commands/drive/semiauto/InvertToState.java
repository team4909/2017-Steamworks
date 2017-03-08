package org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto;

import edu.wpi.first.wpilibj.command.InstantCommand;

import org.usfirst.frc4909.STEAMWORKS.Robot;

public class InvertToState extends InstantCommand {
	private boolean state;
	
	//true = gear side
	//false = intake side
    public InvertToState(boolean initState) {
        requires(Robot.drivetrain);
        
        state = initState;
    }

    protected void initialize() {
    	Robot.drivetrain.robotDrive.invert(state);
    	
    }
}