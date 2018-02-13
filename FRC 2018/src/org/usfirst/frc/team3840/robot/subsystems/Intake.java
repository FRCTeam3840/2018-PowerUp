package org.usfirst.frc.team3840.robot.subsystems;

import org.usfirst.frc.team3840.robot.RobotMap;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Intake extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public final SpeedController intakeLeft = RobotMap.intakeLeft;
	public final SpeedController intakeRight = RobotMap.intakeRight;
	
	//  SmartDashBoard , SuffleBoard 
	final String IntakeSpeed ="IntakeSpeed";
	final String OutTakeSpeed = "OutTakeSpeed";
	
	final double SpeedIn=1.0;
	final double SpeedOut=-0.8;
	private  double setSpeed;
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
       // setDefaultCommand(new MySpecialCommand());
    	
    }
    
    public void intakeCube() {
    	double backup = SpeedIn;
    	setSpeed = getPreferencesDouble( IntakeSpeed ,backup); 
    	
    	intakeLeft.set(setSpeed);
    	intakeRight.set(setSpeed);
    
    }
    
    public void ejectCube() {
    	double backup = SpeedOut;
    	setSpeed = getPreferencesDouble( OutTakeSpeed ,backup);
    	
    	intakeLeft.set(setSpeed);
    	intakeRight.set(setSpeed);
    	
    
    }
    
	/**Axis 2 eject cube
	public void ejectCube(XboxController  actuatorController) { 
	   double posThreshold = -0.15; //Default threshold value from XboxController
		double dblSpeedSetPoint = actuatorController.getRawAxis(2)*-1;
		
		if(dblSpeedSetPoint  > posThreshold) {
			intakeLeft.set(dblSpeedSetPoint);	
			intakeRight.set(dblSpeedSetPoint);
		}
	
		
	
	
		
	}
	**/
    private void getX() {
		// TODO Auto-generated method stub
		
	}

	public void stopMotion() {
    	intakeLeft.set(0.0);
    	intakeRight.set(0.0);
    	
    }
    //
    private static double getPreferencesDouble(String key, double backup) {
    	Preferences preferences = Preferences.getInstance();
    	if(!preferences.containsKey(key)) {
    		preferences.putDouble(key, backup);
    	}
    	return preferences.getDouble(key, backup);
    		
    	}
  
    }

