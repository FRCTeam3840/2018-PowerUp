
package org.usfirst.frc3840.ArcadeDrive2018;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
    public static WPI_TalonSRX driveTrainTalonSRX1;
    public static WPI_TalonSRX driveTrainTalonSRX2;
    public static SpeedControllerGroup driveTrainLeftDrive;
    public static WPI_TalonSRX driveTrainTalonSRX4;
    public static WPI_TalonSRX driveTrainTalonSRX3;
    public static SpeedControllerGroup driveTrainRightDrive;
    public static DifferentialDrive driveTrainArcadeTrain;
    public static SpeedController intakeLeft;
    public static SpeedController intakeRight;


    public static void init() {
    	// Constructors for the left drives
        driveTrainTalonSRX1 = new WPI_TalonSRX(1);  
        driveTrainTalonSRX2 = new WPI_TalonSRX(2);
    
        // Speed Controller Group Left Drive
        driveTrainLeftDrive = new SpeedControllerGroup(driveTrainTalonSRX1, driveTrainTalonSRX2);
        driveTrainLeftDrive.setInverted(true);
        
        // Constructors for the right drives
        driveTrainTalonSRX3 = new WPI_TalonSRX(3);
        driveTrainTalonSRX4 = new WPI_TalonSRX(4);
        
        // Speed Controller Group Right Drive
        driveTrainRightDrive = new SpeedControllerGroup(driveTrainTalonSRX3, driveTrainTalonSRX4  );
        
        // Set the differential drive parameters
        driveTrainArcadeTrain = new DifferentialDrive(driveTrainLeftDrive, driveTrainRightDrive);
        LiveWindow.addActuator("DriveTrain", "ArcadeTrain", driveTrainArcadeTrain);
        
        driveTrainArcadeTrain.setSafetyEnabled(false);
        driveTrainArcadeTrain.setExpiration(0.1);
        driveTrainArcadeTrain.setMaxOutput(1.0);
        
        intakeRight = new Spark(0);  //Drive 6
        intakeLeft = new Spark(1);   //Drive 7
        intakeLeft.setInverted(true);
        
        LiveWindow.addActuator("Intake", "LeftIntake", (Spark) intakeLeft);
        LiveWindow.addActuator("Intake", "RightIntake", (Spark) intakeRight);
        
    }
}
