package org.usfirst.frc.team5554.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import systems.RobotManager;
import systems.subsystems.DiffDriveTrain;

/**
 *
 */
public class TestAutonomus extends Command {
	
	DiffDriveTrain testAuto;

    public TestAutonomus() 
    {
    	super("Timeout" , 3);	
    	testAuto = (DiffDriveTrain)RobotManager.GetDriveTrain();
    	requires(testAuto);
    }

    protected void initialize() 
    {
    }
    
    protected void execute()
    {
    	testAuto.ArcadeDrive(0.2, 0);
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

    protected void end() 
    {
    	testAuto.ArcadeDrive(0, 0);
    }

    protected void interrupted() {
    }
}
