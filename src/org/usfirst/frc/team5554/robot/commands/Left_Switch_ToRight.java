package org.usfirst.frc.team5554.robot.commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import commands.auto.RunPIDAction;
import commands.auto.TimedMechSys;
import commands.auto.Timeout;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import systems.subsystems.MechDriveTrain.MechDrivingDirection;


public class Left_Switch_ToRight extends CommandGroup {

    public Left_Switch_ToRight()
    {
    	addSequential(new MechDistanceGyroDrive(0.00275, 0, 0.008,  RobotMap.PERCENTTOLERANCE, 560, RobotMap.FORWARDENCODER, false, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward));
    	addParallel(new TimedMechSys(RobotMap.FEEDERKEY, 0.5,0.3));
        addSequential(new RunPIDAction(RobotMap.TURN90RIGHTKEY));
    	addParallel(new TimedMechSys(RobotMap.FEEDERKEY, 0.5,0.3));
    	addParallel(new TimedMechSys(RobotMap.FEEDERAXISKEY, 0.25, 2));
    	addSequential(new MechDistanceGyroDrive(0.0029, 0, 0.008,  RobotMap.PERCENTTOLERANCE, 575, RobotMap.FORWARDENCODER, 90, RobotMap.FORWARDGYROKP, MechDrivingDirection.Forward));
    	addParallel(new TimedMechSys(RobotMap.FEEDERKEY, 0.5,0.3));
        addSequential(new RunPIDAction(RobotMap.TURN90RIGHTKEY));
        addParallel(new TimedMechSys(RobotMap.FEEDERKEY, 0.5,0.3));
        addParallel((new TimedMechSys(RobotMap.ELEVATORKEY, -0.65, RobotMap.ELEVATORSTAYUPSPEED,1.5)));
    	addSequential(new MechDistanceGyroDrive(0.0025, 0.000028, 0.0065,  5, 125, RobotMap.FORWARDENCODER,140, 0.005, MechDrivingDirection.Forward, 1.5));
    	addSequential(new TimedMechSys(RobotMap.FEEDERKEY, -0.5,3));  
    }
}
