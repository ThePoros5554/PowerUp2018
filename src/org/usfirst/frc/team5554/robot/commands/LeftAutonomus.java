package org.usfirst.frc.team5554.robot.commands;

import org.usfirst.frc.team5554.robot.RobotMap;

import commands.ActivateMechSys;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;
import systems.RobotManager;

/**
 *
 */

public class LeftAutonomus extends CommandGroup 
{
    public LeftAutonomus() 
    {
    	String gamedata;
    	gamedata = DriverStation.getInstance().getGameSpecificMessage();
    	if(gamedata.charAt(0) == 'L')
    	{
    		if(gamedata.charAt(1) == 'L')
    		{
    			LL();	
    		}
    		else if(gamedata.charAt(1) == 'R')
    		{
    			LR();
    		}
    		else
    		{
    			Null();
    		}
    	}
    	else if(gamedata.charAt(0) == 'R')
    	{
    		if(gamedata.charAt(1) == 'L')
    		{
    			RL();
    		}
    		else if(gamedata.charAt(1) == 'R')
    		{
    			RR();
    		}
    		else
    		{
    			Null();
    		}
    	}
    	else 
    	{
    		Null();
    	}
    }
    
   	public void LL()
    {
   		addSequential(new TimedGyroDrive("TGDS_LeftAutonomus", 0.03, 5));
	   	//addParallel(command);
    }
    public void LR()
    {
	   	//addSequential(new command());
	   	//addParallel(command);
    }
    public void RL()
    {
	   	//addSequential(new command());
	   	//addParallel(command);
    }
    public void RR()
    {
	   	//addSequential(new command());
	   	//addParallel(command);
    }
    public void Null()
    {
    	//addSequential(new command());
	   	//addParallel(command);
    }
}