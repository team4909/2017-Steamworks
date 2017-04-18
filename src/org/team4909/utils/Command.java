package org.team4909.utils;

public abstract class Command extends edu.wpi.first.wpilibj.command.Command {
	public Command() {}

	@Override
	protected boolean isFinished() {
		return false;
	}

    protected void initialize() {}
    
    protected void end(){}
    
    protected void interrupted() {
    	end();
    }
}
