package org.usfirst.frc.team5554.robot.commands;

import org.usfirst.frc.team5554.robot.RobotMap;

//import commands.auto.RunPidAction;
import edu.wpi.first.wpilibj.command.CommandGroup;
import systems.subsystems.MechDriveTrain.MechDrivingDirection;

/**
 *
 */
public class Left_Switch_ToLeft extends CommandGroup {
	
    public Left_Switch_ToLeft() {
        addSequential(new MechDistanceGyroDrive(RobotMap.KP, RobotMap.KI, RobotMap.KD,  RobotMap.PERCENTTOLERANCE, -357, RobotMap.FORWARDENCODER, RobotMap.GYROKP, MechDrivingDirection.Forward));
        //addSequential(new RunPidAction(RobotMap.RUNPIDACTIONKEY));
    }
}
