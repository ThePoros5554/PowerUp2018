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
public class Left_Scale_ToLeft extends CommandGroup {

    public Left_Scale_ToLeft() 
    {
    	// need to add "open the elevator" 
    	addParallel(new MechSysToLimit(RobotMap.ELEVATORKEY, -0.8, SysPosition.Top));
    	addSequential(new MechDistanceGyroDrive(0.0027, 0, 0.008,  RobotMap.PERCENTTOLERANCE, 600, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward));
    	addSequential(new Timeout(0.3));
    	addSequential(new RunPIDAction(RobotMap.TURN30LEFTKEY));
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, -0.5,2));
    	addSequential(new Timeout(0.3));
    	addSequential(new MechDistanceGyroDrive(0.0035, 0.000035, 0.007,  5, 130, RobotMap.FORWARDENCODER,false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, 0.7,2));

    }
}
