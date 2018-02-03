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
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import systems.RobotManager;
import systems.subsystems.MechDriveTrain.MechDriveTypes;
import systems.subsystems.MechSys;

public class Robot extends TimedRobot 
{
	private MechSys climb;
	private MechSys elevator;
	private MechSys feeder;

	private Victor frontLeftMotor;
	private Victor rearLeftMotor;
	private Victor frontRightMotor;
	private Victor rearRightMotor;

	private ADXRS450_Gyro gyro;
	
	private Command autonomusCommand;
	private SendableChooser<Command> autoChooser = new SendableChooser<Command>();;
	double teleopStartTime;
	
	@Override
	public void robotInit() 
	{
		this.climb = new MechSys(RobotMap.CLIMBPORT);
		this.elevator = new MechSys(RobotMap.ELEVATORPORT);
		this.feeder = new MechSys(RobotMap.FEEDERPORT);
		
		this.frontLeftMotor = new Victor(RobotMap.FRONTLEFTMOTORPORT);
		this.rearLeftMotor = new Victor(RobotMap.REARLEFTMOTORPORT);
		this.frontRightMotor = new Victor(RobotMap.FRONTRIGHTMOTORPORT);
		this.rearRightMotor = new Victor(RobotMap.REARRIGHTMOTORPORT);
		
		this.gyro = new ADXRS450_Gyro(RobotMap.GYRO_PORT);
		
		RobotManager.AddSubsystem(RobotMap.CLIMBKEY, this.climb);
		RobotManager.AddSubsystem(RobotMap.ELEVATORKEY, this.elevator);
		RobotManager.AddSubsystem(RobotMap.FEEDERKEY, this.feeder);
		
		RobotManager.AddSpeed(RobotMap.CLIMBKEY, (double) 0);
		RobotManager.AddSpeed(RobotMap.ELEVATORKEY, (double) 0.5);
		RobotManager.AddSpeed(RobotMap.FEEDERKEY, (double) 0);
		RobotManager.AddSpeed(RobotMap.TGDS_LEFTAUTONOMUS, 0.3);
		
		RobotManager.SetDriveJoy(0);
		
		RobotManager.SetDriveTrain(this.frontLeftMotor,  this.rearLeftMotor, this.frontRightMotor,  this.rearRightMotor, MechDriveTypes.CartesianDrive);
		
		RobotManager.SetGyro(this.gyro);
		
		OI oi = new OI();
		
		autoChooser.addDefault("Empty", new empty());
		autoChooser.addObject("LeftAutonomus", new LeftAutonomus());
		autoChooser.addObject("CenterAutonomus", new CenterAutonomus());
		autoChooser.addObject("RightAutonomus", new RightAutonomus());
		SmartDashboard.putData("Autonomus chooser", autoChooser);
		SmartDashboard.putBoolean("GameEnding", false);
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
		this.autonomusCommand = autoChooser.getSelected();
		this.autonomusCommand.start();
	}

	@Override
	public void autonomousPeriodic() 
	{
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() 
	{
		this.teleopStartTime = RobotController.getFPGATime();
		SmartDashboard.putBoolean("GameEnding", false);
	}

	@Override
	public void teleopPeriodic() 
	{
		if(RobotController.getFPGATime() - teleopStartTime > 105000000)
		{
			System.out.println("timeeeeeeeeeeeeeeeeeee");
			SmartDashboard.putBoolean("GameEnding", true);
		}
	}

	@Override
	public void testPeriodic() 
	{
	}
}
