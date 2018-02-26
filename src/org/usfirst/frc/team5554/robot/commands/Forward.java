package org.usfirst.frc.team5554.robot.commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;
import systems.subsystems.MechDriveTrain.MechDrivingDirection;

/**
 *
 */
public class Forward extends CommandGroup 
{

    public Forward() 
    {
    	addSequential(new MechDistanceGyroDrive(0.0032, 0, 0.008,  RobotMap.PERCENTTOLERANCE, 415, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward));
    }
}
