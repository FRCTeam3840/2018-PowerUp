package org.usfirst.frc.team3840.robot.subsystems;

import org.usfirst.frc.team3840.robot.RobotMap;
import org.usfirst.frc.team3840.robot.commands.DriveRobot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *Drive Train SubSystem
 */
public class DriveTrain extends Subsystem {

	private final DifferentialDrive arcadeTrain = RobotMap.driveTrainArcadeTrain;
	
	@Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveRobot());
	}
	
	@Override
	public void periodic() {
		// put code here to be run every loop
		
	} 
	// Put Methods for controlling this subsystem here. Call these from commands
	
	//Arcade Drive from Drive via XboxConroller input 
	public void arcadeDrive(XboxController joystick1) {
		double joyThreshold = 0.15; // Default threshold value from XboxController
		double stickX = joystick1.getX();
		double stickY = joystick1.getY()*-1 ;
		// display on dashboards
		SmartDashboard.putNumber("speed X: ", stickX);
		SmartDashboard.putNumber("speed Y: ", stickY);
		//Checks for min joystick input
		if(Math.abs(stickX) > joyThreshold|| Math.abs(stickY) > joyThreshold || true) {
			arcadeTrain.arcadeDrive(stickX, stickY, true);
    }
}

	//Stop motion for arcade drive
	public void StopMotion() {
		
		arcadeTrain.stopMotor();
	}
	
}
	
	
	
	
