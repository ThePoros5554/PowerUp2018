package org.usfirst.frc.team5554.robot.commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import commands.auto.MechSysToLimit;
import commands.auto.MechTimedGyroDrive;
import commands.auto.RunPIDAction;
import commands.auto.TimedMechSys;
import commands.auto.Timeout;
import edu.wpi.first.wpilibj.command.CommandGroup;
import sensors.SysPosition;
import systems.subsystems.MechDriveTrain.MechDrivingDirection;

/**
 *
 */
public class Center_2Cube_Switch_ToRight extends CommandGroup {

    public Center_2Cube_Switch_ToRight() 
    {
    	addSequential(new MechTimedGyroDrive(-0.6, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 0.25));
    	addSequential(new MechDistanceGyroDrive(0.11, 0.0000, 0.1,  5, 115, RobotMap.SIDEENCODER, RobotMap.FORWARDENCODER, RobotMap.FIXGYROKP, 0, RobotMap.FORWARDGYROKP, MechDrivingDirection.Sideways));
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, 0.5,2));
    	addParallel((new TimedMechSys(RobotMap.ELEVATORKEY, -0.7, RobotMap.ELEVATORSTAYUPSPEED, 1.5)));    
    	addSequential(new MechDistanceGyroDrive(0.0042, 0.000065, 0.007,  5, 260, RobotMap.FORWARDENCODER,0, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 2.7));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, -0.5,0.25));
    	addSequential(new Timeout(1));
    	addSequential(new MechDistanceGyroDrive(0.012, 0.000055, 0.1,  5, -165 /*200cm*/, RobotMap.FORWARDENCODER,false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 4));
        addSequential(new RunPIDAction(RobotMap.TURN45LEFTKEY));
    	addSequential(new MechDistanceGyroDrive(0.051, 0.0000, 0.1,  5, 40, RobotMap.SIDEENCODER, RobotMap.FORWARDENCODER, RobotMap.FIXGYROKP, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Sideways, 1));
    	addSequential(new MechSysToLimit(RobotMap.ELEVATORKEY, 0.7, 0, SysPosition.Bottom));
        addParallel(new TimedMechSys(RobotMap.FEEDERKEY, 0.7,RobotMap.AUTOCONSTFEED, 5));
    	addSequential(new MechDistanceGyroDrive(0.015, 0.00005, 0.055,  5, 130 /*200cm*/, RobotMap.FORWARDENCODER,false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 4));
    	addSequential(new Timeout(0.4));
    	addSequential(new MechDistanceGyroDrive(0.015, 0.00005, 0.055,  5, -130 /*200cm*/, RobotMap.FORWARDENCODER,false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 4));
    	addSequential(new MechDistanceGyroDrive(0.051, 0.0000, 0.1,  5, -40, RobotMap.SIDEENCODER, RobotMap.FORWARDENCODER, RobotMap.FIXGYROKP, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Sideways, 1));
        addSequential(new RunPIDAction(RobotMap.TURN45RIGHTKEY));
    	addParallel((new TimedMechSys(RobotMap.ELEVATORKEY, -0.7, RobotMap.ELEVATORSTAYUPSPEED, 1.5)));    
    	addSequential(new MechTimedGyroDrive(-0.5, false,  RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 1));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, -0.4,0.75)); 
    }
}
