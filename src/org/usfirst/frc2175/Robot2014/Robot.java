// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2175.Robot2014;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.*;
import org.usfirst.frc2175.Robot2014.commands.*;
import org.usfirst.frc2175.Robot2014.subsystems.*;
import edu.wpi.first.wpilibj.DigitalOutput;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;
    SendableChooser autoChooser;
    
    public static DigitalOutput enabledLights;
    public static DigitalOutput shootLights;

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Drivetrain drivetrain;
    public static Arm arm;
    public static Launcher launcher;
    public static CompresserSubsystem compresserSubsystem;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        System.out.println("Initializing robot");
	RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrain = new Drivetrain();
        arm = new Arm();
        launcher = new Launcher();
        compresserSubsystem = new CompresserSubsystem();
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        
        SmartDashboard.putNumber("Auton Fast Drive Time", 1.25);
        SmartDashboard.putNumber("Auton Slow Drive Time", 0.5);
        SmartDashboard.putNumber("Blind Shot Roller Delay", 1);
        SmartDashboard.putNumber("Ramping Max_Delta",5);
	
        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        autonomousCommand = new Auton0DoNothing();
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        
        autoChooser = new SendableChooser();
	autoChooser.addDefault("0 - No Action", new Auton0DoNothing());
	autoChooser.addObject("1 - Mobility Bonus", new Auton1MobilityBonus());
	autoChooser.addObject("2 - Blind Shot", new Auton2BlindShot());
	autoChooser.addObject("3 - Double Blind Shot", new Auton3DoubleBlindShot());
	autoChooser.addObject("4 - Long Goal/Short Goal", new Auton4LongShort());
	autoChooser.addObject("5 - Hot Goal", new Auton5HotGoal());
        autoChooser.addObject("6 - Double Hot Goal", new Auton6DoubleHotGoalSANE());
	autoChooser.addObject("-1 - Test", new AutonMinus1Test());
	SmartDashboard.putData("Autonomous Routine",autoChooser);
        
        enabledLights = new DigitalOutput(1,13);
        shootLights = new DigitalOutput(1,14);
        
        SmartDashboard.putNumber("Drivetrain Fudge Factor",0);
        SmartDashboard.putNumber("Arm Out Roller Speed",0.3);
        SmartDashboard.putNumber("Straight Driving Tuning",5);
        SmartDashboard.putNumber("Straight Driving Range",0.5);
    }

    public void autonomousInit() {
        System.out.println("Initializing autonomous");
        enabledLights.set(true);
	autonomousCommand = (Command)autoChooser.getSelected();
//        autonomousCommand = new Auton3DoubleBlindShot();
	autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("Gyro Heading",Robot.drivetrain.GetGyroAngle());
	if (oi.getGamepad().getRawButton(6))
		System.out.println("-----------------------------------\n");
    }

    public void teleopInit() {
        System.out.println("Initializing teleop\n");
        enabledLights.set(true);
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
	if (oi.getGamepad().getRawButton(6))
		System.out.println("-----------------------------------\n");
        
        SmartDashboard.putBoolean("Shooter Down", Robot.launcher.IsShooterArmDown());
	SmartDashboard.putBoolean("Shooter Up", Robot.launcher.IsWinchUp());
	SmartDashboard.putBoolean("Arm Out Switch 1", Robot.arm.IsArmSwitch1());
	SmartDashboard.putBoolean("Arm Out Switch 2", Robot.arm.IsArmSwitch2());
        SmartDashboard.putNumber("Gyro Heading",Robot.drivetrain.GetGyroAngle());
    }

    /**
     * This function called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
