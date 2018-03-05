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
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, 0.2,2));
    	addSequential(new MechDistanceGyroDrive(0.0023, 0.000012, 0.01,  RobotMap.PERCENTTOLERANCE, 370, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward));
    	addSequential(new Timeout(0.2));
        addSequential(new RunPIDAction(RobotMap.TURN90RIGHTKEY));
    	addSequential(new Timeout(0.2));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, 0.5,0.3));
    	addSequential((new TimedMechSys(RobotMap.ELEVATORKEY, -0.6, RobotMap.ELEVATORSTAYUPSPEED,1.5)));
        addSequential(new MechDistanceGyroDrive(0.006, 0.000015,0,  RobotMap.PERCENTTOLERANCE, 65, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 3));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, -0.35,2));
    	
    }
}
