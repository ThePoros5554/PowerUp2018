package org.usfirst.frc.team5554.robot.commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import commands.auto.MechDistanceGyroDrive;
import commands.auto.RunPIDAction;
import edu.wpi.first.wpilibj.command.CommandGroup;
import systems.subsystems.MechDriveTrain.MechDrivingDirection;

/**
 *
 */
public class Center_Switch_ToLeft extends CommandGroup {

    public Center_Switch_ToLeft() {
    	// need to add "open the elevator" 
    	addSequential(new RunPIDAction(RobotMap.ELEVATORTOSWITCHKEY));
        addSequential(new MechDistanceGyroDrive(RobotMap.KP, RobotMap.KI, RobotMap.KD,  RobotMap.PERCENTTOLERANCE, 175, RobotMap.FORWARDENCODER, RobotMap.GYROKP, MechDrivingDirection.Forward));
    	addSequential(new MechDistanceGyroDrive(RobotMap.KP, RobotMap.KI, RobotMap.KD,  RobotMap.PERCENTTOLERANCE, 112, RobotMap.SIDEENCODER, RobotMap.GYROKP, MechDrivingDirection.Sideways));
        addSequential(new MechDistanceGyroDrive(RobotMap.KP, RobotMap.KI, RobotMap.KD,  RobotMap.PERCENTTOLERANCE, 110, RobotMap.FORWARDENCODER, RobotMap.GYROKP, MechDrivingDirection.Forward));
    }
}
