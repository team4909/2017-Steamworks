package org.usfirst.frc4909.STEAMWORKS.commands.auto;

import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.DriveDistance;
import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.Rotate;
import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.ShiftToState;
import org.usfirst.frc4909.STEAMWORKS.commands.loader.DropGear;
import org.usfirst.frc4909.STEAMWORKS.commands.loader.HoldGear;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain.ShiftingRobotDrive.Gear;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PlaceRightGearEncoder extends CommandGroup {

    public PlaceRightGearEncoder() {
    	addParallel(new HoldGear());
    	addSequential(new ShiftToState(Gear.Low));
     	addSequential(new Rotate(60));
    	addSequential(new DriveDistance(120));
    	addSequential(new DropGear());
    	addSequential(new DriveDistance(-60));
    	addSequential(new HoldGear());
    	
    	addSequential(new Rotate(90));
    }
}
