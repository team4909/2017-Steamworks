package org.usfirst.frc4909.STEAMWORKS.utils.devices.motorcontrollers;

public class CANTalon extends com.ctre.CANTalon {
	public CANTalon(int deviceNumber) {
		super(deviceNumber);
	}
	
	public CANTalon(int deviceNumber, int controlPeriodMs) {
		super(deviceNumber, controlPeriodMs);
	}

	public CANTalon(int deviceNumber, int controlPeriodMs, int enablePeriodMs) {
		super(deviceNumber, controlPeriodMs, enablePeriodMs);
	}

}
