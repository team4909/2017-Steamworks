package org.usfirst.frc4909.STEAMWORKS.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc4909.STEAMWORKS.RobotMap;
import org.usfirst.frc4909.STEAMWORKS.commands.*;

public class Intake extends Subsystem {
    private final AnalogPotentiometer pivotPot = RobotMap.intakePivotPot;
    private final SpeedController intakeMotor = RobotMap.intakeIntakeMotor;
    
    public void initDefaultCommand() {}
}