package org.usfirst.frc4909.STEAMWORKS.config;

public class Config {
	public Config() {}

	public double getFeederMaxSpeed(){
		return 0.5;
	}
	
	public double getClimberMaxSpeed(){
		return .53;
	}
	
	public double getUnclimberMaxSpeed(){
		return -(this.getClimberMaxSpeed() * 0.5);
	}
}
