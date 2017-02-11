package org.usfirst.frc4909.STEAMWORKS;

import org.usfirst.frc4909.STEAMWORKS.commands.*;
import org.usfirst.frc4909.STEAMWORKS.utils.Joystick;

public class OI {
    public Joystick leftDriveJoystick;
    public Joystick rightDriveJoystick;
    public Joystick manipulatorJoystick;
    
    public OI() {
    	leftDriveJoystick = new Joystick(0);
        rightDriveJoystick = new Joystick(1);
        
        manipulatorJoystick = new Joystick(2);
        
        rightDriveJoystick.buttonPressed(1, new ShiftCommand());
        
        leftDriveJoystick.buttonPressed(10, new SetInversionDrive());
        leftDriveJoystick.buttonPressed(11, new UnsetInversionDrive());
        
        leftDriveJoystick.buttonHeld(1, new ClimbCommand());
        leftDriveJoystick.buttonHeld(6, new UnclimbCommand());

        manipulatorJoystick.buttonPressed(0, new BoilerShot());
        manipulatorJoystick.buttonPressed(1, new StopShooting());
        
        manipulatorJoystick.buttonPressed(2, new FeederOn());
        
        manipulatorJoystick.buttonPressed(3, new HoldGear());
        manipulatorJoystick.buttonPressed(4, new DropGear());
        manipulatorJoystick.buttonPressed(5, new CatchGear());
    }
   
    public Joystick getLeftDriveJoystick() {
        return leftDriveJoystick;
    }

    public Joystick getRightDriveJoystick() {
        return rightDriveJoystick;
    }

    public Joystick getManipulatorJoystick() {
        return manipulatorJoystick;
    }
}