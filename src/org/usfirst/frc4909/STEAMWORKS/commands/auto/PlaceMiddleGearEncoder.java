package org.usfirst.frc4909.STEAMWORKS.commands.auto;

import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.*;
import org.usfirst.frc4909.STEAMWORKS.commands.loader.*;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain.ShiftingRobotDrive.Gear;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class PlaceMiddleGearEncoder extends CommandGroup {
    public PlaceMiddleGearEncoder (){
//    	addParallel(new HoldGear());
    	addSequential(new InvertToState(false));

    	addSequential(new ShiftToState(Gear.Low));
    	
    	addSequential(new DriveDistance(78.5));

//    	addParallel(new DropGear());
    	addSequential(new DriveDistance(6));
    	
    	addSequential(new WaitCommand(.5));

    	addSequential(new DriveDistance(-10));
//    	addSequential(new HoldGear());
    }
}
//