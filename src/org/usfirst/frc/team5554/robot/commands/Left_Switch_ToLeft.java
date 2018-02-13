package org.usfirst.frc.team5554.robot.commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import commands.auto.MechDistanceGyroDrive;
import commands.auto.RunPIDAction;
import edu.wpi.first.wpilibj.command.CommandGroup;
import systems.subsystems.MechDriveTrain.MechDrivingDirection;

/**
 *
 */
public class Left_Switch_ToLeft extends CommandGroup {
	
    public Left_Switch_ToLeft() {
    	// need to add "open the elevator" 
    	addSequential(new RunPIDAction(RobotMap.ELEVATORTOSWITCHKEY));
        addSequential(new MechDistanceGyroDrive(RobotMap.KP, RobotMap.KI, RobotMap.KD,  RobotMap.PERCENTTOLERANCE, 357, RobotMap.FORWARDENCODER, RobotMap.GYROKP, MechDrivingDirection.Forward));
        addSequential(new RunPIDAction(RobotMap.TURNNINTYRIGHTKEY));
        addSequential(new MechDistanceGyroDrive(RobotMap.KP, RobotMap.KI, RobotMap.KD,  RobotMap.PERCENTTOLERANCE, 61, RobotMap.FORWARDENCODER, RobotMap.GYROKP, MechDrivingDirection.Forward));
    }
}
