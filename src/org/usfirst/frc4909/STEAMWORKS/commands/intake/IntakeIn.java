package org.usfirst.frc4909.STEAMWORKS.commands.intake;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class IntakeIn extends Command {
    public IntakeIn() {
        requires(Robot.intakePolycord);
    }

//    public void start() {
//    	super.start();
//    	
//    	Robot.intakePolycord.intakeIn();
//    }
    
    protected void execute(){
    	Robot.intakePolycord.intakeIn();
    }
    protected boolean isFinished(){
    	return !Robot.oi.manipulatorGamepad.getRawButton(7);
    }
    protected void end() {
    	Robot.intakePolycord.intakeStop();
    }
    protected void interrupted() {
    	end();
    	
    }
}
