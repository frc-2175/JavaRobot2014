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
import org.usfirst.frc2175.Robot2014.Ramp;
import edu.wpi.first.wpilibj.smartdashboard.*;

/**
 * This command drives the robot using values from the driver station joysticks.
 * This is intended for Teleop use.
 */
public class  ArcadeDriveWithJoysticks extends Command {

    private Ramp forwardRamp;
    
    public ArcadeDriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.drivetrain);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        
        forwardRamp = new Ramp();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Driving with joysticks...");
        forwardRamp.init();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.drivetrain.ArcadeDriveWithParameters(
                forwardRamp.rampInput(Robot.oi.getForwardSpeed()),
                Robot.oi.getTurningSpeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        Robot.drivetrain.ArcadeDriveWithParameters(0,0);
	System.out.println("Done driving with joysticks.\n\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
