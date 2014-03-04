// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2175.Robot2014.subsystems;

import org.usfirst.frc2175.Robot2014.RobotMap;
import org.usfirst.frc2175.Robot2014.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Drivetrain extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController left = RobotMap.drivetrainLeft;
    SpeedController right = RobotMap.drivetrainRight;
    RobotDrive robotDrive = RobotMap.drivetrainRobotDrive;
    Encoder leftEncoder = RobotMap.drivetrainLeftEncoder;
    Encoder rightEncoder = RobotMap.drivetrainRightEncoder;
    SpeedController magicPIDOutput = RobotMap.drivetrainMagicPIDOutput;
    Gyro gyro = RobotMap.drivetrainGyro;
    DoubleSolenoid shifters = RobotMap.drivetrainShifters;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public PIDController encoderPID = RobotMap.drivetrainEncoderPID;
    public PIDController gyroPID = RobotMap.drivetrainGyroPID;

    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        setDefaultCommand(new ArcadeDriveWithJoysticks());
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        shifters.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void ArcadeDriveWithParameters(double forward, double turning) {
        ArcadeDriveWithParameters(forward, turning, false);
    }
    
    public void ArcadeDriveWithParameters(double forward, double turning, boolean fudge) {
	double fudgeAmount = 0;
        if (fudge) fudgeAmount = forward * SmartDashboard.getNumber("Drivetrain Fudge Factor");
        robotDrive.arcadeDrive(forward, turning + fudgeAmount, false);
//	fakeCompressor.set(1);
	
    }
    public void ShiftToGear(boolean isHigh) {
            if (isHigh) {
                    shifters.set(DoubleSolenoid.Value.kForward);
            } else {
                    shifters.set(DoubleSolenoid.Value.kReverse);
            }
    }
    public void ResetEncoders() {
            leftEncoder.reset();
            rightEncoder.reset();
    }
    public double GetAverageEncoderDistance() {
            return (leftEncoder.getDistance() + rightEncoder.getDistance()) / 2;
    }
    public double GetAverageEncoderRate() {
            return (leftEncoder.getRate() + rightEncoder.getRate()) / 2;
    }
    
    public void ResetGyro() {
        gyro.reset();
    }
    
    public double GetGyroAngle() {
        return gyro.getAngle();
    }

}

