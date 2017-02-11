package org.usfirst.frc4909.STEAMWORKS;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class RobotMap {
    public static SpeedController drivetrainLeftFrontDriveMotorController;
    public static SpeedController drivetrainLeftBackDriveMotorController;
    public static SpeedController drivetrainRightBackDriveMotorController;
    public static SpeedController drivetrainRightFrontDriveMotorController;
    public static RobotDrive drivetrainRobotDrive;
    public static Encoder drivetrainLeftEncoder;
    public static Encoder drivetrainRightEncoder;
    public static SpeedController climberClimberMotorController;
    public static Encoder climberClimberEncoder;
    public static AnalogPotentiometer intakePivotPot;
    public static SpeedController intakeIntakeMotor;
    public static SpeedController feederFeederMotor;
    public static SpeedController intakePivotMotor;
    public static SpeedController loaderMotor;
    public static AnalogPotentiometer loaderPivotPot;
    public static DigitalInput climberSwitch;
    public static CANTalon shooterMotorController ;
    public static double shooterP = 0.00015;
    public static double shooterI = 0.00000;
    public static double shooterD = 0.00000;
    public static double shooterF = 0.00050;
    public static AHRS navx;
	public static PowerDistributionPanel PDP;
	public static Compressor compressor;
	public static Solenoid leftSolenoid;
	public static Solenoid rightSolenoid;
    
    public static void init() {
        
        drivetrainLeftFrontDriveMotorController = new VictorSP(0);
        LiveWindow.addActuator("Drivetrain", "LeftFrontDriveMotorController", (VictorSP) drivetrainLeftFrontDriveMotorController);
        
        drivetrainLeftBackDriveMotorController = new VictorSP(1);
        LiveWindow.addActuator("Drivetrain", "LeftBackDriveMotorController", (VictorSP) drivetrainLeftBackDriveMotorController);

        drivetrainRightFrontDriveMotorController = new VictorSP(2);
        LiveWindow.addActuator("Drivetrain", "RightFrontDriveMotorController", (VictorSP) drivetrainRightFrontDriveMotorController);
        
        drivetrainRightBackDriveMotorController = new VictorSP(3);
        LiveWindow.addActuator("Drivetrain", "RightBackDriveMotorController", (VictorSP) drivetrainRightBackDriveMotorController);

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
        drivetrainLeftEncoder = new Encoder(0, 1, true, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "LeftEncoder", drivetrainLeftEncoder);
        drivetrainLeftEncoder.setDistancePerPulse(1.0);
        drivetrainLeftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
        drivetrainRightEncoder = new Encoder(2, 3, false, EncodingType.k4X);
        LiveWindow.addSensor("Drivetrain", "RightEncoder", drivetrainRightEncoder);
        drivetrainRightEncoder.setDistancePerPulse(1.0);
        drivetrainRightEncoder.setPIDSourceType(PIDSourceType.kRate);
        climberClimberMotorController = new Spark(5);
        LiveWindow.addActuator("Climber", "ClimberMotorController", (Spark) climberClimberMotorController);
        
        climberClimberEncoder = new Encoder(4, 5, false, EncodingType.k4X);
        LiveWindow.addSensor("Climber", "ClimberEncoder", climberClimberEncoder);
        climberClimberEncoder.setDistancePerPulse(1.0);
        climberClimberEncoder.setPIDSourceType(PIDSourceType.kRate);
        intakePivotPot = new AnalogPotentiometer(0, 3600.0, 0.0);
        LiveWindow.addSensor("Intake", "PivotPot", intakePivotPot);
        
        intakeIntakeMotor = new Spark(7);
        LiveWindow.addActuator("Intake", "IntakeMotor", (Spark) intakeIntakeMotor);
        
        feederFeederMotor = new Spark(6);
        LiveWindow.addActuator("Feeder", "FeederMotor", (Spark) feederFeederMotor);
        
        shooterMotorController = new CANTalon(0);
        shooterMotorController.configEncoderCodesPerRev(2048);
        shooterMotorController.reverseSensor(false);
        shooterMotorController.configNominalOutputVoltage(+0.0f, -0.0f);
        shooterMotorController.configPeakOutputVoltage(+12.0f, -12.0f);
        shooterMotorController.setProfile(0);
        shooterMotorController.setF(0.00050);
        shooterMotorController.setP(0.00015);
        shooterMotorController.setI(0); 
        shooterMotorController.setD(0);
        shooterMotorController.changeControlMode(TalonControlMode.Speed);
        
        navx = new AHRS(SerialPort.Port.kMXP);

    	PDP = new PowerDistributionPanel();
    
    	loaderMotor = new Spark(9);
    	 	LiveWindow.addActuator("Loader", "LoaderMotor", (Spark) loaderMotor);
    	loaderPivotPot = new AnalogPotentiometer(1, 3600, 0.0);
       LiveWindow.addSensor("Loader", "PivotPot", loaderPivotPot);
       
       intakePivotMotor= new Spark(8);
       LiveWindow.addActuator("Intake", "IntakePivotMotorController", (Spark) intakePivotMotor);
       
       climberSwitch= new DigitalInput(8);
       
       Compressor compressor = new Compressor(0);
       
       Solenoid leftSolenoid = new Solenoid(0);
       Solenoid rightSolenoid = new Solenoid(1);
    }
}
