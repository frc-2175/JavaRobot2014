package org.usfirst.frc2175.Robot2014.tools;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
//import edu.wpi.first.wpilibj.networktables.NetworkTable;
//import edu.wpi.first.wpilibj.networktables2.type.*;
/**
 *
 * CheatyVision.java
 * 
 * This class handles all parsing of CheatyVision data and supplies it to the
 * CheatyJoysticks declared in the CheatyOI.
 * 
 * This object, instantiated under the RobotBase, should be updated periodically
 * by calling "update()" from "TeleopPeriodic" or "AutonomousPeriodic()" in order
 * to refresh values to match latest data from DS.
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
    
    private final float[][] m_axes = new float[kNumberJoysticks][kNumberAxes];;
    private final boolean[][] m_buttons = new boolean[kNumberJoysticks][kNumberButtons];
    
    //private NumberArray m_axes;
    //private BooleanArray m_buttons;
    //private final NetworkTable m_nt;
    
    public CheatyVision() {
        //m_nt = NetworkTable.getTable("SmartDashboard");
    }
    
    public void update() {
        String QRHash = SmartDashboard.getString(hashID);
        //code to update axes and buttons:
        Encode.DecodedInfo data = Encode.decode(QRHash);
        boolean[] allButtons = data.bools;
        float[] allAxes = data.floats;
        // for the moment don't bother with sticks 1 and 2, just map to gamepad to test
        m_axes[2] = allAxes;
        m_buttons[2] = allButtons;
        
        //m_buttons = (BooleanArray)m_nt.getValue(buttonsID);
        //m_axes = (NumberArray)m_nt.getValue(axesID);
    }
    
    public double getStickAxis(int port, int axis) {
        return m_axes[port - 1][axis - 1];
        //return m_axes.get(kNumberAxes*(port-1)+axis);
    }
    
    public boolean getStickButton(int port, int button) {
        return m_buttons[port - 1][button - 1];
        //return m_buttons.get(kNumberButtons*(port-1)+button);
    }
}
