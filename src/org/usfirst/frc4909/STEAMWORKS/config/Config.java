package org.usfirst.frc4909.STEAMWORKS.config;

import org.usfirst.frc4909.STEAMWORKS.utils.PIDConstants;

public class Config {
	public Config() {}
	
	public double joystickDeadzone = 0.15;
	
	public double boilerShotVelocity = 2900.0;
	public double boilerShotMinPercentage = 0.9;
	
	public double feederSpeed = 0.5;
	
	public double climberMaxSpeed = 0.5;
	public double unclimberMaxSpeed = 0.5 * climberMaxSpeed;
	
	public double[] loaderAngles = {1100, 1350, 1500};
	public PIDConstants loaderPID = new PIDConstants(0.08, 0, 0, 0.3);
	
	/* Set Shooter (set in robot map, move to subsystem), Loader, Intake, and Drivetrain PID Constants*/
}