package org.usfirst.frc4909.STEAMWORKS.commands.auto;

import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.DriveDistance;
import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.InvertToState;
import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.ShiftToState;
import org.usfirst.frc4909.STEAMWORKS.commands.loader.HoldGear;
import org.usfirst.frc4909.STEAMWORKS.utils.devices.drivetrain.ShiftingRobotDrive.Gear;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BreakBaseline extends CommandGroup {
    public BreakBaseline (){
    //	addParallel(new HoldGear());
    	addSequential(new InvertToState(false));
    	addSequential(new ShiftToState(Gear.Low));
    	addSequential(new DriveDistance(120));
    	System.out.println("******FINISHED MOVING******");
    }
}
