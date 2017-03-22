package org.usfirst.frc4909.STEAMWORKS.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LEDControl extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
private Solenoid red, green, blue, climber;
	
	public LEDControl (){
		red = new Solenoid(2);
		green = new Solenoid(3);
		blue = new Solenoid(4);
		climber = new Solenoid(5);
	}
	
	public void reset(){
		red.set(false);
		green.set(false);
		blue.set(false);
	}
	
	public void resetClimbed(){
		climber.set(false);
	}
	
	public void setColor(boolean r, boolean g, boolean b){
		reset();
		red.set(r);
		green.set(g);
		blue.set(b);
	}
	
	public void setClimbed(boolean c){
//		resetClimbed();
		climber.set(c);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

