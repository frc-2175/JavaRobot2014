/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2175.Robot2014;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables2.type.*;
/**
 *
 * @author aren
 */
public class CheatyVision {
    private final String hashID = "CheatyVisionQRHash";
    private final String buttonsID = "CheatyVisionButtons";
    private final String axesID = "CheatyVisionAxes";
    private final int kNumberJoysticks = 4;
    private final int kNumberAxes = 6;
    private final int kNumberButtons = 12;
    
    private NumberArray m_axes;
    private BooleanArray m_buttons;
    //private double[][] m_axes;
    //private boolean[][] m_buttons;    
    
    private final NetworkTable m_nt;
    
    public CheatyVision() {
        //m_axes = new double[kNumberJoysticks][kNumberAxes];
        //m_buttons = new boolean[kNumberJoysticks][kNumberButtons];
        
        m_nt = NetworkTable.getTable("SmartDashboard");
    }
    
    public void update() {
        //String QRHash = SmartDashboard.getString(hashID);
        //code to update axes and buttons:
        //m_axes[]...
        //m_buttons[]...
        
        m_buttons = (BooleanArray)m_nt.getValue(buttonsID);
        m_axes = (NumberArray)m_nt.getValue(axesID);
    }
    
    public double getStickAxis(int port, int axis) {
        //return m_axes[port - 1][axis - 1];
        return m_axes.get(kNumberAxes*(port-1)+axis);
    }
    
    public boolean getStickButton(int port, int button) {
        //return m_buttons[port - 1][button - 1];
        return m_buttons.get(kNumberButtons*(port-1)+button);
    }
}
