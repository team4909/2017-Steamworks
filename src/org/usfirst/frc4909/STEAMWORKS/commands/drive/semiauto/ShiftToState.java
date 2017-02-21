package org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto;

import edu.wpi.first.wpilibj.command.InstantCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4909.STEAMWORKS.Robot;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain.ShiftingRobotDrive.Gear;

public class ShiftToState extends InstantCommand {
	private Gear state;
	
    public ShiftToState(Gear initState) {
        requires(Robot.drivetrain);
        
        state = initState;
    }

    protected void initialize() {
    	Robot.drivetrain.robotDrive.shift(state);
    	
    	SmartDashboard.putNumber("Times Shifted", SmartDashboard.getNumber("Times Shifted", 0) + 1);
    }
}