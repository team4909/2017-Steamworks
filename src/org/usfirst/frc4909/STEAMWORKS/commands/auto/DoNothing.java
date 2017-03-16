package org.usfirst.frc4909.STEAMWORKS.commands.auto;

import org.usfirst.frc4909.STEAMWORKS.commands.drive.semiauto.Rotate;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class DoNothing extends CommandGroup {
    public DoNothing (){
//    	addParallel(new HoldGear());
//    	addSequential(new InvertToState(true));
//
//    	addSequential(new ShiftToState(Gear.High));
    	addSequential(new Rotate(70));
    }
}
