/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2175.Robot2014;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 * @author aren
 */
public class CheatyVision {
    private final String NT_ID = "CheatyVisionQRHash";
    private final int kNumberJoysticks = 4;
    private final int kNumberAxes = 6;
    private final int kNumberButtons = 12;
    
    private double[][] m_axes;
    private boolean[][] m_buttons;
    
    public CheatyVision() {
        m_axes = new double[kNumberJoysticks][kNumberAxes];
        m_buttons = new boolean[kNumberJoysticks][kNumberButtons];
    }
    
    public void update() {
        String QRHash = SmartDashboard.getString(NT_ID);
        
        //code to update axes and buttons
        //m_axes[]...
        //m_buttons[]...
    }
    
    public double getStickAxis(int port, int axis) {
        return m_axes[port - 1][axis - 1];
    }
    
    public boolean getStickButton(int port, int button) {
        return m_buttons[port - 1][button - 1];
    }
}
