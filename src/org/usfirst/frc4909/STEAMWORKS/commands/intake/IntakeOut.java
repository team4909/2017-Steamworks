package org.usfirst.frc4909.STEAMWORKS.commands.intake;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

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
    	return !Robot.oi.manipulatorGamepad.getRawButton(10);
    }
    protected void end() {
    	Robot.intakePolycord.intakeStop();
    }
}
