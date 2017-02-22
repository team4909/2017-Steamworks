package org.usfirst.frc4909.STEAMWORKS;

import org.usfirst.frc4909.STEAMWORKS.commands.climb.ClimbCommand;
import org.usfirst.frc4909.STEAMWORKS.commands.climb.ClimbManual;
import org.usfirst.frc4909.STEAMWORKS.commands.drive.*;
import org.usfirst.frc4909.STEAMWORKS.commands.intake.*;
import org.usfirst.frc4909.STEAMWORKS.commands.loader.*;
import org.usfirst.frc4909.STEAMWORKS.commands.shooter.*;
import org.usfirst.frc4909.STEAMWORKS.utils.Joystick;

public class OI {
    public Joystick leftDriveJoystick;
    public Joystick rightDriveJoystick;
  
    public Joystick driveGamepad;
    public Joystick manipulatorGamepad;
    
    public OI() {
    	leftDriveJoystick = new Joystick(0);
        rightDriveJoystick = new Joystick(1);
        leftDriveJoystick.buttonPressed(1, new InvertDrive());
        rightDriveJoystick.buttonPressed(1, new ShiftCommand());
        rightDriveJoystick.buttonPressed(4, new ClimbManual());

        driveGamepad = new Joystick(2);
        driveGamepad.buttonPressed(1, new InvertDrive());
        driveGamepad.buttonPressed(3, new ShiftCommand());
        
        manipulatorGamepad = new Joystick(3);

        manipulatorGamepad.buttonPressed(1, new PegGear());

        manipulatorGamepad.buttonPressed(2, new DropGear());
        manipulatorGamepad.buttonPressed(3, new CatchGear());
        manipulatorGamepad.buttonPressed(4, new HoldGear());
        

        manipulatorGamepad.buttonPressed(5, new Pivot());
        manipulatorGamepad.buttonToggled(6, new BoilerShot());

        manipulatorGamepad.buttonPressed(7, new IntakeIn());
        
        manipulatorGamepad.buttonPressed(8, new FeederOn());
      
        manipulatorGamepad.buttonPressed(9, new IntakeOut());

        
//        manipulatorJoystick.buttonPressed(1, new BoilerShot());
//        manipulatorJoystick.buttonPressed(2, new IntakeIn());
//        manipulatorJoystick.buttonPressed(3, new IntakeOff());
//        manipulatorJoystick.buttonPressed(4, new DropGear());
//        manipulatorJoystick.buttonPressed(5, new CatchGear());
//        manipulatorJoystick.buttonPressed(6, new FeederOn());
//        manipulatorJoystick.buttonPressed(7, new HoldGear());
//        manipulatorJoystick.buttonPressed(8, new StopShooting());
//        manipulatorJoystick.buttonPressed(9, new LoaderOpenManual());
//        manipulatorJoystick.buttonPressed(10, new LoaderCloseManual());
//        manipulatorJoystick.buttonPressed(11, new IntakeOut());
    }
}