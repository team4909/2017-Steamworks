package org.team4909.boxtop;

import org.team4909.boxtop.commands.drive.*;
import org.team4909.boxtop.commands.intake.*;
import org.team4909.boxtop.commands.led.*;
import org.team4909.boxtop.commands.loader.*;
import org.team4909.boxtop.commands.shooter.*;
import org.team4909.utils.oi.EasyJoystick;
import org.team4909.utils.oi.GamepadF310;

public class OI {
    public EasyJoystick leftDriveJoystick;
    public EasyJoystick rightDriveJoystick;
    public GamepadF310 driveGamepad;
    public GamepadF310 manipulatorGamepad;
    public EasyJoystick climberJoystick;
    
    public OI() {
    	
    	//Joystick Intializations
    	leftDriveJoystick = new EasyJoystick(0);
        rightDriveJoystick = new EasyJoystick(1);
        driveGamepad = new GamepadF310(2);
        manipulatorGamepad = new GamepadF310(3);
        climberJoystick = new EasyJoystick(4);

    	//Tank Drivetrain
        leftDriveJoystick.buttonPressed(1, new InvertDrive());		//Trigger (Left Joystick)
        rightDriveJoystick.buttonPressed(1, new ShiftCommand());	//Trigger (Right Joystick)

        //Arcade Drivetrain
        driveGamepad.buttonPressed(GamepadF310.Buttons.LT, new InvertDrive());			//Left Trigger
        driveGamepad.buttonPressed(GamepadF310.Buttons.RT, new ShiftCommand());			//Right Trigger
        
        //Human Player LEDs
        driveGamepad.buttonPressed(1, new ColorBlue());
        driveGamepad.buttonPressed(10, new ColorGreen());
        driveGamepad.buttonPressed(3, new ColorRed());
        driveGamepad.buttonPressed(4, new ColorPurple());
        driveGamepad.buttonPressed(2, new ColorWhite());
        driveGamepad.buttonPressed(9, new ColorReset());
        
        
        //Loader
        manipulatorGamepad.buttonPressed(GamepadF310.Buttons.A, new DropGear());
        manipulatorGamepad.buttonPressed(GamepadF310.Buttons.B, new CatchGear());
        manipulatorGamepad.buttonPressed(GamepadF310.Buttons.Y, new PegGear());
        manipulatorGamepad.buttonPressed(GamepadF310.Buttons.X, new HoldGear());

        
        //Shooting
        manipulatorGamepad.buttonToggled(GamepadF310.Buttons.LB, new BoilerShot());
        manipulatorGamepad.buttonPressed(GamepadF310.Buttons.LT, new FeederOn());

        //Intake Polycord
        manipulatorGamepad.buttonPressed(GamepadF310.Buttons.RT, new IntakeIn());
        manipulatorGamepad.buttonPressed(GamepadF310.Buttons.RB, new IntakeOut());
    }
}