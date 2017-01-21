// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4909.STEAMWORKS;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController drivetrainLeftFrontDriveMotorController;
    public static SpeedController drivetrainLeftBackDriveMotorController;
    public static SpeedController drivetrainRightBackDriveMotorController;
    public static SpeedController drivetrainRightFrontDriveMotorController;
    public static RobotDrive drivetrainRobotDrive;
    public static SpeedController climberClimberMotorController;
    public static Encoder shooterShooterEncoder;
    public static SpeedController shooterShooterMotorController;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrainLeftFrontDriveMotorController = new Talon(0);
        LiveWindow.addActuator("Drivetrain", "LeftFrontDriveMotorController", (Talon) drivetrainLeftFrontDriveMotorController);
        
        drivetrainLeftBackDriveMotorController = new Talon(1);
        LiveWindow.addActuator("Drivetrain", "LeftBackDriveMotorController", (Talon) drivetrainLeftBackDriveMotorController);
        
        drivetrainRightBackDriveMotorController = new Talon(3);
        LiveWindow.addActuator("Drivetrain", "RightBackDriveMotorController", (Talon) drivetrainRightBackDriveMotorController);
        
        drivetrainRightFrontDriveMotorController = new Talon(2);
        LiveWindow.addActuator("Drivetrain", "RightFrontDriveMotorController", (Talon) drivetrainRightFrontDriveMotorController);
        
        drivetrainRobotDrive = new RobotDrive(drivetrainLeftFrontDriveMotorController, drivetrainLeftBackDriveMotorController,
              drivetrainRightFrontDriveMotorController, drivetrainRightBackDriveMotorController);
        
        drivetrainRobotDrive.setSafetyEnabled(true);
        drivetrainRobotDrive.setExpiration(0.1);
        drivetrainRobotDrive.setSensitivity(0.5);
        drivetrainRobotDrive.setMaxOutput(1.0);
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        climberClimberMotorController = new Talon(5);
        LiveWindow.addActuator("Climber", "ClimberMotorController", (Talon) climberClimberMotorController);
        
        shooterShooterEncoder = new Encoder(0, 1, true, EncodingType.k4X);
        LiveWindow.addSensor("Shooter", "ShooterEncoder", shooterShooterEncoder);
        shooterShooterEncoder.setDistancePerPulse(1.0);
        shooterShooterEncoder.setPIDSourceType(PIDSourceType.kRate);
        shooterShooterMotorController = new Talon(4);
        LiveWindow.addActuator("Shooter", "ShooterMotorController", (Talon) shooterShooterMotorController);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
