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
public class Right_Scale_ToRight extends CommandGroup {

    public Right_Scale_ToRight() 
    {
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, 0.5, 1.3));
    	addSequential(new MechDistanceGyroDrive(/*0.0035cm*/ 0.003, 0, 0.008,  RobotMap.PERCENTTOLERANCE, /*520*/ 585, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 5));
    	addSequential(new Timeout(0.3));
      	addParallel(new MechSysToLimit(RobotMap.ELEVATORKEY, -0.95, RobotMap.ELEVATORSTAYUPSPEED, SysPosition.Top));
    	addSequential(new RunPIDAction(RobotMap.TURN30LEFTKEY));
    	addSequential(new Timeout(0.1));
    	addSequential(new MechDistanceGyroDrive(0.004, 0.000035, 0.0068,  5, 105 /*200cm*/, RobotMap.FORWARDENCODER,false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 2));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, -0.37,2));
    	addSequential(new Timeout(1));
    	addSequential(new MechTimedGyroDrive(0.2, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 1));
    }
}
