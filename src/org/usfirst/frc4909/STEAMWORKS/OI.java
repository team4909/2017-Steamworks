package org.usfirst.frc4909.STEAMWORKS;

import org.usfirst.frc4909.STEAMWORKS.commands.drive.*;
import org.usfirst.frc4909.STEAMWORKS.commands.intake.*;
import org.usfirst.frc4909.STEAMWORKS.commands.loader.*;
import org.usfirst.frc4909.STEAMWORKS.commands.shooter.*;
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
        
        manipulatorJoystick.buttonPressed(1, new BoilerShot());
        manipulatorJoystick.buttonPressed(2, new IntakeIn());
        manipulatorJoystick.buttonPressed(3, new IntakeOff());
        manipulatorJoystick.buttonPressed(4, new DropGear());
        manipulatorJoystick.buttonPressed(5, new CatchGear());
        manipulatorJoystick.buttonPressed(6, new FeederOn());
        manipulatorJoystick.buttonPressed(7, new HoldGear());
        manipulatorJoystick.buttonPressed(8, new StopShooting());
        manipulatorJoystick.buttonPressed(9, new LoaderOpenManual());
        manipulatorJoystick.buttonPressed(10, new LoaderCloseManual());
        manipulatorJoystick.buttonPressed(11, new IntakeOut());
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