package org.team4909.boxtop;

import org.team4909.utils.PID.PIDConstants;
import org.team4909.utils.PID.Position.PotentiometerPIDController;
import org.team4909.utils.devices.*;
import org.team4909.utils.devices.drivetrain.NavX;
import org.team4909.utils.devices.drivetrain.ShiftingRobotDrive;
import org.team4909.utils.devices.motorcontrollers.*;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.AnalogInput;
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
	public static Solenoid shiftSolenoidSingle;

	public static PotentiometerPIDController intakePivotPotPIDController;
	public static PotentiometerPIDController loaderPotPIDController;

	public static ShiftingRobotDrive drivetrainRobotDrive;
	
	public static AnalogInput intakeGearDetector;;


	public static void init() {
		// PDP Interface
		PDP = new PowerDistributionPanel(1);

		// NavX Board
		navx = Devices.addNavX(SerialPort.Port.kMXP);

		// PWM Outputs
		drivetrainLeftDriveMotorController = Devices.addMotor("Drivetrain", "LeftDriveMotorController",
				new VictorSP(0));
		drivetrainRightDriveMotorController = Devices.addMotor("Drivetrain", "RightDriveMotorController",
				new VictorSP(1));

		intakeIntakeMotor = Devices.addMotor("Intake", "IntakeMotorController", new Spark(2));
		climberClimberMotorController = Devices.addMotor("Climber", "MotorController", new Spark(7));
		feederFeederMotor = Devices.addMotor("Feeder", "MotorController", new Spark(3));
		intakeCenterMotor = intakeIntakeMotor.addSlaveMotor(new Spark(5), -1.52);

		// CAN
		shooterMotorController = new CANTalon(2);

		// DIO
		drivetrainLeftEncoder = Devices.addEncoder("Drivetrain", "LeftEncoder",
				new Encoder(0, 1, false, EncodingType.k4X), 1.0);
		drivetrainRightEncoder = Devices.addEncoder("Drivetrain", "RightEncoder",
				new Encoder(2, 3, true, EncodingType.k4X), 1.0);
		climberSwitch = Devices.addDigitalInput(4);

		// Pneumatics
		compressor = new Compressor(0);
		// Potentiometer PID Controllers
		intakePivotPotPIDController = new PotentiometerPIDController("Intake", new Spark(8), true,
				new AnalogPotentiometer(2, 3600, Preferences.getInstance().getInt("intakeOffsetPref", 0)),
				new double[] { Preferences.getInstance().getDouble("intakeUpPref", 2122),
						Preferences.getInstance().getDouble("intakeDownPref", 2222) }, // Up,
																							// Down
				new PIDConstants(0.023, 0, 0, 0.4));
//		new PIDConstants(0.023, 0, 0, 0.7));
		
		intakeGearDetector = new AnalogInput(3);
		
		loaderPotPIDController = new PotentiometerPIDController("Loader", new Spark(9),
				new AnalogPotentiometer(1, 3600, Preferences.getInstance().getDouble("loaderOffsetPref", -2270)),
				new double[] { Preferences.getInstance().getDouble("loaderHoldPref", 0),
						Preferences.getInstance().getDouble("loaderCatchPref", 250),
						Preferences.getInstance().getDouble("loaderDropPref", 390),
						Preferences.getInstance().getDouble("loaderPegPref", 55) }, // Hold,
																					// Catch,
																					// Drop,
																					// Peg

				new PIDConstants(0.01, 0, 0, 0.7));

		// Robot Drive
		drivetrainRobotDrive = new ShiftingRobotDrive(drivetrainLeftDriveMotorController,
				drivetrainRightDriveMotorController, true, // Invert Motor
															// Controllers
				true, // Enable Safety
				// new DoubleSolenoid(0,1)); // Shifting Solenoid
				new Solenoid(0));

		// Configure Shooter Motor
		shooterMotorController.setFeedbackDevice(FeedbackDevice.QuadEncoder);

		shooterMotorController.setInverted(true);
		shooterMotorController.reverseSensor(false);

		shooterMotorController.configVoltages(+0.0f, -0.0f, +12.0f, -12.0f);
		// shooterMotorController.setProfile(0);
		// 20,.0005,0,0,.0005
		shooterMotorController.setEncoderPIDF(1024, 0.004, 0, 0, 0.028);
		shooterMotorController.changeControlMode(TalonControlMode.Speed);
	}
}
