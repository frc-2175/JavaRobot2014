// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2175.JavaRobot2014.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * This command is part of the DoubleHotGoalSANE routine. It runs when we
 * determine that we have started pointing at the cold goal.
 */
public class Auton6PartialStartCold extends CommandGroup {
    
    public  Auton6PartialStartCold() {
        
        addSequential(new DriveToAngle(40));
	
	addSequential(new Shoot(false));
	
	addParallel(new UnwindWinch());
	addSequential(new DriveToAngle(-40));
	
	addSequential(new RunRollerBar());
	
	addSequential(new Shoot(false));
	
	addParallel(new UnwindWinch());
	addSequential(new ArcadeDriveWithInputs(-0.75,0,3));
    }
}
