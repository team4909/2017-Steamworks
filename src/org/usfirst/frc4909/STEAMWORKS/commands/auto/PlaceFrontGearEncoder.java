package org.usfirst.frc4909.STEAMWORKS.commands.auto;

import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.*;
import org.usfirst.frc4909.STEAMWORKS.commands.loader.*;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain.ShiftingRobotDrive.Gear;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PlaceFrontGearEncoder extends CommandGroup {
    public PlaceFrontGearEncoder (){
    	//addSequential(new HoldGear());
    	//addSequential(new ShiftToState(Gear.High));
    	//addSequential(new DriveDistance(10));
    	//addSequential(new DropGear());
    	//addSequential(new DriveDistance(-5));
    	//addSequential(new HoldGear());
    	
    	addSequential(new Rotate(90));
    }
}
