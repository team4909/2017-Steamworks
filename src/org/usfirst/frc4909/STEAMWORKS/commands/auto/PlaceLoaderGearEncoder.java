package org.usfirst.frc4909.STEAMWORKS.commands.auto;

import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.DriveDistance;
import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.Rotate;
import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.ShiftToState;
import org.usfirst.frc4909.STEAMWORKS.commands.loader.DropGear;
import org.usfirst.frc4909.STEAMWORKS.commands.loader.HoldGear;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain.ShiftingRobotDrive.Gear;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class PlaceLoaderGearEncoder extends CommandGroup {

    public PlaceLoaderGearEncoder() {
    	addParallel(new HoldGear());
    	addSequential(new ShiftToState(Gear.Low));
    	addSequential(new DriveDistance(36));
    	addSequential(new WaitCommand(.2));
    	
    	addSequential(new Rotate(-30));
    	addSequential(new WaitCommand(.2));

      	addSequential(new DriveDistance(57.128));
    	addSequential(new WaitCommand(.2));

    	addSequential(new Rotate(60));
    	addSequential(new WaitCommand(.2));

    	addSequential(new DriveDistance(39.349));
    	addSequential(new WaitCommand(.2));

    	addParallel(new DropGear());
    	addSequential(new DriveDistance(4));
    	addSequential(new WaitCommand(.5));

    	addSequential(new DriveDistance(-10));


//    	addSequential(new HoldGear());
    	
    	//addSequential(new Rotate(90));
    }
}
//31.5+6.5=38
//36in 
//-30 degrees
//57.128 in
//60 degrees+
//39.349 (drive)
//