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

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2175.Robot2014.Robot;

/**
 *
 */
public class  WinchLauncherDown extends Command {

    boolean overrideSensors;
    
    public WinchLauncherDown() {
        this(false);
    }
    
    public WinchLauncherDown(boolean override) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.launcher);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        
        overrideSensors = override;
	setTimeout(3);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Winching launcher down...\n");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (Robot.arm.IsArmOut() || overrideSensors) {
		Robot.launcher.RunWinchAtSpeed(.7);
	} else {
		Robot.launcher.RunWinchAtSpeed(0);
	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if (overrideSensors) {
		return false;
	} else {
		return Robot.launcher.IsShooterArmDown() || isTimedOut();
	}
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.launcher.RunWinchAtSpeed(0);
	System.out.println("Done winching launcher down.\n\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
