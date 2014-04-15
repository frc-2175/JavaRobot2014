package org.usfirst.frc2175.Robot2014;

import org.usfirst.frc2175.Robot2014.Robot;

public class Ramp {
    private double output;
    private double prevTime, newTime;
    private double MAX_CHANGE;
       
    public Ramp(double max) {
        MAX_CHANGE = max;
    }
    
    public Ramp() { this(4/3); }
    
    public void init(double input) {
        prevTime = newTime = edu.wpi.first.wpilibj.Timer.getFPGATimestamp();
        output = input;
    }
    
    public void init() { this.init(0); }

    public double rampInput(double input) {
        // compute time since last iteration.... newTime - prevTime
	newTime = edu.wpi.first.wpilibj.Timer.getFPGATimestamp();
        double dt = newTime - prevTime;
        
        // a few extra conditions in here to test -- tune MAX_CHANGE first!!!
        if (input > output + MAX_CHANGE*dt) {
            output += MAX_CHANGE*dt;
        } else if (input < output - MAX_CHANGE*dt) {
            output -= MAX_CHANGE*dt;
        } else {
            output = input;
        }

	prevTime = newTime;
        
        return output;
    }
}
