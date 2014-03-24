// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2175.Robot2014.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Auton3DoubleBlindShot extends CommandGroup {
    
    public  Auton3DoubleBlindShot() {
        // add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        
        /*
        
//        addParallel(new TensionLauncher());
        addSequential(new MoveArmOut());
        
        addSequential(new Delay(1.75));
        
//        addParallel(new TensionLauncher());
        addSequential(new Shoot(false));
	
//        addParallel(new TensionLauncher());
	addParallel(new RunRollerBar(),1);
	addSequential(new UnwindWinch());
        
        addParallel(new RunRollerBar(),0.75);
        addSequential(new ArcadeDriveWithInputs(0.5,0,0.75));
        
        addSequential(new ArcadeDriveWithInputs(-0.5,0,0.75));
        
        addSequential(new Delay(1.75));
                
//        addParallel(new TensionLauncher());
//	addParallel(new RunRollerBar());
//	addSequential(new Delay(1)); // To make sure the ball gets in
//        addSequential(new Delay(SmartDashboard.getNumber("Blind Shot Roller Delay")));
//	addSequential(new WaitForBall());
	
//        addParallel(new TensionLauncher());
	addSequential(new ReleaseLatch());
	
        addParallel(new TensionLauncher()); // We should already be tensioned. This is here to untension us at the end of auton.
	addParallel(new ArcadeDriveWithInputs(-0.75,0,2,true));
	addSequential(new WinchLauncherDown());
	
	addSequential(new UnwindWinch());
                
                */
        
        addSequential(new ArcadeDriveWithInputs(-1,-0.1,1.25,true));
        
        addSequential(new ArcadeDriveWithInputs(-0.5,-0.1,0.5,true));
        
        addSequential(new MoveArmOut());
        
        addSequential(new Delay(0.75));
        
        addSequential(new Shoot(false));
        
        addParallel(new UnwindWinch());
        addParallel(new RunRollerBar(2));
        addSequential(new ArcadeDriveWithInputs(1,0,2,true));
        
        addParallel(new RunRollerBar(0.5));
        addSequential(new ArcadeDriveWithInputs(0.5,0,0.5,true));
        
        addParallel(new MoveArmIn());
        addSequential(new ArcadeDriveWithInputs(-1,-0.15,2.5,true));
        
        addSequential(new ArcadeDriveWithInputs(-0.5,-0.1,0.5,true));
        
        addSequential(new MoveArmOut());
        
        addSequential(new Delay(0.75));
        
        addSequential(new Shoot());
    }
}
