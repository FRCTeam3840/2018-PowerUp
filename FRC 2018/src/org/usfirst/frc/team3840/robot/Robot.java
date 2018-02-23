
package org.usfirst.frc.team3840.robot;

import org.usfirst.frc.team3840.robot.commands.AutonomousCommand;
import org.usfirst.frc.team3840.robot.commands.Climb;
import org.usfirst.frc.team3840.robot.commands.EjectCubeAxis;
import org.usfirst.frc.team3840.robot.subsystems.Climber;
import org.usfirst.frc.team3840.robot.subsystems.ClimberLatch;
import org.usfirst.frc.team3840.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3840.robot.subsystems.Intake;
import org.usfirst.frc.team3840.robot.subsystems.LiftElevator;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

    public static OI oi;
    public static DriveTrain driveTrain;
    public static Intake intake;
    public static Climber climber;
    public static Climb manualclimber;
    public static ClimberLatch unLatchClimber;
    public static LiftElevator liftElevator;
    public static EjectCubeAxis cubeAxis;
       
    int autoSelectionChooser;
    int autoSendSelection;
    
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();
		
		intake = new Intake();
		driveTrain = new DriveTrain();
		climber = new Climber();
		unLatchClimber = new ClimberLatch();
		liftElevator = new LiftElevator();
		manualclimber = new Climb();
		cubeAxis = new EjectCubeAxis();
        SmartDashboard.putData(liftElevator);
               
        //Setup Usb camera connection      
        UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture(0);
        cam0.setFPS(20);
        
	    // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        oi = new OI();
		
        //Add commands to autonomous Sendable chooser
        // chooser.addDefault("Autonomous Command", new AutonomousCommand());
        chooser.addDefault("Default Auto", new AutonomousCommand(0));
		chooser.addObject("Left Position", new AutonomousCommand(1));
		chooser.addObject("Right Position", new AutonomousCommand(2));
        SmartDashboard.putData("Auto Mode", chooser);
        
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		autonomousCommand = chooser.getSelected();
		
		String autoSelected = SmartDashboard.getString("Auto Select", "Default"); 
		  
		 String gameData;
		  gameData = DriverStation.getInstance().getGameSpecificMessage();
		  
		  if(gameData.charAt(0) == 'L')
			{
				//Put left auto code here
			} else {
				//Put right auto code here
			}
		  
		  /**
		  switch(autonomousCommand) {
		  	case "Default Auto":
		  		autoSelectionChooser = 1;
		  		break;
		  	case "Left Position": 
		  		autoSelectionChooser = 2; 
		  		break; 
		  	case "Right Position": 
		  		autoSelectionChooser = 3;
		  		break;
		  	default:  
		  		//autoSelectionChooser = 0;
		  } */
		  
		  autoSelectionChooser = 2;
		 
		 // Sets the auto mode we will run
		  autonomousCommand = new AutonomousCommand(autoSelectionChooser);
		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		
		// Sets the auto mode we will run
		  autonomousCommand = new AutonomousCommand(autoSelectionChooser);
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
