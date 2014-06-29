package org.usfirst.frc2175.Robot2014.tools;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Ramp {
    private double output;
    private double prevTime;
    private double max_delta;
       
    public Ramp(double max_delta) {
        this.max_delta = max_delta;
    }
        
    public void init(double input) {
        prevTime = edu.wpi.first.wpilibj.Timer.getFPGATimestamp();
        output = input;
    }
    
    public void init() { this.init(0); }

    public double rampInput(double input) {
        // compute prevTime since last iteration.... newTime - prevTime
        double newTime = edu.wpi.first.wpilibj.Timer.getFPGATimestamp();
        double dt = newTime - prevTime;

        // check both bounds and coerce
        // TUNE max_delta!!!!
        if (input > output + max_delta*dt) {
            output += max_delta*dt;
        } else if (input < output - max_delta*dt) {
            output -= max_delta*dt;
        } else {
            output = input;
        }
        SmartDashboard.putNumber("Delta-t", dt);
        SmartDashboard.putNumber("Output", output);
        
        prevTime = newTime;

        return output;
    }
    
    public void setMaxDelta(double max_delta) {
        this.max_delta = max_delta;
    }
    
    public double getMaxDelta() {
        return max_delta;
    }
}
