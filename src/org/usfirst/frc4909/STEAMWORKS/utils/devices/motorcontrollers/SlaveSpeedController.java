package org.usfirst.frc4909.STEAMWORKS.utils.devices.motorcontrollers;

public class SlaveSpeedController extends SpeedController {
	private double multiplier;
	
	public SlaveSpeedController(edu.wpi.first.wpilibj.SpeedController initSpeedController, double initMultiplier) {
		super(initSpeedController);
		
		multiplier = initMultiplier;
	}

	public void set(double speed) {
		speedController.set(speed * multiplier);
	}
}
