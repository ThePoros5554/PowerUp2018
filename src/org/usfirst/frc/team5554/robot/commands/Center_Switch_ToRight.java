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
public class Center_Switch_ToRight extends CommandGroup {

    public Center_Switch_ToRight() 
    {
    	addSequential(new MechTimedGyroDrive(-0.5, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 0.4));
    	addSequential(new MechDistanceGyroDrive(0.09, 0.0000, 0.1,  5, 115, RobotMap.SIDEENCODER, RobotMap.FORWARDENCODER, RobotMap.FIXGYROKP, 0, RobotMap.FORWARDGYROKP, MechDrivingDirection.Sideways));
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, 0.5,2));
    	addParallel((new TimedMechSys(RobotMap.ELEVATORKEY, -0.7, RobotMap.ELEVATORSTAYUPSPEED, 1.5)));    
    	addSequential(new MechTimedGyroDrive(-0.36, 0.0,  RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 2.3));
    	addSequential(new Timeout(0.5));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, -0.35,2));   

    	
    	
// 		///////////////////////////9090909090909090909090909090909090990///////////////////////////////////////////   	
//    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, 0.25,2.3));
//    	addSequential(new MechDistanceGyroDrive(0.0035, 0.000042, 0.007,  5, 105, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward,4));
//    	addSequential(new Timeout(0.2));
//        addSequential(new RunPIDAction(RobotMap.TURN90RIGHTKEY));
//    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, 0.5,0.3));
//    	addSequential(new MechDistanceGyroDrive(0.003, 0.000035, 0.007,  5, 135, RobotMap.FORWARDENCODER,false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward));
//    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, 0.5,0.3));
//        addSequential(new RunPIDAction(RobotMap.TURN90LEFTKEY));
//    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, 0.5,0.3));
//    	addParallel((new TimedMechSys(RobotMap.ELEVATORKEY, -0.7, RobotMap.ELEVATORSTAYUPSPEED, 1.5)));    
//    	addSequential(new Timeout(0.2));
//    	addSequential(new MechDistanceGyroDrive(0.003, 0.000065, 0.007,  5, 170, RobotMap.FORWARDENCODER,false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward, 2.7));
//    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, -0.35,2));   
    	
    	
    }
}
