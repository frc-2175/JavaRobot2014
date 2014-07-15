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
 * This auton routine drives forward, takes a short shot, drives back, picks up
 * another ball, and takes another short shot.
 */
public class Auton3DoubleBlindShot extends CommandGroup {
    
    public  Auton3DoubleBlindShot() {
        
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
        
        addSequential(new ArcadeDriveWithInputs(-1,0,1.15,false,0.0));
        
        addSequential(new ArcadeDriveWithInputs(-0.5,0,0.25,false,0.0));
        addSequential(new Delay(0.2));  // very brief stop for bot settling

        addSequential(new MoveArmOut());
        
        addSequential(new Delay(0.3));
        
        addSequential(new WinchLauncherDown()); // This is basically the shoot sequence, without the end winching
	addSequential(new UnwindWinch());
	addSequential(new ReleaseLatch());
        
        
        addParallel(new ArcadeDriveWithInputs(1,0,1.75,false,0.0));
        addParallel(new WinchLauncherDown());
        addSequential(new RunRollerBar(1.3));
        //addParallel(new RunRollerBar(2));
        //addSequential(new ArcadeDriveWithInputs(1,0,1.5,false,false));
        
        addParallel(new RunRollerBar(1.0));
        addSequential(new ArcadeDriveWithInputs(0.5,0,0.65,false,0.0));
        
        addParallel(new UnwindWinch());
        addParallel(new MoveArmIn());
        addSequential(new ArcadeDriveWithInputs(-1,0,1.8,false,0.0));
        
        addParallel(new UnwindWinch(0.25,true));
        addSequential(new ArcadeDriveWithInputs(-0.5,0,0.25,false,0.0));
        addSequential(new Delay(0.2));  // very brief stop for bot settling
        
        addSequential(new MoveArmOut());
        
        addSequential(new Delay(0.3));
        
        addSequential(new Shoot());
    }
}
