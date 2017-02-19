package org.usfirst.frc4909.STEAMWORKS.utils.PID.Potentiometer;

import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDConstants;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

public class PotentiometerPIDController {
	private final SpeedController motor;
	private final AnalogPotentiometer pot;
	private final double[] positions;
	private final PIDConstants constants;
	
	public PotentiometerPIDController(String subsystem, SpeedController initMotor, AnalogPotentiometer initPot, double[] initPositions, PIDConstants initConstants) {
		motor = initMotor;
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
	
	public PIDConstants getPID(){
		return constants;
	}
}
