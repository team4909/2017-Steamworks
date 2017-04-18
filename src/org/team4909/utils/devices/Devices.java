package org.team4909.utils.devices;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;

public class Devices {
	public Devices() {}

	public static edu.wpi.first.wpilibj.SpeedController addMotor (String subsystem, String name, SpeedController motor){
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
		return new AHRS(kmxp);
	}
}
