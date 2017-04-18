package org.team4909.utils.PID.Position;

import org.team4909.utils.PID.EasyPIDConstants;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

public class EasyPotentiometerPIDController {
	private final SpeedController motor;
	private final AnalogPotentiometer pot;
	private final double[] positions;
	private final EasyPIDConstants constants;
	
	public EasyPotentiometerPIDController(String subsystem, SpeedController initMotor, AnalogPotentiometer initPot, double[] initPositions, EasyPIDConstants initConstants) {
		motor = initMotor;
		pot = initPot;
		
		positions = initPositions;
		constants = initConstants;
		
    	LiveWindow.addActuator(subsystem, subsystem + "Motor", (LiveWindowSendable) motor);
    	LiveWindow.addSensor(subsystem, subsystem + "Pot", pot);
	}
	
	public EasyPotentiometerPIDController(String subsystem, SpeedController initMotor, boolean inverted, AnalogPotentiometer initPot, double[] initPositions, EasyPIDConstants initConstants) {
		motor = initMotor;
		motor.setInverted(inverted);
    
		pot = initPot;
		
		positions = initPositions;
		constants = initConstants;
		
    	LiveWindow.addActuator(subsystem, subsystem + "Motor", (LiveWindowSendable) motor);
    	LiveWindow.addSensor(subsystem, subsystem + "Pot", pot);
	}
	
	public SpeedController getMotor(){
		return motor;
	}
	
	public AnalogPotentiometer getPot(){
		return pot;
	}
	
	public double[] getPositions(){
		return positions;
	}
	
	public EasyPIDConstants getPID(){
		return constants;
	}
}
