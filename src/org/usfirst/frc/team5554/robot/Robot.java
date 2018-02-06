/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5554.robot;
import org.usfirst.frc.team5554.robot.commands.empty;

import commands.DriveMechanum;
import commands.auto.TimedGyroDrive;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import systems.RobotManager;
import systems.subsystems.MechDriveTrain;
import systems.subsystems.MechDriveTrain.MechDriveTypes;
import systems.subsystems.MechSys;

public class Robot extends TimedRobot 
{
	private MechSys elevator;
	private MechSys rightRamp;
	private MechSys climb;
	private MechSys leftRamp;
	private MechSys feederAxis;
	private MechSys feeder;

	private Victor rearRightMotor;
	private Victor frontRightMotor;
	private Victor rearLeftMotor;
	private Victor frontLeftMotor;

	private ADXRS450_Gyro gyro;
	
	private Command LLautonomusCommand;
	private Command LRautonomusCommand;
	private Command RLautonomusCommand;
	private Command RRautonomusCommand;
	
	private SendableChooser<Command> LLautoChooser = new SendableChooser<Command>();
	private SendableChooser<Command> LRautoChooser = new SendableChooser<Command>();
	private SendableChooser<Command> RLautoChooser = new SendableChooser<Command>();
	private SendableChooser<Command> RRautoChooser = new SendableChooser<Command>();
	
	double teleopStartTime;

	@Override
	public void robotInit() 
	{
		this.elevator = new MechSys(RobotMap.ELEVATORPORT);
		this.rightRamp = new MechSys(RobotMap.RIGHTRAMPPORT);
		this.climb = new MechSys(RobotMap.CLIMBPORT);
		this.leftRamp = new MechSys(RobotMap.LEFTRAMPPORT);
		this.feederAxis = new MechSys(RobotMap.FEEDERAXISPORT);
		this.feeder = new MechSys(RobotMap.FEEDERPORT);
		
		this.frontLeftMotor = new Victor(RobotMap.FRONTLEFTMOTORPORT);
		this.rearLeftMotor = new Victor(RobotMap.REARLEFTMOTORPORT);
		this.frontRightMotor = new Victor(RobotMap.FRONTRIGHTMOTORPORT);
		this.rearRightMotor = new Victor(RobotMap.REARRIGHTMOTORPORT);
		this.gyro = new ADXRS450_Gyro(RobotMap.GYRO_PORT);
		
		RobotManager.AddSubsystem(RobotMap.ELEVATORKEY, this.elevator);
		RobotManager.AddSubsystem(RobotMap.RIGHTRAMPKEY, this.rightRamp);
		RobotManager.AddSubsystem(RobotMap.CLIMBKEY, this.climb);
		RobotManager.AddSubsystem(RobotMap.LEFTRAMPKEY, this.leftRamp);
		RobotManager.AddSubsystem(RobotMap.FEEDERAXISKEY, this.feederAxis);
		RobotManager.AddSubsystem(RobotMap.FEEDERKEY, this.feeder);
		
		RobotManager.AddSpeed(RobotMap.ELEVATORKEY, (double) 0);
		RobotManager.AddSpeed(RobotMap.RIGHTRAMPKEY, (double) 0);
		RobotManager.AddSpeed(RobotMap.CLIMBKEY, (double) 0);
		RobotManager.AddSpeed(RobotMap.LEFTRAMPKEY, (double) 0);
		RobotManager.AddSpeed(RobotMap.FEEDERAXISKEY, (double) 0);
		RobotManager.AddSpeed(RobotMap.FEEDERKEY, (double) 0);
		RobotManager.AddSpeed(RobotMap.TGDS_LEFTAUTONOMUS, 0.5);
		RobotManager.AddSpeed("gyroSpeed", 0.5);
		RobotManager.AddSpeed("gyroSpeedB", -0.5);
		
		RobotManager.SetDriveJoy(0);
		
		RobotManager.SetDriveTrain(this.frontLeftMotor,  this.rearLeftMotor, this.frontRightMotor,  this.rearRightMotor, MechDriveTypes.CartesianDrive);
		RobotManager.SetSpeedAxis(RobotMap.SPEEDAXIS);
		RobotManager.SetRotateAxis(RobotMap.ROTATEAXIS);
		RobotManager.SetTwistAxis(RobotMap.TWISTAXIS);
		RobotManager.GetDriveTrain().SetMinSpeedValue(0.1);
		RobotManager.GetDriveTrain().SetMinRotateValue(0.1);
		((MechDriveTrain) RobotManager.GetDriveTrain()).SetMinTwistValue(0.15);
		
		((MechDriveTrain) RobotManager.GetDriveTrain()).SetMaxOutput(0.5);

		gyro = new ADXRS450_Gyro(RobotMap.GYRO_PORT);
		RobotManager.SetGyro(this.gyro);
		
		OI oi = new OI();
		
		LLautoChooser.addDefault("Empty", new empty());
		LRautoChooser.addDefault("Empty", new empty());
		RLautoChooser.addDefault("Empty", new empty());
		RRautoChooser.addDefault("Empty", new empty());
		
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
			SmartDashboard.putBoolean("GameEnding", true);
		}
		Scheduler.getInstance().run();;
	}

	@Override
	public void testPeriodic() 
	{
	}
}
