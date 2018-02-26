package org.usfirst.frc.team5554.robot.commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import commands.auto.RunPIDAction;
import commands.auto.TimedMechSys;
import commands.auto.Timeout;
import edu.wpi.first.wpilibj.command.CommandGroup;
import systems.subsystems.MechDriveTrain.MechDrivingDirection;

/**
 *
 */
public class Left_Switch_ToLeft extends CommandGroup {
	
    public Left_Switch_ToLeft() 
    {
    	// need to add "open the elevator" 
    	addParallel(new TimedMechSys(RobotMap.ELEVATORKEY, -0.8,2.3));
    	addSequential(new MechDistanceGyroDrive(0.0032, 0, 0.008,  RobotMap.PERCENTTOLERANCE, 415, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward));
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, -0.5,2));
    	addSequential(new Timeout(0.2));
        addSequential(new RunPIDAction(RobotMap.TURN90LEFTKEY));
    	addSequential(new Timeout(0.2));
        addSequential(new MechDistanceGyroDrive(0.006, 0.000035,0,  RobotMap.PERCENTTOLERANCE, 75, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 4));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, 0.7,2));
    }
}
