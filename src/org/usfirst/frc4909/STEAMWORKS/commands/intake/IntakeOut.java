package org.usfirst.frc4909.STEAMWORKS.commands.intake;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class IntakeOut extends Command {
    public IntakeOut() {
       
        
        requires(Robot.intakePolycord);
    }

//    public void start() {
//    	super.start();
//    	
//    	Robot.intakePolycord.intakeIn();
//    }
    protected void execute(){
    	Robot.intakePolycord.intakeOut();
    }
    protected boolean isFinished(){
    	return !Robot.oi.manipulatorGamepad.getRawButton(9);
    }
    protected void end() {
    	Robot.intakePolycord.intakeStop();
    }
}
