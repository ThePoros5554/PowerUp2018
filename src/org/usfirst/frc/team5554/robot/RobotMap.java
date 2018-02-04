/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.SPI;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
	public static int REARRIGHTMOTORPORT = 0;
	public static int FRONTRIGHTMOTORPORT = 1;
	public static int REARLEFTMOTORPORT = 2;
	public static int FRONTLEFTMOTORPORT = 3;

	public static int ELEVATORPORT = 4;
	public static int RIGHTRAMPPORT = 5;
	public static int CLIMBPORT = 6;
	public static int LEFTRAMPPORT = 7;
	public static int FEEDERAXISPORT = 8;
	public static int FEEDERPORT = 9;
	
	public static String ELEVATORKEY = "elevator";
	public static String RIGHTRAMPKEY = "rightRamp";
	public static String CLIMBKEY = "climb";
	public static String LEFTRAMPKEY = "leftRamp";
	public static String FEEDERAXISKEY = "feederAxis";
	public static String FEEDERKEY = "feeder";
	public static String TGDS_LEFTAUTONOMUS = "TGDS_LeftAutonomus";

	public static int ELEVATORBUTTON = 7;
	public static int RIGHTRAMPBUTTON = 8;
	public static int CLIMBBUTTON = 9;
	public static int LEFTRAMPBUTTON = 10;
	public static int FEEDERAXISBUTTON =11;
	public static int FEEDERBUTTON = 12;
	
    public static final SPI.Port GYRO_PORT  = SPI.Port.kOnboardCS0;

	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
