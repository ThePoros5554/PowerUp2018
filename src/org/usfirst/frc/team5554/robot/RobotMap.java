/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5554.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
	public static int frontLeftMotor = 0;
	public static int frontRigtMotor = 1;
	public static int rearLeftMotor = 2;
	public static int rearRightMotor = 3;
	public static int elevator = 7;
	public static int climb = 5;
	public static int feeder = 6;
	
	public static String elevatorKey = "elevator";
	public static String climbKey = "climb";
	public static String feederKey = "feeder";

	public static int elevatorButton = 1;
	public static int climbButton = 1;
	public static int feederButton = 1;


	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
}
