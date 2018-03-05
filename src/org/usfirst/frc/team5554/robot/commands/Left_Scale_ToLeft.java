package org.usfirst.frc.team5554.robot.commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import commands.auto.MechTimedGyroDrive;
import commands.auto.RunPIDAction;
import commands.auto.TimedMechSys;
import commands.auto.Timeout;
import edu.wpi.first.wpilibj.command.CommandGroup;
import systems.subsystems.MechDriveTrain.MechDrivingDirection;

/**
 *
 */
public class Left_Scale_ToLeft extends CommandGroup {

    public Left_Scale_ToLeft() 
    {
    	// need to add "open the elevator" 
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, 0.25, 2));
    	addSequential(new MechDistanceGyroDrive(0.0028, 0, 0.008,  RobotMap.PERCENTTOLERANCE, 570, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward));
    	addSequential(new Timeout(0.3));
    	addSequential(new RunPIDAction(RobotMap.TURN30RIGHTKEY));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, 0.5,0.3));
      	addSequential(new TimedMechSys(RobotMap.ELEVATORKEY, -0.8, RobotMap.ELEVATORSTAYUPSPEED, 2));
    	addSequential(new Timeout(0.1));
    	addSequential(new MechDistanceGyroDrive(0.0035, 0.00003, 0.0065,  5, 115, RobotMap.FORWARDENCODER,false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 5));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, -0.35,2));
    	addSequential(new MechTimedGyroDrive(0.3, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 0.5,false));
    }
}
