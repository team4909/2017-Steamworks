package org.team4909.boxtop;

import org.team4909.boxtop.commands.drive.*;
import org.team4909.boxtop.commands.intake.*;
import org.team4909.boxtop.commands.led.*
import org.team4909.boxtop.commands.loader.*;
import org.team4909.boxtop.commands.shooter.*;
import org.team4909.utils.Joystick;

public class OI {
    public Joystick leftDriveJoystick;
    public Joystick rightDriveJoystick;
    public Joystick driveGamepad;
    public Joystick manipulatorGamepad;
    public Joystick climberJoystick;
    
    public OI() {
    	
    	//Joystick Intializations
    	leftDriveJoystick = new Joystick(0);
        rightDriveJoystick = new Joystick(1);
        driveGamepad = new Joystick(2);
        manipulatorGamepad = new Joystick(3);
        climberJoystick = new Joystick(4);

    	//Tank Drivetrain
        leftDriveJoystick.buttonPressed(1, new InvertDrive());		//Trigger (Left Joystick)
        rightDriveJoystick.buttonPressed(1, new ShiftCommand());	//Trigger (Right Joystick)
//        rightDriveJoystick.buttonPressed(3, new lineUpToPeg());	-->Uncomment once/if this exists

        //Arcade Drivetrain
        driveGamepad.buttonPressed(7, new InvertDrive());			//Left Trigger
        driveGamepad.buttonPressed(8, new ShiftCommand());			//Right Trigger
//        driveGamepad.buttonPressed(6, new lineUpToPeg()); -->Uncomment once/if this exists
        
        //Human Player LEDs
        driveGamepad.buttonPressed(1, new ColorBlue());
        driveGamepad.buttonPressed(10, new ColorGreen());
        driveGamepad.buttonPressed(3, new ColorRed());
        driveGamepad.buttonPressed(4, new ColorPurple());
        driveGamepad.buttonPressed(2, new ColorWhite());
        driveGamepad.buttonPressed(9, new ColorReset());
        
        
        //Loader
        manipulatorGamepad.buttonPressed(2, new DropGear());		//A
        manipulatorGamepad.buttonPressed(3, new CatchGear());		//B
        manipulatorGamepad.buttonPressed(4, new PegGear()); 		//Y
        manipulatorGamepad.buttonPressed(1, new HoldGear());		//X

        
        //Shooting
        manipulatorGamepad.buttonToggled(6, new BoilerShot());		//Left Bumper
        manipulatorGamepad.buttonPressed(8, new FeederOn()); 		//Left Trigger, whileHeld

        //Intake Polycord
        manipulatorGamepad.buttonPressed(7, new IntakeIn());		//Right Trigger, whileHeld
        manipulatorGamepad.buttonPressed(10, new IntakeOut());		//Right Bumper, whileHeld
        
        //Intake Pivot
//        manipulatorGamepad.buttonPressed(5, new Pivot());			//Right Bumper
        
        
    }
}