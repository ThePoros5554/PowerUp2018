/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;

import org.omg.CORBA.PUBLIC_MEMBER;

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
	public final static int LEFTFEEDERPORT = 6;
	public final static int RIGHTFEEDERPORT = 7;
	public final static int LEFTCLIMBPORT = 8;
	public final static int RIGHTCLIBPORT = 9;
	
	public final static String ELEVATORKEY = "elevator";
	public final static String ELEVATORUPKEY = "elevatorUp";
	public final static String ELEVATORDOWNKEY = "elevatorDown";
	public final static String FEEDERAXISKEY = "feederAxis";
	public final static String FEEDERAXISUPKEY = "feederAxisUp";
	public final static String FEEDERAXISDOWNKEY = "feederAxisDown";
	public final static String FEEDERKEY = "feeder";
	public final static String FEEDERINKEY = "feederIn";
	public final static String FEEDEROUTKEY = "feederOut";
	public final static String CLIMBKEY = "climb";
	public final static String CLIMBUPKEY = "climbUp";
	public final static String CLIMBDOWNKEY = "climbDown";
	public final static String ONLYROTATEAXISKEY = "onlyRotateAxis";
	public final static String ONLYSPEEDKEY = "onlySpeed";
	public final static String TGDS_LEFTAUTONOMUS = "TGDS_LeftAutonomus";
	public final static String RUNPIDACTIONKEY = "runPidAction";
	public static final String TURNNINTYRIGHTKEY = "turnNintyRight";
	public final static String TURNNINTYLEFTKEY = "turnNintyLeft";
	public final static String ELEVATORTOSWITCHKEY = "elevatorToSwitch";
	public final static String ELEVATORTOSCALEKEY = "elevatorToScale";
	
	public final static String ELEVATORUPSPEED = "ELEVATORUPSPEED";
	public final static String ELEVATORDOWNSPEED = "ELEVATORDOWNSPEED";
	public final static String FEEDERAXISUPSPEED = "FEEDERAXISUPSPEED";
	public final static String FEEDERAXISDOWNSPEED = "FEEDERAXISDOWNSPEED";

	public final static int ELEVATORUPBUTTON = 3;
	public final static int ELEVATORDOWNBUTTON = 2;
	public final static int FEEDERAXISUPBUTTON = 6;
	public final static int FEEDERAXISDOWNBUTTON = 5;
	public final static int FEEDERINBUTTON = 4;
	public final static int FEEDEROUTBUTTON = 3;
	public final static int CLIMBUPBUTTON = 4;
	public final static int CLIMBDOWNBUTTON = 1;
	public final static int ONLYROTATEAXISBUTTON = 1;
	public final static int ONLYSPEEDBUTTON = 2;
	
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
	
	public final static double TURNP = 0.0065;
	public final static double TURNI = 0.00025;
	public final static double TURND = 0.001;
	
	public final static String TURN70KEY = "TURN70KEY";
	public final static double TURNNINTYLEFTSP = -90;
	public final static double TURNNINTYRIGHTSP = 90;
	public final static double TURNNINTYTOLERENCE = 2;
	
	public final static double ELEVATORP = 0;
	public final static double ELEVATORI = 0;
	public final static double ELEVATORD = 0;
	public final static double ELEVATORTOSWITCHSP = 0;
	public final static double ELEVATORTOLERENCE = 0;
	
    public final static SPI.Port GYRO_PORT  = SPI.Port.kOnboardCS0;
    public final static Encoder FORWARDENCODER = new Encoder(0, 1, false, EncodingType.k4X);
    public final static Encoder SIDEENCODER = new Encoder(2, 3, false, EncodingType.k4X);
    public final static LimitSwitch ELEVATORTOP = new LimitSwitch(4, SysPosition.Top, true);
    public final static LimitSwitch ELEVATORBOTTOM = new LimitSwitch(5, SysPosition.Bottom, true);
    public final static DualLimit ELEVATORSWITCHES = new DualLimit(ELEVATORTOP, ELEVATORBOTTOM);
    
}
