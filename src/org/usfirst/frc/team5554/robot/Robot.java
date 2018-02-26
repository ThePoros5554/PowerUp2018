/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import systems.PIDAction;
import systems.RobotManager;
import systems.subsystems.MechDriveTrain;
import systems.subsystems.MechDriveTrain.MechDriveTypes;
import systems.subsystems.MechDriveTrain.MechPidAction;
import systems.subsystems.MechSys;

public class Robot extends TimedRobot 
{
	private MechSys elevator;
	private MechSys feederAxis;
	private MechSys climb;
	private MechSys feeder;

	private Victor rearRightMotor;
	private Victor frontRightMotor;
	private Victor rearLeftMotor;
	private Victor frontLeftMotor;
	
//	private Potentiometer pot;

	private ADXRS450_Gyro gyro;
	
	private double teleopStartTime;

	private OI oi;
	
	private AutonomusChooser autoChooser;
	private CommandGroup autoSelected;
	private String gameData;

	@Override
	public void robotInit() 
	{
		this.elevator = new MechSys(RobotMap.ELEVATORPORT);
		this.elevator.SetIsLookedReversed(true);
		this.climb = new MechSys(RobotMap.RIGHTCLIBPORT, RobotMap.LEFTCLIMBPORT);
		this.feederAxis = new MechSys(RobotMap.FEEDERAXISPORT);
		this.feeder = new MechSys(RobotMap.RIGHTFEEDERPORT, RobotMap.LEFTFEEDERPORT);
		
		this.frontLeftMotor = new Victor(RobotMap.FRONTLEFTMOTORPORT);
		this.rearLeftMotor = new Victor(RobotMap.REARLEFTMOTORPORT);
		this.frontRightMotor = new Victor(RobotMap.FRONTRIGHTMOTORPORT);
		this.rearRightMotor = new Victor(RobotMap.REARRIGHTMOTORPORT);
		this.gyro = new ADXRS450_Gyro(RobotMap.GYRO_PORT);
		
		RobotManager.AddSubsystem(RobotMap.ELEVATORKEY, this.elevator);
		RobotManager.AddSubsystem(RobotMap.FEEDERAXISKEY, this.feederAxis);
		RobotManager.AddSubsystem(RobotMap.CLIMBKEY, this.climb);
		RobotManager.AddSubsystem(RobotMap.FEEDERKEY, this.feeder);
		
		RobotManager.AddSpeed(RobotMap.ELEVATORUPSPEED, (double) -0.8);
		RobotManager.AddSpeed(RobotMap.ELEVATORDOWNSPEED, (double) 0.8);
		RobotManager.AddSpeed(RobotMap.FEEDERAXISUPSPEED, (double) 0.8);
		RobotManager.AddSpeed(RobotMap.FEEDERAXISDOWNSPEED, (double) -0.8);
		RobotManager.AddSpeed(RobotMap.FEEDERINKEY, (double) -0.8);
		RobotManager.AddSpeed(RobotMap.FEEDEROUTKEY, (double) 0.8);
		RobotManager.AddSpeed(RobotMap.CLIMBUPKEY, (double) -0.8);
		RobotManager.AddSpeed(RobotMap.CLIMBDOWNKEY, (double) 0.8);
		RobotManager.AddSpeed(RobotMap.TGDS_LEFTAUTONOMUS, 0.5);
				
		RobotManager.SetDriveJoy(0);
		RobotManager.SetSystemsJoy(1);
		
		RobotManager.SetGyro(this.gyro);
		
		RobotManager.SetDriveTrain(this.frontLeftMotor,  this.rearLeftMotor, this.frontRightMotor,  this.rearRightMotor, MechDriveTypes.CartesianDrive);
		RobotManager.SetSpeedAxis(RobotMap.SPEEDAXIS);
		RobotManager.SetRotateAxis(RobotMap.ROTATEAXIS);
		RobotManager.SetTwistAxis(RobotMap.TWISTAXIS);
		RobotManager.GetDriveTrain().SetMinSpeedValue(0.1);
		RobotManager.GetDriveTrain().SetMinRotateValue(0.1);
		((MechDriveTrain) RobotManager.GetDriveTrain()).SetMinTwistValue(0.15);	
		RobotManager.GetDriveTrain().SetIsReversed(false);
		
		RobotMap.FORWARDENCODER.setDistancePerPulse(RobotMap.ENCODERDISTANCEPERPULSE);
		RobotMap.SIDEENCODER.setDistancePerPulse(RobotMap.ENCODERDISTANCEPERPULSE);
		
//		pot = new AnalogPotentiometer(3, 1000000);
		
		this.elevator.SetLimitSwitch(RobotMap.ELEVATORSWITCHES);

		this.oi = new OI();
		
		((MechDriveTrain) RobotManager.GetDriveTrain()).SetPIDOutput(MechPidAction.PidTurnInPlace);
    	PIDAction turn30Right = new PIDAction(RobotMap.TURN30P, RobotMap.TURN30I, RobotMap.TURN30D, (PIDSource) RobotManager.GetGyro(), (MechDriveTrain)RobotManager.GetDriveTrain());
    	turn30Right.SetInputRange(0, 30);
    	turn30Right.SetSetPoint(30);
    	turn30Right.SetPercentTolerance(5);
    	RobotManager.AddPIDAction(RobotMap.TURN30RIGHTKEY, turn30Right);
    	
    	PIDAction turn30Left = new PIDAction(RobotMap.TURN30P, RobotMap.TURN30I, RobotMap.TURN30D, (PIDSource) RobotManager.GetGyro(), (MechDriveTrain)RobotManager.GetDriveTrain());
    	turn30Left.SetInputRange(-30, 0);
    	turn30Left.SetSetPoint(-30);
    	turn30Left.SetPercentTolerance(5);
    	RobotManager.AddPIDAction(RobotMap.TURN30LEFTKEY, turn30Left);
    	
    	PIDAction turn90Right = new PIDAction(RobotMap.TURN90P, RobotMap.TURN90I, RobotMap.TURN90D, (PIDSource) RobotManager.GetGyro(), (MechDriveTrain)RobotManager.GetDriveTrain());
    	turn90Right.SetInputRange(0, 90);
    	turn90Right.SetSetPoint(90);
    	turn90Right.SetPercentTolerance(5);
    	RobotManager.AddPIDAction(RobotMap.TURN90RIGHTKEY, turn90Right);
    	
    	PIDAction turn90Left = new PIDAction(RobotMap.TURN90P, RobotMap.TURN90I, RobotMap.TURN90D, (PIDSource) RobotManager.GetGyro(), (MechDriveTrain)RobotManager.GetDriveTrain());
    	turn90Left.SetInputRange(-90,0);
    	turn90Left.SetSetPoint(-90);
    	turn90Left.SetPercentTolerance(5);
    	RobotManager.AddPIDAction(RobotMap.TURN90LEFTKEY, turn90Left);
    	
		autoChooser = new AutonomusChooser();
		
		gameData =  DriverStation.getInstance().getGameSpecificMessage();
		
		SmartDashboard.putBoolean("GameEnding", false);	
		

	}

