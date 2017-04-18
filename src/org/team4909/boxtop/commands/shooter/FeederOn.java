package org.team4909.boxtop.commands.shooter;


import org.team4909.boxtop.Robot;
import org.team4909.utils.EasyCommand;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class FeederOn extends EasyCommand {
    public FeederOn() {
        requires(Robot.feeder);
    }

//    public void start() {
//    	super.start();
//    	
//    	Robot.intakePolycord.intakeIn();
//    }
    protected void execute(){
    	if(SmartDashboard.getBoolean("Ready to Shoot", true) || SmartDashboard.getBoolean("Shooter Manual Override", true)){
    		Robot.feeder.startFeed();
    		SmartDashboard.putBoolean("Agitator On", true);
    	}
    }
    
    protected boolean isFinished(){
    	return !Robot.oi.manipulatorGamepad.getRawButton(8);
    }
    
    protected void end() {
    	Robot.feeder.stopFeed();
    	SmartDashboard.putBoolean("Agitator On", false);
    }
}