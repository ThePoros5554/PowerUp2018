/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5554.robot;
import org.usfirst.frc.team5554.robot.commands.CenterAutonomus;
import org.usfirst.frc.team5554.robot.commands.LeftAutonomus;
import org.usfirst.frc.team5554.robot.commands.RightAutonomus;
import org.usfirst.frc.team5554.robot.commands.empty;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import systems.RobotManager;
import systems.subsystems.MechSys;

public class Robot extends TimedRobot 
{
	MechSys climb;
	MechSys elevator;
	MechSys feeder;

	
	private Command autonomusCommand;
	private SendableChooser<Command> autoChooser = new SendableChooser<Command>();;
	@Override
	public void robotInit() 
	{
		climb = new MechSys(RobotMap.CLIMB);
		elevator = new MechSys(RobotMap.ELEVATOR);
		feeder = new MechSys(RobotMap.FEEDER);
		RobotManager.AddSubsystem(RobotMap.CLIMBKEY, climb);
		RobotManager.AddSubsystem(RobotMap.ELEVATORKEY, elevator);
		RobotManager.AddSubsystem(RobotMap.FEEDERKEY, feeder);
		RobotManager.AddSpeed(RobotMap.CLIMBKEY, (double) 0);
		RobotManager.AddSpeed(RobotMap.ELEVATORKEY, (double) 0.5);
		RobotManager.AddSpeed(RobotMap.FEEDERKEY, (double) 0);
		RobotManager.AddSpeed(RobotMap.TGDS_LEFTAUTONOMUS, 0.3);
		RobotManager.SetDriveJoy(0);
		RobotManager.SetDriveTrain(new Victor(0), new Victor(1));
		RobotManager.SetGyro(new ADXRS450_Gyro(RobotMap.GYRO_PORT));
		OI oi = new OI();
		
		autoChooser.addDefault("Empty", new empty());
		autoChooser.addObject("LeftAutonomus", new LeftAutonomus());
		autoChooser.addObject("CenterAutonomus", new CenterAutonomus());
		autoChooser.addObject("RightAutonomus", new RightAutonomus());
		SmartDashboard.putData("Autonomus chooser", autoChooser);
	}

	@Override
	public void disabledInit() 
	{
	}

	@Override
	public void disabledPeriodic() 
	{
	}

	@Override
	public void autonomousInit() 
	{
		autonomusCommand = autoChooser.getSelected();
		autonomusCommand.start();
	}

	@Override
	public void autonomousPeriodic() 
	{
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() 
	{
	}

	@Override
	public void teleopPeriodic() 
	{
	}

	@Override
	public void testPeriodic() 
	{
	}
}
