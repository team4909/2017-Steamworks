package org.usfirst.frc4909.STEAMWORKS.commands.auto;

import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.*;
import org.usfirst.frc4909.STEAMWORKS.commands.loader.*;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain.ShiftingRobotDrive.Gear;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PlaceFrontGearEncoder extends CommandGroup {
    public PlaceFrontGearEncoder (){
    	addParallel(new HoldGear());
    	addSequential(new ShiftToState(Gear.Low));
    	addSequential(new DriveDistance(114));
    	addSequential(new DropGear());
    	addSequential(new DriveDistance(-60));
    	addSequential(new HoldGear());
    	
    	addSequential(new Rotate(90));
    }
}