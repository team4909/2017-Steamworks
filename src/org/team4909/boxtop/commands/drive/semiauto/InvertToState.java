package org.team4909.boxtop.commands.drive.semiauto;

import org.team4909.boxtop.Robot;

import edu.wpi.first.wpilibj.command.InstantCommand;

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