package org.usfirst.frc.team3840.robot.subsystems;

import org.usfirst.frc.team3840.robot.RobotMap;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public final SpeedController climber = RobotMap.climber;
	
	// SmartDashBoard , suffleBoard
	final String ClimberSpeed = "ClimberSpeed";
	
	final double speedUp= 0.8;
	private double setSpeed;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    	
    }
    
    
    public void climbScale() {
    	double backup = speedUp;
    	setSpeed = getPreferencesDouble( ClimberSpeed ,backup); 
    	
    	climber.set(setSpeed);
    }
    
	/**Axis 3 climbScale
	public void climbScale(XboxController  DriveController) { 
	    double posThreshold = -0.15; //Default threshold value from XboxController
		double dblSpeedSetPoint = DriveController.getRawAxis(3);
		
		if(dblSpeedSetPoint  > posThreshold) {
			climber.set(dblSpeedSetPoint); }
		}
		
    

private void getX() {
	// TODO Auto-generated method stub
	
}
 **/   
public void stopMotion() {
	climber.set(0.0);
	
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


