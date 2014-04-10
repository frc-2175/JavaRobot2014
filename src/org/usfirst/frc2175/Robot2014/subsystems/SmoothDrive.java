package org.usfirst.frc2175.Robot2014.subsystems;

import org.usfirst.frc2175.Robot2014.Robot;

public class SmoothDrive {
    private double previousForward = 0;
    private double newForward = 0;
    private static final double MAX_CHANGE = 0.1;
    private double prevTime = 0; // initialize this...

    // Subsystem stuff

    void execute() {
        // compute time since last iteration.... newTime - prevTime
	// adjust MAX_CHANGE accordingly to limit accel rather than dv

        if (//previousForward * Robot.oi.getForwardSpeed() <= 0 && 
                Math.abs(Robot.oi.getForwardSpeed() - previousForward) > MAX_CHANGE)// && 
                //Robot.drivetrain.GetShiftState()) {
            // The signs are different (or one value is 0) AND we are changing rapidly enough to merit smoothing AND we are in high gear
            // We'll probably need to do this even if the product is positive (same signs)
            // consider accelerating from zero: the first step sees prev=0, new=1;
            // the next one sees prev=.1, new=1, so it immediately jumps to 1, giving up on any accel control...

            int sign;
            if (Robot.oi.getForwardSpeed() > previousForward)
		sign = 1;
            else
		sign = -1;
            newForward = previousForward + (MAX_CHANGE * sign);
        } else {
            // Otherwise, don't bother to drive smooth!
            newForward = Robot.oi.getForwardSpeed();
        }

	// drive with newForward value and joystick turning value

	// save output for next loop
	previousForward = newForward;
    }
}
