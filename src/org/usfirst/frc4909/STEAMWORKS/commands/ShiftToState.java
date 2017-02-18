package org.usfirst.frc4909.STEAMWORKS.commands;

import org.usfirst.frc4909.STEAMWORKS.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 *
 */
public class ShiftToState extends InstantCommand {
	private Value shiftState;
    public ShiftToState(Value state) {
        super();
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	shiftState=state;

    }

    // Called once when the command executes
    protected void initialize() {
    	Robot.drivetrain.shift(shiftState);
    }

}
