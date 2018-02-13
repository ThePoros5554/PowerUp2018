package org.usfirst.frc.team5554.robot.commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import commands.auto.MechDistanceGyroDrive;
import edu.wpi.first.wpilibj.command.CommandGroup;
import systems.subsystems.MechDriveTrain.MechDrivingDirection;

/**
 *
 */
public class Forward extends CommandGroup {

    public Forward() {
        addSequential(new MechDistanceGyroDrive(RobotMap.KP, RobotMap.KI, RobotMap.KD,  RobotMap.PERCENTTOLERANCE, 360, RobotMap.FORWARDENCODER, RobotMap.GYROKP, MechDrivingDirection.Forward));
    }
}
