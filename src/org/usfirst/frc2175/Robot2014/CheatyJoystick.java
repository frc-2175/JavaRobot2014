/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.usfirst.frc2175.Robot2014;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.parsing.IInputOutput;

/**
 *
 * @author aren
 */
public class CheatyJoystick extends GenericHID implements IInputOutput{
    private final int m_port;
    private final CheatyVision m_cv;
    
    public CheatyJoystick(CheatyVision cv_base, int port) {
        m_cv = cv_base;
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
    
    /* the rest of this is just here to fill out the GenericHID interface */
    
    static final byte kDefaultXAxis = 1;
    static final byte kDefaultYAxis = 2;
    static final byte kDefaultZAxis = 3;
    static final byte kDefaultTwistAxis = 3;
    static final byte kDefaultThrottleAxis = 4;
    static final int kDefaultTriggerButton = 1;
    static final int kDefaultTopButton = 2;
    
    /* return the X value (one of the auxiliary axes) */
    /* implemented as part of GenericHID class */
    /* see constant definition above */
    public double getX(Hand hand) {
        return getRawAxis(kDefaultXAxis);
    }
    
    /* return the Y value (one of the auxiliary axes) */
    /* implemented as part of GenericHID class */
    /* see constant definition above */
    public double getY(Hand hand) {
        return getRawAxis(kDefaultYAxis);
    }
    
    /* return the Z value (one of the auxiliary axes) */
    /* implemented as part of GenericHID class */
    /* see constant definition above */
    public double getZ(Hand hand) {
        return getRawAxis(kDefaultZAxis);
    }
    
    /* return the twist value (one of the auxiliary axes) */
    /* implemented as part of GenericHID class */
    /* see constant definition above */
    public double getTwist() {
        return getRawAxis(kDefaultTwistAxis);
    }
    
    /* return the throttle value (one of the auxiliary axes) */
    /* implemented as part of GenericHID class */
    /* see constant definition above */
    public double getThrottle() {
        return getRawAxis(kDefaultThrottleAxis);
    }
    
    /* return the trigger value (one of the auxiliary axes) */
    /* implemented as part of GenericHID class */
    /* see constant definition above */
    public boolean getTrigger(Hand hand) {
        return getRawButton(kDefaultTriggerButton);
    }
    
    /* return the top button value (one of the auxiliary axes) */
    /* implemented as part of GenericHID class */
    /* see constant definition above */
    public boolean getTop(Hand hand) {
        return getRawButton(kDefaultTopButton);
    }
    
    /* dummy method implemented to support GenericHID class */
    public boolean getBumper(Hand hand) {
        return false;
    }
}
