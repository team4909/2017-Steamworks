package org.team4909.utils.devices;

import org.team4909.utils.devices.drivetrain.NavX;
import org.team4909.utils.devices.motorcontrollers.SpeedController;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

public class Devices {
	public Devices() {}

	public static SpeedController addMotor (String subsystem, String name, edu.wpi.first.wpilibj.SpeedController rawMotor){
		SpeedController motor = new SpeedController(rawMotor);
		
        LiveWindow.addActuator(subsystem, subsystem + name, (LiveWindowSendable) motor);
		
		return motor;
	}
	
	public static Encoder addEncoder (String subsystem, String name, Encoder enc){
        LiveWindow.addSensor(subsystem, subsystem + name, (LiveWindowSendable) enc);
		
		return enc;
	}
	
	public static Encoder addEncoder (String subsystem, String name, Encoder enc, double distancePerPulse){
		enc.setDistancePerPulse(distancePerPulse);
        LiveWindow.addSensor(subsystem, subsystem + name, (LiveWindowSendable) enc);
		
		return enc;
	}
	
	public static Potentiometer addPotentiometer (String subsystem, String name, Potentiometer pot){
        LiveWindow.addSensor(subsystem, subsystem + name, (LiveWindowSendable) pot);
		
		return pot;
	}
	
	public static DigitalInput addDigitalInput (int channel){
		return new DigitalInput(channel);
	}
	
	public static AHRS addNavX (edu.wpi.first.wpilibj.SerialPort.Port kmxp){
		return new NavX(kmxp);
	}
}
