package org.usfirst.frc2175.Robot2014.subsystems;

import org.usfirst.frc2175.Robot2014.Robot;

public class SmoothDrive {
    private double previousOutput = 0;
    private static final double MAX_CHANGE = 0.1;

    // Subsystem stuff

    void execute() {
        if (previousOutput * Robot.oi.getForwardSpeed() <= 0 && Math.abs(Robot.oi.getForwardSpeed() - previousOutput) > MAX_CHANGE) {
            // The signs are different (or one value is 0) AND we are changing rapidly enough to merit smoothing

            int sign;
            if (Robot.oi.getForwardSpeed() < 0) {
                sign = -1;
            } else if (Robot.oi.getForwardSpeed() > 0) {
                sign = 1;
            } else {
                sign = (int)(-(previousOutput / Math.abs(previousOutput))); // If we try to go to 0, we have to use the opposite sign of what we were just outputting
            }
            double newOutput = previousOutput + (MAX_CHANGE * sign);
            // Drive here with newOutput
            previousOutput = newOutput;
        } else {
            // Otherwise, don't bother to smooth!
            
            // Drive here Robot.oi.getForwardSpeed();
            previousOutput = Robot.oi.getForwardSpeed();
        }
    }
}
