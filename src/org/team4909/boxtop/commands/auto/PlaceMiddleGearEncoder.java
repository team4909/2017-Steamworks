package org.team4909.boxtop.commands.auto;

import org.team4909.boxtop.commands.drive.semiauto.*;
import org.team4909.boxtop.commands.loader.*;
import org.team4909.utils.devices.drivetrain.ShiftingRobotDrive.Gear;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class PlaceMiddleGearEncoder extends CommandGroup {
    public PlaceMiddleGearEncoder (){
    	addParallel(new HoldGear());
    	addSequential(new InvertToState(false));

    	addSequential(new ShiftToState(Gear.Low));
    	
    	addSequential(new DriveDistance(82.5),7);
    	addParallel(new PegGear());
//    	addSequential(new Rotate(-5),3);
//    	addSequential(new DriveDistance(3),3);
//    	addSequential(new Rotate(5),3);
    	addSequential(new WaitCommand(0.5));

    	addSequential(new DropGear());

//    	addSequential(new DriveDistance(3),3);
//    	addSequential(new Rotate(0));

    	addSequential(new WaitCommand(.5));

    	addSequential(new DriveDistance(-10));
//    	addSequential(new HoldGear());
    }
}
//