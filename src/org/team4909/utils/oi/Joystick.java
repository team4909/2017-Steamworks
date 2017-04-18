package org.team4909.utils.oi;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Joystick extends edu.wpi.first.wpilibj.Joystick {
	public Joystick(int port) {
		super(port);
	}

	public double getThresholdAxis(int axis, double deadzone){
		if(Math.abs(this.getRawAxis(axis)) > Math.abs(deadzone)){
			SmartDashboard.putNumber("Joystick val", this.getRawAxis(axis));
			return this.getRawAxis(axis);
		}
		else
			return 0.0;
	}
	
	public void buttonPressed(int button, Command command){
		JoystickButton newButton = new JoystickButton(this, button);
		
		newButton.whenPressed(command);
	}
	
	public void buttonHeld(int button, Command command){
		JoystickButton newButton = new JoystickButton(this, button);
		
		newButton.whileHeld(command);
	}
	
	public void buttonToggled(int button, Command command){
		JoystickButton newButton = new JoystickButton(this, button);
		
		newButton.toggleWhenPressed(command);
	}
}