package org.team4909.utils.PID;

import org.team4909.utils.EasyCommand;

import edu.wpi.first.wpilibj.Timer;

public abstract class EasyPIDCommand extends EasyCommand {
	double targetTime;

	protected EasyPIDController pidController = new EasyPIDController(new EasyPIDConstants(0, 0, 0, 1.0));
	
    protected void initialize() {    
    	targetTime = Timer.getFPGATimestamp();
    	
    	pidController.resetPID();
    }

    protected void execute() {
    	pidController.atTarget = false;
    	
    	this.usePID();
    	
		if(!pidController.isDone())
			targetTime = Timer.getFPGATimestamp(); 
	}

    protected boolean isFinished() {
        return Timer.getFPGATimestamp() - targetTime > .5;
    }
    
    protected abstract void usePID();
}
