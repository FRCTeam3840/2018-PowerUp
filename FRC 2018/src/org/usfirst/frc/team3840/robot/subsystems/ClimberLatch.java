package org.usfirst.frc.team3840.robot.subsystems;

import org.usfirst.frc.team3840.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Unlatches the climber arms.
 */
public class ClimberLatch extends Subsystem {

	public final SpeedController climberLatch = RobotMap.climberLatch;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void UnlatchArm_CW() {
    	climberLatch.set(0.5);
    }
    
    public void UnlatchArm_CCW() {
    	climberLatch.set(-0.5);
    }
    
    public void StopMotor() {
    	climberLatch.stopMotor();
    }
    
}

