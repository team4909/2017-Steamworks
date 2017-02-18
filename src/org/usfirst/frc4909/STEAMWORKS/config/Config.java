package org.usfirst.frc4909.STEAMWORKS.config;

public class Config {
	public Config() {}

	public double joystickDeadzone = 0.15;
	
	public double boilerShotVelocity = 2900.0;
	public double boilerShotMinPercentage = 0.9;
	
	public double feederSpeed = 0.5;
	
	public double climberMaxSpeed = 0.5;
	public double unclimberMaxSpeed = 0.5 * climberMaxSpeed;
	
	public double dropGearAngle = 1500;
	public double holdGearAngle = 1100;
	public double catchGearAngle = 1350;
	
	
	/* Set Shooter (set in robot map, move to subsystem), Loader, Intake, and Drivetrain PID Constants*/
}