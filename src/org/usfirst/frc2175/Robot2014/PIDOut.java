/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2175.Robot2014;

import edu.wpi.first.wpilibj.PIDOutput;

/**
 *
 * @author aren
 */
public class PIDOut implements PIDOutput{
    double value = 0.0;
    
    public void pidWrite(double val) {
        this.value = val;
    }
}
