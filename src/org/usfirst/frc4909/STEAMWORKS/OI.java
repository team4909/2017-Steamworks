package org.usfirst.frc4909.STEAMWORKS;

import org.usfirst.frc4909.STEAMWORKS.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class OI {
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

