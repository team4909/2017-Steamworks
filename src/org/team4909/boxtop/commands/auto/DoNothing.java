package org.team4909.boxtop.commands.auto;

import org.team4909.boxtop.commands.drive.semiauto.Rotate;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class DoNothing extends CommandGroup {
    public DoNothing (){
//    	addParallel(new HoldGear());
//    	addSequential(new InvertToState(true));
//
//    	addSequential(new ShiftToState(Gear.High));
    	addSequential(new Rotate(70,true));
    }
}
