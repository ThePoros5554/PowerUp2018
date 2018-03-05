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

    public Right_Scale_ToRight() {
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, 0.25, 2));
    	addSequential(new MechDistanceGyroDrive(0.0028, 0, 0.008,  RobotMap.PERCENTTOLERANCE, 570, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward));
    	addSequential(new Timeout(0.3));
    	addSequential(new RunPIDAction(RobotMap.TURN30LEFTKEY));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, 0.5,0.3));
      	addSequential(new TimedMechSys(RobotMap.ELEVATORKEY, -0.8, RobotMap.ELEVATORSTAYUPSPEED, 2.8));
    	addSequential(new Timeout(0.1));
    	addSequential(new MechDistanceGyroDrive(0.0035, 0.000035, 0.0065,  5, 135, RobotMap.FORWARDENCODER,false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 5));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, -0.4, 2));
    	addSequential(new MechTimedGyroDrive(0.3, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 0.8,false));

    }
}
