package org.usfirst.frc.team5554.robot.commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import commands.auto.MechSysToLimit;
import commands.auto.RunPIDAction;
import commands.auto.TimedMechSys;
import edu.wpi.first.wpilibj.command.CommandGroup;
import sensors.SysPosition;
import systems.subsystems.MechDriveTrain.MechDrivingDirection;

/**
 *
 */
public class Right_Scale_ToLeft extends CommandGroup {

    public Right_Scale_ToLeft() 
    {
    	addSequential(new MechDistanceGyroDrive(0.00405, 0, 0.015,  RobotMap.PERCENTTOLERANCE, 521.5, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 5));
        addSequential(new RunPIDAction(RobotMap.TURN90LEFTKEY));
    	addSequential(new MechDistanceGyroDrive(0.004, 0, 0.015,  RobotMap.PERCENTTOLERANCE, 512, RobotMap.FORWARDENCODER, 89, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 4));
        addSequential(new RunPIDAction(RobotMap.TURN90RIGHTKEY));
      	addParallel(new MechSysToLimit(RobotMap.ELEVATORKEY, -0.95, RobotMap.ELEVATORSTAYUPSPEED, SysPosition.Top));
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, 0.5,2));
    	addSequential(new MechDistanceGyroDrive(0.0025, 0.000036, 0.0065,  5, 170, RobotMap.FORWARDENCODER,-115, 0.006, MechDrivingDirection.Forward, 2));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, -0.4,3));  
    }
}
