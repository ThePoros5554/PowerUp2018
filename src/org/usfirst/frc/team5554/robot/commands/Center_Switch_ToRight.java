package org.usfirst.frc.team5554.robot.commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import commands.auto.MechDistanceGyroDrive;
import commands.auto.RunPIDAction;
import edu.wpi.first.wpilibj.command.CommandGroup;
import systems.subsystems.MechDriveTrain.MechDrivingDirection;

/**
 *
 */
public class Center_Switch_ToRight extends CommandGroup {

    public Center_Switch_ToRight() {
    	// need to add "open the elevator"
    	addSequential(new RunPIDAction(RobotMap.ELEVATORTOSWITCHKEY));
        addSequential(new MechDistanceGyroDrive(RobotMap.KP, RobotMap.KI, RobotMap.KD,  RobotMap.PERCENTTOLERANCE, 168, RobotMap.SIDEENCODER, RobotMap.GYROKP, MechDrivingDirection.Sideways));
        addSequential(new MechDistanceGyroDrive(RobotMap.KP, RobotMap.KI, RobotMap.KD,  RobotMap.PERCENTTOLERANCE, 285, RobotMap.FORWARDENCODER, RobotMap.GYROKP, MechDrivingDirection.Forward));
    }
}
