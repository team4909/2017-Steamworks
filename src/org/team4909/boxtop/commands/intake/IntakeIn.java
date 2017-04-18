package org.team4909.boxtop.commands.intake;

import org.team4909.boxtop.Robot;
import org.team4909.utils.Command;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeIn extends Command {
    private double targetTime;
	public IntakeIn() {
        requires(Robot.intakePolycord);
    }

//    public void start() {
//    	super.start();
//    	
//    	Robot.intakePolycord.intakeIn();
//    }
    protected void initialize(){
    	targetTime=Timer.getFPGATimestamp();
    }
    protected void execute(){
    	SmartDashboard.putNumber("Intake Current", Robot.intakePolycord.getCurrent());

		if(Timer.getFPGATimestamp() - targetTime > .5){
			SmartDashboard.putBoolean("Has Intake Gear", true);
	    	Robot.intakePolycord.intakeIn(.35);
		}
		else{
			if(Robot.intakePolycord.getCurrent()<17)
				targetTime = Timer.getFPGATimestamp(); 
	    	Robot.intakePolycord.intakeIn(.7);
			SmartDashboard.putBoolean("Has Intake Gear", false);
	
		}


    }
    protected boolean isFinished(){
    	return !Robot.oi.manipulatorGamepad.getRawButton(7)  ;
    }
    protected void end() {
    	Robot.intakePolycord.intakeStop();
    }
    protected void interrupted() {
    	end();
    	
    }
}
