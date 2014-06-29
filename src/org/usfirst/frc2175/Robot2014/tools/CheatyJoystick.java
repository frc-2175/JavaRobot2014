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
    
    public CheatyJoystick(CheatyVision cv, int port) {
        super(port);
        m_cv = cv;
        m_port = port;
    }
    
    /* these next two are to pull individual buttons and axes out of the
        data decoded and stored in this object */
    
    /* return a single axis value */
    /* implemented as part of GenericHID class */
    public double getRawAxis(final int axis) {
        return m_cv.getStickAxis(m_port, axis);
    }
    
    /* return a single button's value */
    /* implemented as part of GenericHID class */
    public boolean getRawButton(final int button) {
        return m_cv.getStickButton(m_port, button);
    }
    
    /* these constants are here to override the ones in Joystick, so we can see
       what we are assigning to what.  Once that's done, all the getX and other
       garbage methods will work by looking at our overridden getRaw* mathods.
    */
    
    static final byte kDefaultXAxis = 1;
    static final byte kDefaultYAxis = 2;
    static final byte kDefaultZAxis = 3;
    static final byte kDefaultTwistAxis = 3;
    static final byte kDefaultThrottleAxis = 4;
    static final int kDefaultTriggerButton = 1;
    static final int kDefaultTopButton = 2;
    
    // however, we should really just use getRaw* anyway...
}
