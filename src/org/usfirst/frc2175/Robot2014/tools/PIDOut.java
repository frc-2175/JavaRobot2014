package org.usfirst.frc2175.Robot2014.tools;

import edu.wpi.first.wpilibj.PIDOutput;

/**
 * 
 * PIDOut.java
 * 
 * Dummy class.  This is pretty much just a hack, implementing the PIDOutput
 * interface to do nothing with the value its given by a PIDController.  This
 * is because we fetch the value from the controller ourselves and use it in
 * our own ways...
 * 
 * @author aren
 */
public class PIDOut implements PIDOutput{
    double value = 0.0;
    
    public void pidWrite(double val) {
        this.value = val;
    }
}
