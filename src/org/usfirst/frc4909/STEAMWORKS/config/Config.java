package org.usfirst.frc4909.STEAMWORKS.config;

public class Config {
	public Config() {}

	public double joystickDeadzone = 0.15;
	
	public double boilerShotVelocity = 2900.0;
	public double boilerShotMinPercentage = 0.9;
	
	public double feederSpeed = 0.5;
	
	public double climberMaxSpeed = 0.5;
	public double unclimberMaxSpeed = 0.5 * climberMaxSpeed;
}