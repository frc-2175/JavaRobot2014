package org.usfirst.frc2175.Robot2014;

public class Ramp {
    private double output;
    private double time;
    private double max_delta;
       
    public Ramp(double max) {
        max_delta = max;
    }
    
    public Ramp() { this(4/3); }
    
    public void init(double input) {
        time = edu.wpi.first.wpilibj.Timer.getFPGATimestamp();
        output = input;
    }
    
    public void init() { this.init(0); }

    public double rampInput(double input) {
        // compute time since last iteration.... newTime - prevTime
        double newTime = edu.wpi.first.wpilibj.Timer.getFPGATimestamp();
        double dt = newTime - time;

        // check both bounds and coerce
        // TUNE max_delta!!!!
        if (input > output + max_delta*dt) {
            output += max_delta*dt;
        } else if (input < output - max_delta*dt) {
            output -= max_delta*dt;
        } else {
            output = input;
        }

        time = newTime;

        return output;
    }
}
