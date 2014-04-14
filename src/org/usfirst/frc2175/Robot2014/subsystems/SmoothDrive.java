package org.usfirst.frc2175.Robot2014.subsystems;

import org.usfirst.frc2175.Robot2014.Robot;

public class SmoothDrive {
    private double prevForward, newForward;
    private double prevTime, newTime;
    private static final double MAX_CHANGE = 4/3; // see math...
    
    // Subsystem stuff
    
    void initialize() {
          prevTime = newTime = edu.wpi.first.wpilibj.Timer.getFPGATimestamp();
          prevForward = newForward = 0;
    }

    void execute() {
        // compute time since last iteration.... newTime - prevTime
	newTime = edu.wpi.first.wpilibj.Timer.getFPGATimestamp();
        double dt = newTime - prevTime;
        
        // a few extra conditions in here to test -- tune MAX_CHANGE first!!!
        if (
                //previousForward * Robot.oi.getForwardSpeed() <= 0 && 
                Math.abs(Robot.oi.getForwardSpeed() - prevForward)*dt > MAX_CHANGE// && 
                //Robot.drivetrain.GetShiftState()
        ) {
            int sign = (Robot.oi.getForwardSpeed() > prevForward) ? 1 : -1;
            newForward = prevForward + sign * MAX_CHANGE;
        } else {
            // Otherwise, don't bother to drive smooth!
            newForward = Robot.oi.getForwardSpeed();
        }

	// drive with newForward value and joystick turning value
        
        
	// save output for next loop
	prevForward = newForward;
        prevTime = newTime;
    }
}
