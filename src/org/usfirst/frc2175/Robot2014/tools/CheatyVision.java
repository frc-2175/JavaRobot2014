package org.usfirst.frc2175.Robot2014.tools;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
    private boolean enabled = false;
    
    private final String hashID = "CheatyVsionQRHash";
    private final int kNumberJoysticks = 4;
    private final int kNumberAxes = 6;
    private final int kNumberButtons = 12;
    
    private final float[][] m_axes = new float[kNumberJoysticks][kNumberAxes];;
    private final boolean[][] m_buttons = new boolean[kNumberJoysticks][kNumberButtons];
    
    public CheatyVision(boolean enableCV) {
        this.enabled = enableCV;
    }
    
    public void update() {
        if (enabled) {
            String QRHash = SmartDashboard.getString(hashID);
            //code to update axes and buttons:
            Encode.DecodedInfo data = Encode.decode(QRHash);
            boolean[] allButtons = data.bools;
            float[] allAxes = data.floats;
            // for the moment don't bother with sticks 1 and 2, just map to gamepad to test
            m_axes[2] = allAxes;
            m_buttons[2] = allButtons;
        }
    }
    
    public double getStickAxis(int port, int axis) {
        return m_axes[port - 1][axis - 1];
    }
    
    public boolean getStickButton(int port, int button) {
        return m_buttons[port - 1][button - 1];
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
    
    public boolean getEnabled() {
        return this.enabled;
    }
}
