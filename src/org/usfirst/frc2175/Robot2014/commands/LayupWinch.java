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
 * This command simply waits for a provided amount of time. For use in
 * command groups.
 */
public class  LayupWinch extends Command {

    public LayupWinch(double time) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        
        setTimeout(time);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Layup winching...\n\n");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.launcher.RunWinchAtSpeed(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        Robot.launcher.RunWinchAtSpeed(0);
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.println("Done winching.\n\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
