package org.team4909.boxtop.commands.auto;

import org.team4909.boxtop.commands.drive.semiauto.DriveDistance;
import org.team4909.boxtop.commands.drive.semiauto.InvertToState;
import org.team4909.boxtop.commands.drive.semiauto.Rotate;
import org.team4909.boxtop.commands.drive.semiauto.ShiftToState;
import org.team4909.boxtop.commands.loader.DropGear;
import org.team4909.boxtop.commands.loader.HoldGear;
import org.team4909.utils.devices.drivetrain.ShiftingRobotDrive.Gear;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 *
 */
public class BoilerAuto extends CommandGroup {

    public BoilerAuto() {
    	addParallel(new HoldGear());
    	addSequential(new InvertToState(false));

    	addSequential(new ShiftToState(Gear.Low));
    	
    	addSequential(new DriveDistance(24),5);

    	addSequential(new Rotate(-60,true),10);

    	addSequential(new DriveDistance(63.393),10);

    	addParallel(new DropGear());
    	addSequential(new DriveDistance(4),10);
    	
    	addSequential(new WaitCommand(.5));

    	addSequential(new DriveDistance(-10),10);

      
    }
}
