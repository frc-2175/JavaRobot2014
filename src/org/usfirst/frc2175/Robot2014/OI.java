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

import org.usfirst.frc2175.Robot2014.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    
    public Joystick joystickLeft;
    public JoystickButton tensionButton;
    
    public Joystick joystickRight;
    public JoystickButton commandShiftButton;
    
    public Joystick gamepad;
    public JoystickButton armIn;
    public JoystickButton armOut;
    public JoystickButton intakeWheelsForward;
    public JoystickButton intakeWheelsBackwards;
    public JoystickButton shootAndReload;
    public JoystickButton releaseLatchOverride;    
    public JoystickButton manualWinchDown;
    public JoystickButton manualWinchUp;
    public JoystickButton TakeLayupShot;
    
    public OI() {
        gamepad = new Joystick(3);
        releaseLatchOverride = new JoystickButton(gamepad, 11);
        releaseLatchOverride.whenPressed(new ReleaseLatch());
        shootAndReload = new JoystickButton(gamepad, 8);
        shootAndReload.whenPressed(new Shoot());
        intakeWheelsBackwards = new JoystickButton(gamepad, 5);
        intakeWheelsBackwards.whileHeld(new RunRollerBarBackwards());
        intakeWheelsForward = new JoystickButton(gamepad, 7);
        intakeWheelsForward.whileHeld(new RunRollerBar());
        armOut = new JoystickButton(gamepad, 1);
        armOut.whenPressed(new MoveArmOut());
        armIn = new JoystickButton(gamepad, 4);
        armIn.whenPressed(new MoveArmIn());
        manualWinchDown = new JoystickButton(gamepad, 9);
        manualWinchDown.whileHeld(new WinchLauncherDown());
        manualWinchDown = new JoystickButton(gamepad, 10);
        manualWinchDown.whileHeld(new UnwindWinch());
        TakeLayupShot = new JoystickButton(gamepad, 2);
        TakeLayupShot.whenPressed(new LayupShot());
        
        joystickRight = new Joystick(2);
        commandShiftButton = new JoystickButton(joystickRight, 1);
        commandShiftButton.whileHeld(new ShiftToHighGear());
        
        joystickLeft = new Joystick(1);
        tensionButton = new JoystickButton(joystickLeft, 1);
        tensionButton.whileHeld(new TensionLauncher());
        
        // SmartDashboard Buttons
        SmartDashboard.putData("ShiftToHighGear", new ShiftToHighGear());

        SmartDashboard.putData("MoveArmOut", new MoveArmOut());

        SmartDashboard.putData("WinchLauncherDown", new WinchLauncherDown());

        SmartDashboard.putData("UnwindWinch", new UnwindWinch());

        SmartDashboard.putData("ReleaseLatch", new ReleaseLatch());

        SmartDashboard.putData("Shoot", new Shoot());
        
        SmartDashboard.putData("Layup Shot", new LayupShot());
        
        SmartDashboard.putData("Layup Winch", new LayupWinch(.2));

        SmartDashboard.putData("Tension Launcher", new TensionLauncher());
        
    }
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystickLeft() {
        return joystickLeft;
    }

    public Joystick getJoystickRight() {
        return joystickRight;
    }

    public Joystick getGamepad() {
        return gamepad;
    }

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    
    public double deadband(double input) {
	if (-0.1 < input && input < 0.1) {
		input = 0;
	}
	return input;
    }
    public boolean shouldOverrideLatch() {
        return gamepad.getRawButton(11) && gamepad.getRawButton(12);
    }
    public boolean shouldOverrideWinch() {
        return gamepad.getRawButton(6);
    }
    public double getForwardSpeed() {
            return -deadband(joystickLeft.getY());
    //	return joystickLeft.getY();
    }
    public double getTurningSpeed() {
            return deadband(joystickRight.getX());
    //	return joystickRight.getX();
    }
}
