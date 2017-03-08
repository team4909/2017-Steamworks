package org.usfirst.frc4909.STEAMWORKS.commands.auto;

import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.DriveDistance;
import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.InvertToState;
import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.Rotate;
import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.ShiftToState;
import org.usfirst.frc4909.STEAMWORKS.commands.loader.DropGear;
import org.usfirst.frc4909.STEAMWORKS.commands.loader.HoldGear;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain.ShiftingRobotDrive.Gear;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class PlaceBoilerGearEncoder extends CommandGroup {

    public PlaceBoilerGearEncoder() {
    	addParallel(new HoldGear());
    	addSequential(new InvertToState(true));

    	addSequential(new ShiftToState(Gear.Low));
    	
    	addSequential(new DriveDistance(73.236));

    	addSequential(new Rotate(-60));

    	addSequential(new DriveDistance(63.393));

    	addParallel(new DropGear());
    	addSequential(new DriveDistance(4));
    	
    	addSequential(new WaitCommand(.5));

    	addSequential(new DriveDistance(-10));

      
    }
}
//73.236 in
//-60 degrees
//63.393 in