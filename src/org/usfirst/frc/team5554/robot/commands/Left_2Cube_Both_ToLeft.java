package org.usfirst.frc.team5554.robot.commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import commands.auto.MechSysToLimit;
import commands.auto.MechTimedGyroDrive;
import commands.auto.RunPIDAction;
import commands.auto.TimedMechSys;
import commands.auto.Timeout;
import edu.wpi.first.wpilibj.command.CommandGroup;
import sensors.SysPosition;
import systems.subsystems.MechDriveTrain.MechDrivingDirection;

/**
 *
 */
public class Left_2Cube_Both_ToLeft extends CommandGroup {

    public Left_2Cube_Both_ToLeft() 
    {
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, 0.5, 1.3));
    	addSequential(new MechDistanceGyroDrive(/*0.0035cm*/ 0.00635, 0, 0.045,  RobotMap.PERCENTTOLERANCE, /*520*/ 580, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 5));
      	addParallel(new MechSysToLimit(RobotMap.ELEVATORKEY, -1, RobotMap.ELEVATORSTAYUPSPEED, SysPosition.Top));
    	addSequential(new RunPIDAction(RobotMap.TURN30RIGHTKEY));
    	addSequential(new MechDistanceGyroDrive(0.0057, 0.000035, 0.008,  5, 100 /*200cm*/, RobotMap.FORWARDENCODER,false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 3));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, -0.5,0.35));
    	addSequential(new MechDistanceGyroDrive(0.015, 0.00003, 0.008,  5, -30 /*200cm*/, RobotMap.FORWARDENCODER,false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward));
    	addSequential(new Timeout(0.2));
    	addSequential(new RunPIDAction(RobotMap.TURN120RIGHTKEY));
    	addSequential(new MechSysToLimit(RobotMap.ELEVATORKEY, 0.8, 0, SysPosition.Bottom));
    	addParallel(new TimedMechSys(RobotMap.FEEDERKEY, 0.9,RobotMap.AUTOCONSTFEED, 4));
    	addSequential(new MechDistanceGyroDrive(0.0057, 0.000052, 0.008,  5, 140 /*200cm*/, RobotMap.FORWARDENCODER,false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 3));
    	addSequential(new MechTimedGyroDrive(-0.1, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 0.5));
    	addSequential(new Timeout(0.3));
    	addSequential(new MechTimedGyroDrive(0.25, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 0.7));
    	
    	////////////////////////
    	addSequential((new TimedMechSys(RobotMap.ELEVATORKEY, -0.7, RobotMap.ELEVATORSTAYUPSPEED,1.2)));
    	addSequential(new MechTimedGyroDrive(-0.25, false,  RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 1.5));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, -0.35,2));
    }
}
