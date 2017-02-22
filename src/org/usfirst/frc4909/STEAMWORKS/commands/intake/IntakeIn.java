package org.usfirst.frc4909.STEAMWORKS.commands.intake;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.Command;

import edu.wpi.first.wpilibj.command.InstantCommand;

public class IntakeIn extends Command {
    public IntakeIn() {
       
        
        requires(Robot.intakePolycord);
        System.out.println("IntakeIn");
    }

//    public void start() {
//    	super.start();
//    	
//    	Robot.intakePolycord.intakeIn();
//    }
    protected void execute(){
    	Robot.intakePolycord.intakeIn();
    	System.out.println("EXE");
    }
    protected boolean isFinished(){
    	boolean done = !Robot.oi.manipulatorGamepad.getRawButton(7);
    	System.out.println("IsFinished "+done);
    	return done;
    }
    protected void end() {
    	Robot.intakePolycord.intakeStop();
    	System.out.println("end");
    }
    protected void interrupted() {
    	System.out.println("interrupted");
    	end();
    	
    }
}
