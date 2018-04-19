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
public class Left_2Cube_Both_ToRight extends CommandGroup {

    public Left_2Cube_Both_ToRight() 
    {
    	addSequential(new MechDistanceGyroDrive(0.008, 0, 0.06,  RobotMap.PERCENTTOLERANCE, 517, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 5));
        addSequential(new RunPIDAction(RobotMap.TURN90RIGHTKEY));
    	addSequential(new MechDistanceGyroDrive(0.008, 0, 0.07,  RobotMap.PERCENTTOLERANCE, 507.5, RobotMap.FORWARDENCODER, 89, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 4));
      	addParallel(new MechSysToLimit(RobotMap.ELEVATORKEY, -1, RobotMap.ELEVATORSTAYUPSPEED, SysPosition.Top));
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, 0.5,2));
    	addSequential(new RunPIDAction(RobotMap.TURN90LEFTKEY));
    	addSequential(new MechDistanceGyroDrive(0.0052, 0.00002, 0.0014,  5, 132, RobotMap.FORWARDENCODER, -107.5, 0.006, MechDrivingDirection.Forward, 2));
    	addParallel(new TimedMechSys(RobotMap.FEEDERKEY, -0.6, 1)); 
    	
    	addSequential(new MechDistanceGyroDrive(0.015, 0.00003, 0.01,  5, -28 /*200cm*/, RobotMap.FORWARDENCODER,false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward));
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, 0.5,2));
    	addSequential(new RunPIDAction(RobotMap.TURN150LEFTKEY));
    	addSequential(new MechSysToLimit(RobotMap.ELEVATORKEY, 1, 0, SysPosition.Bottom));
        addParallel(new TimedMechSys(RobotMap.FEEDERKEY, 0.9, RobotMap.AUTOCONSTFEED, 2));
    	addSequential(new MechDistanceGyroDrive(0.0077, 0.000048, 0.008,  5, 140 /*200cm*/, RobotMap.FORWARDENCODER,false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 3));
    	addSequential(new MechTimedGyroDrive(0.25, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 0.35));
    	
    	addSequential((new TimedMechSys(RobotMap.ELEVATORKEY, -0.7, RobotMap.ELEVATORSTAYUPSPEED,1.2)));
    	addParallel(new MechTimedGyroDrive(-0.3, false,  RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 0.35));
    	addSequential(new Timeout(0.15));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, -0.4,2));
    }
}
