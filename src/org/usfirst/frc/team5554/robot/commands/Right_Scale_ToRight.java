package org.usfirst.frc.team5554.robot.commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import commands.auto.MechDistanceGyroDrive;
import commands.auto.MechSysToLimit;
import commands.auto.RunPIDAction;
import edu.wpi.first.wpilibj.command.CommandGroup;
import sensors.SysPosition;
import systems.subsystems.MechDriveTrain.MechDrivingDirection;

/**
 *
 */
public class Right_Scale_ToRight extends CommandGroup {

    public Right_Scale_ToRight() {
    	// need to add "open the elevator" 
    	addSequential(new MechDistanceGyroDrive(RobotMap.KP, RobotMap.KI, RobotMap.KD,  RobotMap.PERCENTTOLERANCE, 751, RobotMap.FORWARDENCODER, RobotMap.GYROKP, MechDrivingDirection.Forward));
        addSequential(new RunPIDAction(RobotMap.TURNNINTYLEFTKEY));
        addSequential(new MechDistanceGyroDrive(RobotMap.KP, RobotMap.KI, RobotMap.KD,  RobotMap.PERCENTTOLERANCE, 21, RobotMap.FORWARDENCODER, RobotMap.GYROKP, MechDrivingDirection.Forward));
        addParallel(new MechSysToLimit(RobotMap.ELEVATORKEY, SysPosition.Top));
    }
}
