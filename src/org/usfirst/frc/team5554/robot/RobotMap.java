/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import sensors.DualLimit;
import sensors.LimitSwitch;
import sensors.SysPosition;

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
	public final static int FEEDERAXISPORT = 5;
	public final static int FEEDERPORT = 6;
	public final static int CLIMBPORT = 7;
	
	public final static String ELEVATORKEY = "elevator";
	public final static String ELEVATORUPKEY = "elevatorUp";
	public final static String ELEVATORDOWNKEY = "elevatorDown";
	public final static String FEEDERAXISKEY = "feederAxis";
	public final static String FEEDERAXISUPKEY = "feederAxisUp";
	public final static String FEEDERAXISDOWNKEY = "feederAxisDown";
	public final static String FEEDERKEY = "feeder";
	public final static String CLIMBKEY = "climb";

	public final static String ONLYROTATEAXISKEY = "onlyRotateAxis";
	public final static String ONLYSPEEDKEY = "onlySpeed";
	public final static String TGDS_LEFTAUTONOMUS = "TGDS_LeftAutonomus";
	public final static String RUNPIDACTIONKEY = "runPidAction";
	public static final String TURNNINTYRIGHTKEY = "turnNintyRight";
	public final static String TURNNINTYLEFTKEY = "turnN"
			+ "intyLeft";
	public final static String ELEVATORTOSWITCHKEY = "elevatorToSwitch";
	public final static String ELEVATORTOSCALEKEY = "elevatorToScale";
	
	public final static double ELEVATORUPSPEED = -0.7;
	public final static double ELEVATORSTAYUPSPEED = -0.19;
	public final static double ELEVATORDOWNSPEED = 0.3;
	public final static double FEEDERAXISUPSPEED = -0.8;
	public final static double FEEDERAXISDOWNSPEED = 0.8;
	public final static double FEEDERINSPEED = 0.7;
	public final static double FEEDEROUTSPEED= -0.7;
	public final static double CLIMBUPSPEED = 0.5;
	public final static double CLIMBDOWNSPEED = -0.5;

	public final static int ELEVATORUPBUTTON = 3;
	public final static int ELEVATORDOWNBUTTON = 2;
	public final static int FEEDERAXISUPBUTTON = 4;
	public final static int FEEDERAXISDOWNBUTTON = 1;
	public final static int FEEDERINDRIVEJOYBUTTON = 4;
	public final static int FEEDEROUTDRIVEJOYBUTTON = 3;
	public final static int FEEDERINSYSTEMJOYBUTTON = 6;
	public final static int FEEDEROUTSYSTEMJOYBUTTON = 5;
	public final static int CLIMBUPBUTTON = 2;
	public final static int CLIMBDOWNBUTTON = 3;
	public final static int ONLYROTATEAXISBUTTON = 1;
	public final static int ONLYSPEEDBUTTON = 2;
	public final static int REVERSEDRIVEBUTTON = 5;
	public static final int CANCELLSWITCHESBUTTON = 7;
	public static final int ENABLESWITCHESBUTTON = 8;

	
	public final static int SPEEDAXIS = 0;
	public final static int ROTATEAXIS = 1;
	public final static int TWISTAXIS = 2;
	
	public final static double KP = 0.5;
	public final static double KI = 0;
	public final static double KD = 0;
	public final static double PERCENTTOLERANCE = 5;
	public final static double FORWARDGYROKP = 0.065;
	public final static double SIDEGYROKP = 0.07;
	public final static double ENCODERDISTANCEPERPULSE = 47.8536/360;

	
	public final static String TURN30RIGHTKEY = "TURN30RIGHTKEY";
	public final static String TURN30LEFTKEY = "TURN30LEFTKEY";
	public final static double TURN30P = 0.012;
	public final static double TURN30I = 0.00053;
	public final static double TURN30D = 0.005;
	
	public final static String TURN90RIGHTKEY = "TURN90RIGHTKEY";
	public final static String TURN90LEFTKEY = "TURN90LEFTKEY";
	public final static double TURN90P = 0.006;
	public final static double TURN90I = 0.00015;
	public final static double TURN90D = 0.007;
	public final static double TURNNINTYTOLERENCE = 2;
	
    public final static SPI.Port GYRO_PORT  = SPI.Port.kOnboardCS0;
    public final static Encoder SIDEENCODER  = new Encoder(0, 1, false, EncodingType.k4X);
    public final static Encoder  FORWARDENCODER = new Encoder(2, 3, false, EncodingType.k4X);
    public final static LimitSwitch ELEVATORTOP = new LimitSwitch(4, SysPosition.Top, true);
    public final static LimitSwitch ELEVATORBOTTOM = new LimitSwitch(5, SysPosition.Bottom, true);
    public final static DualLimit ELEVATORSWITCHES = new DualLimit(ELEVATORTOP, ELEVATORBOTTOM);
    public final static LimitSwitch CLIMBTOPSWITCH = new LimitSwitch(7, SysPosition.Top, true);
    public final static LimitSwitch FEEDERAXISSWITCH = new LimitSwitch(8, SysPosition.Top, true);
    public final static LimitSwitch FEEDERSWITCH = new LimitSwitch(9, SysPosition.Top, false);
	
    public static final int NUMBER_OF_CAMERAS = 1;
	public static final int LIVECAMERA = 1;
	
}
