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
	public final static String TURNNINTYLEFTKEY = "turnNintyLeft";
	public final static String ELEVATORTOSWITCHKEY = "elevatorToSwitch";
	public final static String ELEVATORTOSCALEKEY = "elevatorToScale";
	
	/*
	public final static double ELEVATORUPSPEEDCONST = -0.75;
	public final static double ELEVATORDOWNSPEEDCONST = 0.3;	
	*/
	
	public final static double ELEVATORUPSPEED = -1;
	public final static double ELEVATORSTAYUPSPEED = -0.19;
	public final static double ELEVATORDOWNSPEED = 0.3;
	public final static double FEEDERAXISUPSPEED = -0.8;
	public final static double FEEDERAXISDOWNSPEED = 0.4;
	public final static double FEEDERIN70SPEED = 0.95;
	public final static double FEEDERSTAYINSPEED = 0.2;
	public final static double FEEDEROUT45SPEED = -0.45;
	public final static double FEEDEROUT60SPEED= -0.6;
	public final static double FEEDEROUT70SPEED= -0.7;
	public final static double CLIMBUPSPEED = 1;
	public final static double CLIMBDOWNSPEED = -1;

	public final static int ELEVATORUPBUTTON = 3;
	public final static int ELEVATORDOWNBUTTON = 2;
	public final static int FEEDERAXISUPBUTTON = 4;
	public final static int FEEDERAXISDOWNBUTTON = 1;
	public final static int FEEDEROUT45DRIVEJOYBUTTON = 3;
	public final static int FEEDEROUT70DRIVEJOYBUTTON = 4;
	public final static int FEEDERIN70SYSTEMJOYBUTTON = 6;
	public final static int FEEDEROUT60SYSTEMJOYBUTTON = 5;
	public final static int CLIMBUPBUTTON = 2;
	public final static int CLIMBDOWNBUTTON = 3;
	public final static int ONLYROTATEAXISBUTTON = 1;
	public final static int ONLYTWISTBUTTON = 2;
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
	public final static double FIXGYROKP = 0.015;
	public final static double ENCODERSIDEDISTANCEPERPULSE = 47.8536/360;
	public final static double ENCODERFORWARDDISTANCEPERPULSE = 47.8536/360;

	
	public final static String TURN30RIGHTKEY = "TURN30RIGHTKEY";
	public final static String TURN30LEFTKEY = "TURN30LEFTKEY";
	public final static double TURN30P = 0.01;
	public final static double TURN30I = 0.000545;
	public final static double TURN30D = 0.006;
	
	public final static String TURN90RIGHTKEY = "TURN90RIGHTKEY";
	public final static String TURN90LEFTKEY = "TURN90LEFTKEY";
	public final static double TURN90P = 0.0064;
	public final static double TURN90I = 0.0002;
	public final static double TURN90D = 0.007;
	public final static double TURNNINTYTOLERENCE = 2;
	
	public final static String TURN120RIGHTKEY = "TURN100RIGHTKEY";
	public final static String TURN120LEFTKEY = "TURN100LEFTKEY";
	public final static double TURN100P = 0.0065;
	public final static double TURN100I = 0.00016;
	public final static double TURN100D = 0.035;
	
	public final static String TURN150RIGHTKEY = "TURN150RIGHTKEY";
	public final static String TURN150LEFTKEY = "TURN150LEFTKEY";
	public static final double TURN150P = 0.0065;
	public static final double TURN150I = 0.0001;
	public static final double TURN150D = 0.05;

	
    public final static SPI.Port GYRO_PORT  = SPI.Port.kOnboardCS0;
    public final static Encoder SIDEENCODER  = new Encoder(0, 1, false, EncodingType.k4X);
    public final static Encoder  FORWARDENCODER = new Encoder(2, 3, false, EncodingType.k4X);
    public final static LimitSwitch ELEVATORTOP = new LimitSwitch(4, SysPosition.Top, true);
    public final static LimitSwitch ELEVATORBOTTOM = new LimitSwitch(5, SysPosition.Bottom, true);
    public final static DualLimit ELEVATORSWITCHES = new DualLimit(ELEVATORTOP, ELEVATORBOTTOM);
    public final static LimitSwitch CLIMBTOPSWITCH = new LimitSwitch(7, SysPosition.Top, true);
    public final static LimitSwitch FEEDERAXISSWITCH = new LimitSwitch(8, SysPosition.Top, false);
    public final static LimitSwitch FEEDERSWITCH = new LimitSwitch(9, SysPosition.Top, false);
	
    public static final int NUMBER_OF_CAMERAS = 2;
	public static final int CLIMBCAMERA = 0;
	public static final int FORWARDCAMERA = 0;
	public static final int CUBECAMERA = 1;
	public static final int CLIMBCAMERABUTTON = 11;
	public static final int SWITCHCAMERABUTTON = 6;
	
	public static final double AUTOCONSTFEED = 0.3;
	public static final double CLIMBDOWNCONST = -0.4;

}
