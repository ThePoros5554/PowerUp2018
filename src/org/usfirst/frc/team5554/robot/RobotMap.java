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
	public final static int REARRIGHTMOTORPORT = 0;
	public final static int FRONTRIGHTMOTORPORT = 1;
	public final static int REARLEFTMOTORPORT = 2;
	public final static int FRONTLEFTMOTORPORT = 3;

	public final static int ELEVATORPORT = 4;
	public final static int RIGHTRAMPPORT = 5;
	public final static int CLIMBPORT = 6;
	public final static int LEFTRAMPPORT = 7;
	public final static int FEEDERAXISPORT = 8;
	public final static int FEEDERPORT = 9;
	
	public final static String ELEVATORKEY = "elevator";
	public final static String RIGHTRAMPKEY = "rightRamp";
	public final static String CLIMBKEY = "climb";
	public final static String LEFTRAMPKEY = "leftRamp";
	public final static String FEEDERAXISKEY = "feederAxis";
	public final static String FEEDERKEY = "feeder";
	public final static String ONLYROTATEAXISKEY = "onlyRotateAxis";
	public final static String ONLYSPEEDKEY = "onlySpeed";
	public final static String TGDS_LEFTAUTONOMUS = "TGDS_LeftAutonomus";

	public final static int ELEVATORBUTTON = 7;
	public final static int RIGHTRAMPBUTTON = 8;
	public final static int CLIMBBUTTON = 9;
	public final static int LEFTRAMPBUTTON = 10;
	public final static int FEEDERAXISBUTTON =11;
	public final static int FEEDERBUTTON = 12;
	public final static int ONLYROTATEAXISBUTTON = 1;
	public final static int ONLYSPEEDBUTTON = 2;
	
	public final static int SPEEDAXIS = 0;
	public final static int ROTATEAXIS = 1;
	public final static int TWISTAXIS = 2;
	
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