	@Override
	public void disabledInit() 
	{
		RobotManager.GetDriveTrain().SetIsRanged(false);

		if(this.autoSelected != null)
		{
			this.autoSelected.cancel();
		}
	}

	@Override
	public void disabledPeriodic() 
	{
	}

	@Override
	public void autonomousInit() 
	{	    	
		RobotManager.GetDriveTrain().SetMaxOutput(1);
		
		if (gameData.charAt(0) == 'L')
		{
			if (gameData.charAt(1) == 'L')
			{
				autoSelected = (CommandGroup) autoChooser.LLGetSelected();
			}
			if (gameData.charAt(1) == 'R')
			{
				autoSelected = (CommandGroup) autoChooser.LRGetSelected();
			}
		}
		else if (gameData.charAt(0) == 'R')
		{
			if (gameData.charAt(1) == 'L')
			{
				autoSelected = (CommandGroup) autoChooser.RLGetSelected();
			}
			if (gameData.charAt(1) == 'R')
			{
				autoSelected = (CommandGroup) autoChooser.RRGetSelected();
			}
			
		}
		autoSelected.start();
	}

	@Override
	public void autonomousPeriodic() 
	{	
		Scheduler.getInstance().run();

		System.out.println("Forqard:  " + RobotMap.FORWARDENCODER.getDistance());
//		System.out.println(gyro.getAngle());
//		System.out.println("Side:    " + RobotMap.SIDEENCODER.getDistance());

	}

	

	@Override
	public void teleopInit() 
	{
		if(this.autoSelected != null)
		{
			this.autoSelected.cancel();
		}
		this.teleopStartTime = RobotController.getFPGATime();
		SmartDashboard.putBoolean("GameEnding", false);
		
		RobotManager.setRanged(3, 1, -1, true);
	}

	@Override
	public void teleopPeriodic() 
	{
		if(RobotController.getFPGATime() - teleopStartTime > 105000000)
		{
			SmartDashboard.putBoolean("GameEnding", true);
		}
		Scheduler.getInstance().run();
		
		System.out.println("aaa: " + gyro.getAngle());
		
//		System.out.println("bottom   " + RobotMap.ELEVATORBOTTOM.GetPosition());
//		System.out.println("top   " + RobotMap.ELEVATORTOP.GetPosition());
//		System.out.println("dasdasd  " + RobotMap.ELEVATORSWITCHES.GetPosition());
	}

	@Override
	public void testPeriodic() 
	{
	}
}
