package org.usfirst.frc4909.STEAMWORKS;

import org.usfirst.frc4909.STEAMWORKS.PID.PIDConstants;
import org.usfirst.frc4909.STEAMWORKS.PID.Potentiometer.PotentiometerPIDController;
import org.usfirst.frc4909.STEAMWORKS.config.Config;
import org.usfirst.frc4909.STEAMWORKS.utils.Devices;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Spark;

public class RobotMap {
    public static SpeedController drivetrainLeftDriveMotorController;
    public static SpeedController drivetrainRightDriveMotorController;
    public static RobotDrive drivetrainRobotDrive;
    public static Encoder drivetrainLeftEncoder;
    public static Encoder drivetrainRightEncoder;
    public static SpeedController climberClimberMotorController;
    public static Encoder climberClimberEncoder;
    public static AnalogPotentiometer intakePivotPot;
    public static SpeedController intakeIntakeMotor;
    public static SpeedController feederFeederMotor;
    public static SpeedController intakePivotMotor;
    public static SpeedController intakeCenterMotor;
    public static DigitalInput climberSwitch;
    public static CANTalon shooterMotorController ;
    public static double shooterP = 0.00015;
    public static double shooterI = 0.00000;
    public static double shooterD = 0.00000;
    public static double shooterF = 0.00050;
    public static AHRS navx;
	public static PowerDistributionPanel PDP;
	public static Compressor compressor;
	public static DoubleSolenoid shiftSolenoid;
	public static PotentiometerPIDController intakePivotPotPIDController;
	public static PotentiometerPIDController loaderPotPIDController;
    
    public static void init() {
    	// PWM Outputs
    	drivetrainLeftDriveMotorController = 	Devices.addMotor("Drivetrain", "LeftDriveMotorController", new VictorSP(0));
    	drivetrainRightDriveMotorController = 	Devices.addMotor("Drivetrain", "RightDriveMotorController", new VictorSP(1));
    	
        climberClimberMotorController = 		Devices.addMotor("Climber", "MotorController", new Spark(5));
        feederFeederMotor = 					Devices.addMotor("Feeder", "MotorController", new Spark(6));
        intakeCenterMotor = 					Devices.addMotor("Intake", "CenterMotorController", new Spark(7));
        intakePivotMotor = 						Devices.addMotor("Intake", "PivotMotorController", new Spark(8));
        
        // CAN
        shooterMotorController = new CANTalon(0);
        
        // DIO
        drivetrainLeftEncoder = Devices.addEncoder("Drivetrain", "LeftEncoder", new Encoder(0, 1, true, EncodingType.k4X));
        drivetrainRightEncoder = Devices.addEncoder("Drivetrain", "RightEncoder", new Encoder(2, 3, false, EncodingType.k4X));
        climberSwitch= Devices.addDigitalInput(8);
        
        // Pneumatics
        compressor = new Compressor(0);
        shiftSolenoid = new DoubleSolenoid(0,1);
        
        // Potentiometer PID Controllers
        intakePivotPotPIDController = new PotentiometerPIDController(
           	"Intake",
           	new Spark(2),
            new AnalogPotentiometer(1, 3600, 0),
            new double[] {0, 90}, // Up, Down
            new PIDConstants(0.01, 0, 0, 0.7)
        );
        
        loaderPotPIDController = new PotentiometerPIDController(
        	"Loader",
        	new Spark(9),
        	new AnalogPotentiometer(1, 3600, -2260),
        	new double[] {0, 250, 400}, // Hold, Catch, Drop
        	new PIDConstants(0.01, 0, 0, 0.7)
        );

        drivetrainRobotDrive = new RobotDrive(drivetrainLeftDriveMotorController, drivetrainRightDriveMotorController);
        
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft,true);
        drivetrainRobotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight,true);
        drivetrainRobotDrive.setSafetyEnabled(true);
        drivetrainRobotDrive.setExpiration(0.1);
        drivetrainRobotDrive.setSensitivity(0.5);
        drivetrainRobotDrive.setMaxOutput(1.0);
       
        drivetrainLeftEncoder.setDistancePerPulse(1.0);
        drivetrainLeftEncoder.setPIDSourceType(PIDSourceType.kDisplacement); 
        
        drivetrainRightEncoder.setDistancePerPulse(1.0);
        drivetrainRightEncoder.setPIDSourceType(PIDSourceType.kRate);
       
        shooterMotorController.configEncoderCodesPerRev(2048);
        shooterMotorController.configNominalOutputVoltage(+0.0f, -0.0f);
        shooterMotorController.configPeakOutputVoltage(+12.0f, -12.0f);
        shooterMotorController.setProfile(0);
        shooterMotorController.setF(0.00050);
        shooterMotorController.setPID(0.00015, 0, 0);
        shooterMotorController.changeControlMode(TalonControlMode.Speed);
    
       PDP = new PowerDistributionPanel();
       
       navx = new AHRS(SerialPort.Port.kMXP);
    }
}
