package org.usfirst.frc.team5554.robot.commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import commands.auto.MechSysToLimit;
import commands.auto.MechTimedGyroDrive;
import commands.auto.RunPIDAction;
import commands.auto.TimedMechSys;
import edu.wpi.first.wpilibj.command.CommandGroup;
import sensors.SysPosition;
import systems.subsystems.MechDriveTrain.MechDrivingDirection;

/**
 *
 */
public class Left_2Cube_Scale_ToRight extends CommandGroup {

    public Left_2Cube_Scale_ToRight() 
    {
    	addSequential(new MechDistanceGyroDrive(0.008, 0, 0.055,  RobotMap.PERCENTTOLERANCE, 519, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 5));
        addSequential(new RunPIDAction(RobotMap.TURN90RIGHTKEY));
    	addSequential(new MechDistanceGyroDrive(0.008, 0, 0.055,  RobotMap.PERCENTTOLERANCE, 507.5, RobotMap.FORWARDENCODER, 89, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 4));
      	addParallel(new MechSysToLimit(RobotMap.ELEVATORKEY, -1, RobotMap.ELEVATORSTAYUPSPEED, SysPosition.Top));
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, 0.5,2));
    	addSequential(new RunPIDAction(RobotMap.TURN90LEFTKEY));
    	addSequential(new MechDistanceGyroDrive(0.0052, 0.00002, 0.0014,  5, 132, RobotMap.FORWARDENCODER, -107.5, 0.006, MechDrivingDirection.Forward, 2));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, -0.5, 0.25)); 
    	
    	addSequential(new MechDistanceGyroDrive(0.015, 0.00003, 0.01,  5, -35 /*200cm*/, RobotMap.FORWARDENCODER,false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward));
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, 0.5,2));
    	addSequential(new RunPIDAction(RobotMap.TURN150LEFTKEY));
    	addSequential(new MechSysToLimit(RobotMap.ELEVATORKEY, 1, 0, SysPosition.Bottom));
        addParallel(new TimedMechSys(RobotMap.FEEDERKEY, 0.9, RobotMap.AUTOCONSTFEED, 2));
    	addSequential(new MechDistanceGyroDrive(0.0057, 0.000048, 0.008,  5, 140 /*200cm*/, RobotMap.FORWARDENCODER,false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 3));
    	addSequential(new MechTimedGyroDrive(0.25, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 0.3));
    	
    	addParallel(new MechSysToLimit(RobotMap.ELEVATORKEY, -1, RobotMap.ELEVATORSTAYUPSPEED, SysPosition.Top));
    	addSequential(new MechDistanceGyroDrive(0.0059, 0.0000825, 0.0075,  5, -125 /*200cm*/, RobotMap.FORWARDENCODER,false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 4));
        addSequential(new RunPIDAction(RobotMap.TURN150RIGHTKEY));
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, -0.5, 1));
    	addParallel(new MechTimedGyroDrive(-0.25, false,  RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 0.3));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, -0.4,2));
    	addSequential(new MechTimedGyroDrive(0.25, false,  RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 0.75));

    	
    	
    }
}
