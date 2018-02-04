package org.usfirst.frc.team5554.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import systems.RobotManager;
import systems.subsystems.MechDriveTrain;

/**
 *
 */
public class TestAutonomus extends Command {
	
	MechDriveTrain testAuto;

    public TestAutonomus() 
    {
    	super("Timeout" , 3);	
    	testAuto = (MechDriveTrain)RobotManager.GetDriveTrain();
    	requires(testAuto);
    }

    protected void initialize() 
    {
    }
    
    protected void execute()
    {
    	testAuto.MecanumDrive(0.5, 0, 0);
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
    	testAuto.MecanumDrive(0, 0, 0);
    }

    protected void interrupted() {
    }
}
