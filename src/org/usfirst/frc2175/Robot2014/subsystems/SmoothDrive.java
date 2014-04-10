package org.usfirst.frc2175.Robot2014.subsystems;

import org.usfirst.frc2175.Robot2014.Robot;

public class SmoothDrive {
    private double previousForward = 0;
    private double newForward = 0;
    private static final double MAX_CHANGE = 0.1;

    // Subsystem stuff

    void execute() {
        if (previousForward * Robot.oi.getForwardSpeed() <= 0 && Math.abs(Robot.oi.getForwardSpeed() - previousForward) > MAX_CHANGE) {
            // The signs are different (or one value is 0) AND we are changing rapidly enough to merit smoothing

            int sign;
            if (Robot.oi.getForwardSpeed() < 0 || previousForward > 0) {
                sign = -1;
            } else if (Robot.oi.getForwardSpeed() > 0 || previousForward < 0) {
                sign = 1;
            } else { // just in case something crazy happened...
                sign = 0;
            }
            newForward = previousForward + (MAX_CHANGE * sign);
        } else {
            // Otherwise, don't bother to drive smooth!
            newForward = Robot.oi.getForwardSpeed();
        }

	// drive with newForward value

	// save output for next loop
	previousForward = newForward;
    }
}
