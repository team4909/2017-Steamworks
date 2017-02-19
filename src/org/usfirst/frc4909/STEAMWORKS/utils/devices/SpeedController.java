package org.usfirst.frc4909.STEAMWORKS.utils.devices;

public class SpeedController implements edu.wpi.first.wpilibj.SpeedController {
	private final edu.wpi.first.wpilibj.SpeedController speedController;
	
	public SpeedController(edu.wpi.first.wpilibj.SpeedController initSpeedController) {
		speedController = initSpeedController;
	}

	public void pidWrite(double output) {
		speedController.pidWrite(output);
	}

	public double get() {
		return speedController.get();
	}

	public void set(double speed) {
		speedController.set(speed);
	}

	public void setInverted(boolean isInverted) {
		speedController.setInverted(isInverted);		
	}

	public boolean getInverted() {
		return speedController.getInverted();
	}

	public void disable() {
		speedController.disable();
	}

	public void stopMotor() {
		speedController.stopMotor();
	}
}
