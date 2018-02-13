
package org.usfirst.frc.team3840.robot;

import org.usfirst.frc.team3840.robot.commands.AutonomousCommand;
import org.usfirst.frc.team3840.robot.commands.Climb;
import org.usfirst.frc.team3840.robot.commands.Cube_In;
import org.usfirst.frc.team3840.robot.commands.Cube_Out;
import org.usfirst.frc.team3840.robot.commands.DriveRobot;
import org.usfirst.frc.team3840.robot.commands.LiftToPickUp;
import org.usfirst.frc.team3840.robot.commands.LiftToScale;
import org.usfirst.frc.team3840.robot.commands.LiftToSwitch;
import org.usfirst.frc.team3840.robot.commands.LiftToTravel;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/** This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
		
	// JoyStick declares // Joystick stick = new Joystick(port);
	public XboxController driveJoyStick;
	public XboxController actuatorJoyStick;
	public JoystickButton buttonLiftToPickup;
    public JoystickButton butttonLiftSwitch;
    public JoystickButton butttonLiftScale;
    public JoystickButton butttonLiftTravel;

	public OI() {
    // set constructor for controller
		driveJoyStick = new XboxController(0);
		actuatorJoyStick = new XboxController(1);
		
		//Button in intake
		Button cubeIn = new JoystickButton(actuatorJoyStick, 5);
	    cubeIn.whileHeld(new Cube_In());
        //Button out intake
	   Button cubeOut = new JoystickButton(actuatorJoyStick, 6);//Axis2
	   cubeOut.whileHeld(new Cube_Out());
	    
	   //Climb the Scale
	   //   Button climb = new JoystickButton(driveJoyStick, 6);
	   //  climb.whileHeld(new Climb());
	   
	 //---------------------------------------------
       //button declares for commands to subsystems
       //---------------------------------------------
       // Button #1
       buttonLiftToPickup = new JoystickButton(actuatorJoyStick, 1);
       buttonLiftToPickup.whenPressed(new LiftToPickUp());
       // Button #2
       butttonLiftTravel = new JoystickButton(actuatorJoyStick, 2);
       butttonLiftTravel.whenPressed(new LiftToTravel());
       // Button #3
       butttonLiftSwitch = new JoystickButton(actuatorJoyStick, 3);
       butttonLiftSwitch.whenPressed(new LiftToSwitch());
       // Button #4
       butttonLiftScale = new JoystickButton(actuatorJoyStick, 4);
       butttonLiftScale.whenPressed(new LiftToScale());
       
       // SmartDashboard Buttons
       SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
       SmartDashboard.putData("LiftToTravel", new LiftToTravel());
       SmartDashboard.putData("LiftToSwitch", new LiftToSwitch());
       SmartDashboard.putData("LiftToScale", new LiftToScale());
       SmartDashboard.putData("LiftToPickup", new LiftToPickUp());
	   SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
	   SmartDashboard.putData("DriveRobot", new DriveRobot());
		
	}
	
	
	public XboxController GetDriveJoyStick() {
		return driveJoyStick;
	}
	
	public XboxController GetActuatorJoyStick() {
		return actuatorJoyStick;
		
	}
	
	
	
	
	
	
}
