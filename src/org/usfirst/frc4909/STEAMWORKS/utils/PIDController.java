package org.usfirst.frc4909.STEAMWORKS.utils;

public class PIDController extends org.usfirst.frc4909.STEAMWORKS.PID.PIDController {

	public PIDController(double p, double i, double d, double max) {
		super(p, i, d, max);
	}
	
	public PIDController(PIDConstants constants){
		super(constants.p, constants.i, constants.d, constants.max);
	}

	public PIDController(PotentiometerPIDController potentiometerPIDController) {
		super(potentiometerPIDController.getPID().p, potentiometerPIDController.getPID().i, potentiometerPIDController.getPID().d, potentiometerPIDController.getPID().max);
	}
}
