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
 * This command runs the roller bar to suck in a ball. It can run infinitely or
 * time out (for use in auto sequences.)
 */
public class  RunRollerBar extends Command {
    
    /**
     * Constructs the command to run infinitely. It must be manually interrupted
     * to make it stop.
     */
    public RunRollerBar() {
        this(0);
    }
    
    /**
     * Constructs the command with a timeout value.
     * @param timeout The number of seconds to run the roller bar. If set to 0,
     * it will run infinitely.
     */
    public RunRollerBar(double timeout) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        
        if (timeout != 0) {
		setTimeout(timeout);
	} else {
		setTimeout(5);
	}
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Running the roller bar...\n");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.arm.runRollerBarAtSpeed(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.arm.runRollerBarAtSpeed(0);
	System.out.println("Done running the roller bar.\n\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
