package org.usfirst.frc4909.STEAMWORKS.config;

import org.usfirst.frc4909.STEAMWORKS.utils.PIDConstants;

public class Config {
	public Config() {}
	
	public static double joystickDeadzone = 0.15;
	
	public static double boilerShotVelocity = 2900.0;
	public static double boilerShotMinPercentage = 0.9;
	
	public static double feederSpeed = 0.5;
	
	public static double climberMaxSpeed = 0.5;
	public static double unclimberMaxSpeed = 0.5 * climberMaxSpeed;
	
	public static double[] loaderAngles = {1100, 1350, 1500};
	public static PIDConstants loaderPID = new PIDConstants(0.01, 0, 0, 0.7);
	
	/* Set Shooter (set in robot map, move to subsystem), Loader, Intake, and Drivetrain PID Constants*/
}	