package org.team4909.utils.oi;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class GamepadF310 extends EasyJoystick {
	public GamepadF310(int port) {
		super(port);
	}
	
	public static enum Buttons {
		A,
		B,
		X,
		Y,
		LB,
		LT,
		RB,
		RT,
		Start,
		Back,
		Home
	};
	
	public void buttonPressed(Buttons type, Command command){
		JoystickButton newButton = new JoystickButton(this, mapButton(type));
		
		newButton.whenPressed(command);
	}
	
	public void buttonToggled(Buttons type, Command command){
		JoystickButton newButton = new JoystickButton(this, mapButton(type));
		
		newButton.toggleWhenPressed(command);
	}
	
	private int mapButton(Buttons type){
		switch(type){
			case A:
				return 1;
			case B:
				return 1;
			case X:
				return 1;
			case Y:
				return 1;
			case LB:
				return 1;
			case LT:
				return 1;
			case RB:
				return 1;
			case RT:
				return 1;
			case Start:
				return 1;
			case Back:
				return 1;
			case Home:
				return 1;
			default:
				return 1;
		}
	}
}
