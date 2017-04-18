package org.team4909.boxtop.commands.intake;

import org.team4909.boxtop.Robot;
import org.team4909.utils.EasyCommand;

public class IntakeOut extends EasyCommand {
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
