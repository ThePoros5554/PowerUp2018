package org.usfirst.frc.team5554.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import systems.subsystems.MechSys;

/**
 *
 */
public class TestAutonomus extends Command {
	
	MechSys test;

    public TestAutonomus() 
    {
    	super("Timeout" , 1);
    	test = new MechSys(4);
    }

    protected void initialize() 
    {
    	test.Activate(0.5);
    }
    
    protected void execute()
    {
    }

    protected boolean isFinished() 
    {
    	if (isTimedOut())
    	{
    		return true;
    	}
    	else
    	{
            return false;
    	}
    }

    protected void end() {
    	test.Activate(0);
    }

    protected void interrupted() {
    }
}
