package org.team4909.boxtop.commands.auto;

import org.team4909.boxtop.commands.drive.semiauto.DriveDistance;
import org.team4909.boxtop.commands.drive.semiauto.InvertToState;
import org.team4909.boxtop.commands.drive.semiauto.ShiftToState;
import org.team4909.utils.devices.drivetrain.ShiftingRobotDrive.Gear;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class BreakBaseline extends CommandGroup {
    public BreakBaseline (){
    //	addParallel(new HoldGear());
    	addSequential(new InvertToState(false));
    	addSequential(new ShiftToState(Gear.Low));
    	addSequential(new DriveDistance(120),10);
//    	System.out.println("******FINISHED MOVING******");
    }
}
