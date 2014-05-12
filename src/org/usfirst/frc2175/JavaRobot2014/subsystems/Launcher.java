// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc2175.JavaRobot2014.subsystems;
import org.usfirst.frc2175.JavaRobot2014.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 * This class operates the ball launcher.
 */
public class Launcher extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DigitalInput latchSwitch = RobotMap.launcherLatchSwitch;
    DigitalInput winchUpSwitch = RobotMap.launcherWinchUpSwitch;
    SpeedController winchMotor = RobotMap.launcherWinchMotor;
    AnalogChannel ballSensor = RobotMap.launcherBallSensor;
    Solenoid latch = RobotMap.launcherLatch;
    DoubleSolenoid tension = RobotMap.launcherTension;
    Solenoid catcher = RobotMap.launcherCatcher;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        latch.set(false); // Just to be safe
    }
    
    /**
     * Returns whether the launcher is fully winched down and latched.
     * @return Whether the launcher is rully winched down and latched.
     */
    public boolean IsShooterArmDown() {
	return !latchSwitch.get();
    }
    
    /**
     * Returns whether the winch is unwound and ready for a shot.
     * @return whether the winch is unwound and ready for a shot.
     */
    public boolean IsWinchUp() {
        return !winchUpSwitch.get();
    }
    
    /**
     * Returns whether there is a ball loaded in the robot.
     * @return Whether there is a ball loaded in the robot.
     */
    public boolean IsBall() {
        if (ballSensor.getAverageValue() > 100) { /* Whatever threshold indicates a ball */
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Gets the average voltage of the ball sensor.
     * @return the average voltage of the ball sensor.
     */
    public double GetBallSensorVoltage() {
        return ballSensor.getAverageVoltage();
    }
    
    /**
     * Runs the winch at a given speed.
     * @param speed How fast to run the winch, from -1 to 1.
     */
    public void RunWinchAtSpeed(double speed) {
            winchMotor.set(speed);
    }
    
    /**
     * Sets the launcher latch to a given position. WARNING: If the arm is
     * loaded, this will cause it to release, and possibly damage things!
     * @param release Whether the latch should be set to release or not.
     */
    public void SetLatch(boolean release) {
            latch.set(release);
    }
    
    /**
     * Sets the tension cylinder to a given state, to prepare for long shots.
     * @param tensioned Whether the launcher should be tensioned or not.
     */
    public void SetTension(boolean tensioned) {
        if (tensioned) {
            tension.set(DoubleSolenoid.Value.kForward);
        } else {
            tension.set(DoubleSolenoid.Value.kReverse);
        }
    }
}
