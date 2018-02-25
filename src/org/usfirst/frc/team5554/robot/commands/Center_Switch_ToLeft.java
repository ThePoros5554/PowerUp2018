package org.usfirst.frc.team5554.robot.commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import commands.auto.TimedMechSys;
import commands.auto.Timeout;
import edu.wpi.first.wpilibj.command.CommandGroup;
import systems.subsystems.MechDriveTrain.MechDrivingDirection;

/**
 *
 */
public class Center_Switch_ToLeft extends CommandGroup {

    public Center_Switch_ToLeft() 
    {
    	addParallel(new TimedMechSys(RobotMap.ELEVATORKEY, -0.8,2));
    	addSequential(new MechDistanceGyroDrive(0.0035, 0.000035, 0.007,  5, 130, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward));
    	addSequential(new Timeout(0.1));
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, -0.5,2));
    	addSequential(new MechDistanceGyroDrive(0.035, 0.0000, 0.1,  5, -150, RobotMap.SIDEENCODER, false, RobotMap.SIDEGYROKP, MechDrivingDirection.Sideways));
    	addSequential(new Timeout(0.2));
    	addSequential(new MechDistanceGyroDrive(0.0035, 0.00002, 0.008,  5, 180, RobotMap.FORWARDENCODER,true, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 7));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, 0.7,2));
    }
}
