package org.usfirst.frc2175.Robot2014.tools;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.parsing.IInputOutput;

/**
 *
 * CheatyJoystick.java
 * 
 * This class pretends to be a normal joystick, implementing the same interfaces
 * so that it can also be used by Buttons.  However, it pulls it's joystick data
 * from a given CheatyVision object, instead of the joysticks plugged into the DS.
 * 
 * @author aren
 */
public class CheatyJoystick extends Joystick implements IInputOutput{
    private final int m_port;
    private final CheatyVision m_cv;
    
    private boolean isCheatyVision = true;
    
    public CheatyJoystick(CheatyVision cv, int port, boolean enableCV) {
        super(port);
        m_cv = cv;
        m_port = port;
        isCheatyVision = enableCV;
    }
    
    public void setEnableCV(boolean enableCV) {
        isCheatyVision = enableCV;
    }
    
    public boolean getEnableCV() {
        return isCheatyVision;
    }
    
    /* these next two are to pull individual buttons and axes out of the
        data decoded and stored in this object */
    
    /* return a single axis value */
    /* implemented as part of GenericHID class */
    public double getRawAxis(final int axis) {
        if (isCheatyVision) return m_cv.getStickAxis(m_port, axis);
        else return super.getRawAxis(axis);
    }
    
    /* return a single button's value */
    /* implemented as part of GenericHID class */
    public boolean getRawButton(final int button) {
        if (isCheatyVision) return m_cv.getStickButton(m_port, button);
        else return super.getRawButton(button);
    }
}
