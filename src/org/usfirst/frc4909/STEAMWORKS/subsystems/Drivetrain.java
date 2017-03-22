package org.usfirst.frc4909.STEAMWORKS.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.commands.drive.*;
import org.usfirst.frc4909.STEAMWORKS.utils.Subsystem;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain.NavX;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain.ShiftingRobotDrive;

public class Drivetrain extends Subsystem {
	public ShiftingRobotDrive robotDrive 	= RobotMap.drivetrainRobotDrive;
	public NavX navx 						= RobotMap.navx;
	
    private final Encoder leftEncoder 	= RobotMap.drivetrainLeftEncoder;
    private final Encoder rightEncoder 	= RobotMap.drivetrainRightEncoder;
	private final double ENCODER_RATIO 	= 3.0;
	private final double pulsesPerRev 	= 1440.0 / ENCODER_RATIO;
	
	// in inches
	private final double wheelDiameter 	= 4.0;
	private final double wheelCircumference = Math.PI * wheelDiameter;
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveCommand());
    }

	public void moveTank(){
	    double leftY 	= Robot.oi.leftDriveJoystick.getThresholdAxis(1, 0.1);
	    double rightY 	= Robot.oi.rightDriveJoystick.getThresholdAxis(1, 0.1);
	    	
    	robotDrive.tankDrive(leftY, rightY);
    }
	
	public void moveArcade(){
	    double power 	= Robot.oi.driveGamepad.getThresholdAxis(1, 0.1);
		double rot 		= Robot.oi.driveGamepad.getThresholdAxis(2, 0.1);
	    	
		robotDrive.arcadeDrive(power, rot);
    }
    
    public void stop(){
    	robotDrive.stop();
    }
	
    public double getLeftEncDistance(){
    	return (leftEncoder.getRaw()/pulsesPerRev) * wheelCircumference;
    }
    
    public double getRightEncDistance(){
    	return (rightEncoder.getRaw()/pulsesPerRev) * wheelCircumference;
    }
    
    public double voltageRamp(double time){
    	return (.02/time);		//.02 can be replaced with time of loop if .02 is too inaccurate
    }
    
    public boolean isBlue(){
    	return DriverStation.getInstance().getAlliance() == DriverStation.Alliance.Blue;
    }
}