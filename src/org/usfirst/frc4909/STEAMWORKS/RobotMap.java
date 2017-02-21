package org.usfirst.frc4909.STEAMWORKS;

import org.usfirst.frc4909.STEAMWORKS.utils.PID.PIDConstants;
import org.usfirst.frc4909.STEAMWORKS.utils.PID.Position.PotentiometerPIDController;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.*;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain.NavX;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain.ShiftingRobotDrive;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.motorcontrollers.*;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class RobotMap {
	public static PowerDistributionPanel PDP;
	
    public static NavX navx;
	
    public static SpeedController drivetrainLeftDriveMotorController;
    public static SpeedController drivetrainRightDriveMotorController;
    
    public static SpeedController intakeIntakeMotor;
    public static SpeedController climberClimberMotorController;
    public static SpeedController feederFeederMotor;
    public static SpeedController intakeCenterMotor;

    public static CANTalon shooterMotorController;

    public static Encoder drivetrainLeftEncoder;
    public static Encoder drivetrainRightEncoder;
    public static DigitalInput climberSwitch;

	public static Compressor compressor;
	public static DoubleSolenoid shiftSolenoid;

	public static PotentiometerPIDController intakePivotPotPIDController;
	public static PotentiometerPIDController loaderPotPIDController;
	
    public static ShiftingRobotDrive drivetrainRobotDrive;
    
    public static void init() {
    	// PDP Interface
        PDP = 									new PowerDistributionPanel();
        
        // NavX Board
        navx = 									Devices.addNavX(SerialPort.Port.kMXP);
        
    	// PWM Outputs
    	drivetrainLeftDriveMotorController = 	Devices.addMotor("Drivetrain", "LeftDriveMotorController", new VictorSP(0));
    	drivetrainRightDriveMotorController = 	Devices.addMotor("Drivetrain", "RightDriveMotorController", new VictorSP(1));

        intakeIntakeMotor = 					Devices.addMotor("Intake", "IntakeMotorController", new Spark(2));
        climberClimberMotorController = 		Devices.addMotor("Climber", "MotorController", new Spark(5));
        feederFeederMotor = 					Devices.addMotor("Feeder", "MotorController", new Spark(3));
        intakeCenterMotor =						intakeIntakeMotor.addSlaveMotor(new Spark(7), -1.52);
        
        // CAN
        shooterMotorController = 				new CANTalon(0);
        
        // DIO
        drivetrainLeftEncoder = 				Devices.addEncoder("Drivetrain", "LeftEncoder", new Encoder(0, 1, true, EncodingType.k4X), 1.0);
        drivetrainRightEncoder = 				Devices.addEncoder("Drivetrain", "RightEncoder", new Encoder(2, 3, false, EncodingType.k4X), 1.0);
        climberSwitch= 							Devices.addDigitalInput(8);
        
        // Pneumatics
        compressor = 							new Compressor(0);
        // Potentiometer PID Controllers
        intakePivotPotPIDController = new PotentiometerPIDController(
           	"Intake",
           	new Spark(8),
           	true,
            new AnalogPotentiometer(2, 3600, 0),
            new double[] {1627, 1710}, // Up, Down
        	new PIDConstants(0.05, 0, 0, 1.0)
        );
        
        loaderPotPIDController = new PotentiometerPIDController(
        	"Loader",
        	new Spark(9),
        	new AnalogPotentiometer(1, 3600, -2260),
        	new double[] {0, 250, 400}, // Hold, Catch, Drop
            new PIDConstants(0.01, 0, 0, 0.7)
        );

        // Robot Drive
        drivetrainRobotDrive = new ShiftingRobotDrive(
        	drivetrainLeftDriveMotorController,
        	drivetrainRightDriveMotorController,
        	true, // Invert Motor Controllers
        	true, // Enable Safety
        	new DoubleSolenoid(0,1) // Shifting Solenoid
        );
        
        // Configure Shooter Motor
        shooterMotorController.setInverted(true);
//        shooterMotorController.configVoltages(+0.0f, -0.0f,+12.0f, -12.0f);
//        shooterMotorController.setProfile(0);
        //20,.0005,0,0,.0005
//        shooterMotorController.setEncoderPIDF(20, 0.005, 0, 0, 0.50);
//        shooterMotorController.changeControlMode(TalonControlMode.PercentVbus);
    }
}
