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
public class Right_Switch_ToRight extends CommandGroup {

    public Right_Switch_ToRight() 
    {
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, 0.5,1.3));
    	addSequential(new MechDistanceGyroDrive(0.005, 0, 0.02,  RobotMap.PERCENTTOLERANCE, 348, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 5));
    	addSequential(new Timeout(0.2));
        addSequential(new RunPIDAction(RobotMap.TURN90LEFTKEY));
    	addSequential(new Timeout(0.2));
    	addSequential((new TimedMechSys(RobotMap.ELEVATORKEY, -0.6, RobotMap.ELEVATORSTAYUPSPEED,1.5)));
    	addSequential(new MechTimedGyroDrive(-0.25, false,  RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 1.5));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, -0.35,2));
    }
}

//addSequential(new MechDistanceGyroDrive(0.0023, 0.00001, 0.01,  RobotMap.PERCENTTOLERANCE, 360 /*506*/, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward));

