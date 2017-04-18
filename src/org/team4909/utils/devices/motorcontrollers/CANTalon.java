package org.team4909.utils.devices.motorcontrollers;

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

	public void setEncoderPIDF(int codesPerRev, double p, double i, double d, double f){
		this.configEncoderCodesPerRev(codesPerRev);
        this.setPID(p, i, d);
        this.setF(f);
	}
	
	public void configVoltages(double forwardsNomVoltage, double backwardsNomVoltage, double forwardsPeakVoltage, double backwardsPeakVoltage){
	    this.configNominalOutputVoltage(forwardsNomVoltage, backwardsNomVoltage);
	    this.configPeakOutputVoltage(forwardsPeakVoltage, backwardsPeakVoltage);
	}
}
