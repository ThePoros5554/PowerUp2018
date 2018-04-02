package org.usfirst.frc.team5554.robot.commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import commands.auto.RunPIDAction;
import commands.auto.TimedMechSys;
import edu.wpi.first.wpilibj.command.CommandGroup;
import systems.subsystems.MechDriveTrain.MechDrivingDirection;

/**
 *
 */
public class Right_Switch_ToLeft extends CommandGroup {

    public Right_Switch_ToLeft() 
    {
    	addSequential(new MechDistanceGyroDrive(0.00405, 0, 0.015,  RobotMap.PERCENTTOLERANCE, 521.5, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 5));
        addSequential(new RunPIDAction(RobotMap.TURN90LEFTKEY));
    	addSequential(new MechDistanceGyroDrive(0.004, 0, 0.015,  RobotMap.PERCENTTOLERANCE, 512, RobotMap.FORWARDENCODER, 89, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 4));
        addSequential(new RunPIDAction(RobotMap.TURN90LEFTKEY));
        addParallel((new TimedMechSys(RobotMap.ELEVATORKEY, -0.65, RobotMap.ELEVATORSTAYUPSPEED,1.5)));
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, 0.5,2));
    	addSequential(new MechDistanceGyroDrive(0.0025, 0.000028, 0.0065,  5, 125, RobotMap.FORWARDENCODER,-150, 0.005, MechDrivingDirection.Forward, 1.5));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, -0.35,3));  

    }
}
