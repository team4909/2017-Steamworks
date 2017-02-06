// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4909.STEAMWORKS;

import org.usfirst.frc4909.STEAMWORKS.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc4909.STEAMWORKS.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    public JoystickButton climbJoystickButton;
    public JoystickButton unclimbJoystickButton;
    public Joystick leftDriveJoystick;
    public JoystickButton shiftUpJoystickButton;
    public JoystickButton shiftDownJoystickButton;
    public Joystick rightDriveJoystick;
    public Joystick manipulatorJoystick;

    public JoystickButton rotateButton;
    public JoystickButton straightButton;
    public JoystickButton shootButton;
    public JoystickButton feedButton;
    public JoystickButton stopShootButton;
    


    public OI() {

        manipulatorJoystick = new Joystick(2);
        
        rightDriveJoystick = new Joystick(1);
        
        shiftDownJoystickButton = new JoystickButton(rightDriveJoystick, 2);
        shiftDownJoystickButton.whenPressed(new ShiftDownCommand());
        shiftUpJoystickButton = new JoystickButton(rightDriveJoystick, 1);
        shiftUpJoystickButton.whenPressed(new ShiftUpCommand());
        leftDriveJoystick = new Joystick(0);
        
        unclimbJoystickButton = new JoystickButton(leftDriveJoystick, 6);
        unclimbJoystickButton.whileHeld(new UnclimbCommand());
        climbJoystickButton = new JoystickButton(leftDriveJoystick, 1);
        climbJoystickButton.whileHeld(new ClimbCommand());


        // SmartDashboard Buttons
        SmartDashboard.putData("AutonomousCommand", new AutonomousCommand());
        SmartDashboard.putData("DriveCommand", new DriveCommand());
        SmartDashboard.putData("ShiftUpCommand", new ShiftUpCommand());
        SmartDashboard.putData("ShiftDownCommand", new ShiftDownCommand());
        SmartDashboard.putData("ShootCommand", new BoilerShot());
        SmartDashboard.putData("ClimbCommand", new ClimbCommand());
        SmartDashboard.putData("UnclimbCommand", new UnclimbCommand());

        /*
         * rotateButton = new JoystickButton(manipulatorJoystick, 2);
         * rotateButton.whenPressed(new RotateToAngle());
        */
        
        straightButton = new JoystickButton(leftDriveJoystick, 7);
        straightButton.whenPressed(new DriveDist());
        
        shootButton = new JoystickButton(manipulatorJoystick,0);
        shootButton.whenPressed(new BoilerShot());
        
        stopShootButton = new JoystickButton(manipulatorJoystick,1);
        stopShootButton.whenPressed(new StopShooting());
        
        feedButton = new JoystickButton(manipulatorJoystick,2);
        feedButton.whileHeld(new FeederOn());


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


    public double getLeftDriveY(){
    	return leftDriveJoystick.getRawAxis(1);
    }
    public double getRightDriveY(){
    	return rightDriveJoystick.getRawAxis(1);
    }
    public double getShooterY(){
    	return manipulatorJoystick.getRawAxis(1);
    }
    public double getClimberSpeed(){
    	return leftDriveJoystick.getRawAxis(3);
    }
}

