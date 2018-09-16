/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
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
	
	private CameraThread streamer;
//	private Potentiometer pot;

	private ADXRS450_Gyro gyro;
	
	private OI oi;
	
	private AutonomusChooser autoChooser;
	private CommandGroup autoSelected;
	private String gameData;
	
	private int start_time;
	private int current_time;
	private int full_game = 135; 

	@Override
	public void robotInit() 
	{
		this.elevator = new MechSys(RobotMap.ELEVATORPORT);
		this.climb = new MechSys(RobotMap.CLIMBPORT);
		this.feederAxis = new MechSys(RobotMap.FEEDERAXISPORT);
		this.feeder = new MechSys(RobotMap.FEEDERPORT);
		
		this.elevator.SetIsLookedReversed(true);
		this.feederAxis.SetIsLookedReversed(true);
		
		this.frontLeftMotor = new Victor(RobotMap.FRONTLEFTMOTORPORT);
		this.rearLeftMotor = new Victor(RobotMap.REARLEFTMOTORPORT);
		this.frontRightMotor = new Victor(RobotMap.FRONTRIGHTMOTORPORT);
		this.rearRightMotor = new Victor(RobotMap.REARRIGHTMOTORPORT);
		this.gyro = new ADXRS450_Gyro(RobotMap.GYRO_PORT);
		
		RobotManager.AddSubsystem(RobotMap.ELEVATORKEY, this.elevator);
		RobotManager.AddSubsystem(RobotMap.FEEDERAXISKEY, this.feederAxis);
		RobotManager.AddSubsystem(RobotMap.CLIMBKEY, this.climb);
		RobotManager.AddSubsystem(RobotMap.FEEDERKEY, this.feeder);
				
		RobotManager.SetDriveJoy(0);
		RobotManager.SetSystemsJoy(1);
		
		RobotManager.SetGyro(this.gyro);
		
		RobotManager.SetDriveTrain(this.frontLeftMotor,  this.rearLeftMotor, this.frontRightMotor,  this.rearRightMotor, MechDriveTypes.CartesianDrive);
		RobotManager.SetSpeedAxis(RobotMap.SPEEDAXIS);
		RobotManager.SetRotateAxis(RobotMap.ROTATEAXIS);
		RobotManager.SetTwistAxis(RobotMap.TWISTAXIS);
		RobotManager.GetDriveTrain().SetIsReversed(false);
		RobotMap.FORWARDENCODER.setDistancePerPulse(RobotMap.ENCODERFORWARDDISTANCEPERPULSE);
		RobotMap.SIDEENCODER.setDistancePerPulse(RobotMap.ENCODERSIDEDISTANCEPERPULSE);
		
//		pot = new AnalogPotentiometer(3, 1000000);
		
		this.elevator.SetLimitSwitch(RobotMap.ELEVATORSWITCHES);
		this.climb.SetLimitSwitch(RobotMap.CLIMBTOPSWITCH);
		this.feeder.SetLimitSwitch(RobotMap.FEEDERSWITCH);
		this.feederAxis.SetLimitSwitch(RobotMap.FEEDERAXISSWITCH);

		this.oi = new OI();
		
		((MechDriveTrain) RobotManager.GetDriveTrain()).SetPIDOutput(MechPidAction.PidTurnInPlace);
    	PIDAction turn30Right = new PIDAction(RobotMap.TURN30P, RobotMap.TURN30I, RobotMap.TURN30D, (PIDSource) RobotManager.GetGyro(), (MechDriveTrain)RobotManager.GetDriveTrain());
    	turn30Right.SetInputRange(0, 37.5);
    	turn30Right.SetSetPoint(37.5);
    	turn30Right.SetPercentTolerance(5);
    	RobotManager.AddPIDAction(RobotMap.TURN30RIGHTKEY, turn30Right);
    	
    	PIDAction turn30Left = new PIDAction(RobotMap.TURN30P, RobotMap.TURN30I, RobotMap.TURN30D, (PIDSource) RobotManager.GetGyro(), (MechDriveTrain)RobotManager.GetDriveTrain());
    	turn30Left.SetInputRange(-37.5, 0);
    	turn30Left.SetSetPoint(-37.5);
    	turn30Left.SetPercentTolerance(5);
    	RobotManager.AddPIDAction(RobotMap.TURN30LEFTKEY, turn30Left);
    	
    	PIDAction turn90Right = new PIDAction(RobotMap.TURN90P, RobotMap.TURN90I, RobotMap.TURN90D, (PIDSource) RobotManager.GetGyro(), (MechDriveTrain)RobotManager.GetDriveTrain());
    	turn90Right.SetInputRange(0, 88);
    	turn90Right.SetSetPoint(88);
    	turn90Right.SetPercentTolerance(5);
    	RobotManager.AddPIDAction(RobotMap.TURN90RIGHTKEY, turn90Right);
    	
    	PIDAction turn90Left = new PIDAction(RobotMap.TURN90P, RobotMap.TURN90I, RobotMap.TURN90D, (PIDSource) RobotManager.GetGyro(), (MechDriveTrain)RobotManager.GetDriveTrain());
    	turn90Left.SetInputRange(-88,0);
    	turn90Left.SetSetPoint(-88);
    	turn90Left.SetPercentTolerance(5);
    	RobotManager.AddPIDAction(RobotMap.TURN90LEFTKEY, turn90Left);
    	
    	PIDAction turn120Right = new PIDAction(RobotMap.TURN100P, RobotMap.TURN100I, RobotMap.TURN100D, (PIDSource) RobotManager.GetGyro(), (MechDriveTrain)RobotManager.GetDriveTrain());
    	turn120Right.SetInputRange(0, 117.5);
    	turn120Right.SetSetPoint(117.5);
    	turn120Right.SetPercentTolerance(5);
    	RobotManager.AddPIDAction(RobotMap.TURN120RIGHTKEY, turn120Right);
    	
    	PIDAction turn120Left = new PIDAction(RobotMap.TURN100P, RobotMap.TURN100I, RobotMap.TURN100D, (PIDSource) RobotManager.GetGyro(), (MechDriveTrain)RobotManager.GetDriveTrain());
    	turn120Left.SetInputRange(-117.5,0);
    	turn120Left.SetSetPoint(-117.5);
    	turn120Left.SetPercentTolerance(5);
    	RobotManager.AddPIDAction(RobotMap.TURN120LEFTKEY, turn120Left);
    	
    	PIDAction turn150Right = new PIDAction(RobotMap.TURN150P, RobotMap.TURN150I, RobotMap.TURN150D, (PIDSource) RobotManager.GetGyro(), (MechDriveTrain)RobotManager.GetDriveTrain());
    	turn150Right.SetInputRange(0, 136);
    	turn150Right.SetSetPoint(136);
    	turn150Right.SetPercentTolerance(5);
    	RobotManager.AddPIDAction(RobotMap.TURN150RIGHTKEY, turn150Right);
    	
    	PIDAction turn150Left = new PIDAction(RobotMap.TURN150P, RobotMap.TURN150I, RobotMap.TURN150D, (PIDSource) RobotManager.GetGyro(), (MechDriveTrain)RobotManager.GetDriveTrain());
    	turn150Left.SetInputRange(-136,0);
    	turn150Left.SetSetPoint(-136);
    	turn150Left.SetPercentTolerance(5);
    	RobotManager.AddPIDAction(RobotMap.TURN150LEFTKEY, turn150Left);
    	
    	PIDAction turn45Right = new PIDAction(RobotMap.TURN45P, RobotMap.TURN45I, RobotMap.TURN45D, (PIDSource) RobotManager.GetGyro(), (MechDriveTrain)RobotManager.GetDriveTrain());
    	turn45Right.SetInputRange(0, 35);
    	turn45Right.SetSetPoint(35);
    	turn45Right.SetPercentTolerance(5);
    	RobotManager.AddPIDAction(RobotMap.TURN45RIGHTKEY, turn45Right);
    	
    	PIDAction turn45Left = new PIDAction(RobotMap.TURN45P, RobotMap.TURN45I, RobotMap.TURN45D, (PIDSource) RobotManager.GetGyro(), (MechDriveTrain)RobotManager.GetDriveTrain());
    	turn45Left.SetInputRange(-35,0);
    	turn45Left.SetSetPoint(-35);
    	turn45Left.SetPercentTolerance(5);
    	RobotManager.AddPIDAction(RobotMap.TURN45LEFTKEY, turn45Left);
    	
		autoChooser = new AutonomusChooser();

		streamer = new CameraThread(RobotManager.GetDriveJoy());
		streamer.setDaemon(true);
		streamer.start();
		
	}

	@Override
	public void disabledInit() 
	{
		RobotManager.GetDriveTrain().SetIsRanged(false);

		if(this.autoSelected != null)
		{
			this.autoSelected.cancel();
		}
		
		SmartDashboard.putBoolean("End Game", false);
		SmartDashboard.putNumber("game time", 0);

	}

	@Override
	public void disabledPeriodic() 
	{
		SmartDashboard.putNumber("Gyro ", RobotManager.GetGyro().getAngle());
	}

	@Override
	public void autonomousInit() 
	{	    	
		((MechSys)RobotManager.GetSubsystem(RobotMap.CLIMBKEY)).Activate(0);
		RobotManager.GetDriveTrain().SetMaxOutput(1);
		RobotManager.GetGyro().reset();
		gameData =  DriverStation.getInstance().getGameSpecificMessage();
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

//		System.out.println("Forward:  " + RobotMap.FORWARDENCODER.getDistance());
		System.out.println(gyro.getAngle());
//		System.out.println("Side:    " + RobotMap.SIDEENCODER.getDistance());

		if((full_game - (current_time - start_time)/1000000 > 0))
		{
			Long fpgaTime = RobotController.getFPGATime();
			this.current_time = fpgaTime.intValue();
			SmartDashboard.putNumber("game time", full_game - ((current_time  - start_time) / 1000000));
		}
	}

	

	@Override
	public void teleopInit() 
	{
		((MechSys)RobotManager.GetSubsystem(RobotMap.CLIMBKEY)).Activate(0);

		if(this.autoSelected != null)
		{
			this.autoSelected.cancel();
		}
		
		RobotManager.setRanged(3, 1, -1, true);
		
		RobotManager.GetGyro().reset();

		
		RobotMap.FORWARDENCODER.reset();
		RobotMap.SIDEENCODER.reset();

		
		Long fpgaTime = RobotController.getFPGATime();
		this.start_time = fpgaTime.intValue();
	}

	@Override
	public void teleopPeriodic() 
	{
		Scheduler.getInstance().run();
		
//		System.out.println(RobotMap.FEEDERSWITCH.GetPosition());
//		System.out.println("aaa: " + gyro.getAngle());
		
//		System.out.println("bottom   " + RobotMap.ELEVATORBOTTOM.GetPosition());
//		System.out.println("top   " + RobotMap.ELEVATORTOP.GetPosition());
//		System.out.println("dasdasd  " + RobotMap.ELEVATORSWITCHES.GetPosition());
//		System.out.println("dasdasd  " + RobotMap.ELEVATORSWITCHES.GetPosition());
//		System.out.println("dasdasd  " + RobotMap.CLIMBTOPSWITCH.GetPosition());
		
		System.out.println("Forward:  " + RobotMap.FORWARDENCODER.getDistance());
//		System.out.println("Gyro:  "+ gyro.getAngle());
		System.out.println("Side:  " + RobotMap.SIDEENCODER.getDistance());
		
		
		if(full_game - (current_time - start_time)/1000000 >= 0)
		{
			Long fpgaTime = RobotController.getFPGATime();
			current_time = fpgaTime.intValue();
			SmartDashboard.putNumber("game time", full_game - ((current_time  - start_time) / 1000000));
		}

		if ((current_time-start_time)/1000000 >= 110 && (current_time-start_time)/1000000 <= 115) 
		{
			if(SmartDashboard.getBoolean("End Game", true) == true)
			{
				SmartDashboard.putBoolean("End Game", false);
			}
			else
			{
				SmartDashboard.putBoolean("End Game", true);
			}
		}
		else if ((current_time-start_time)/1000000 >= 115 )
		{
			SmartDashboard.putBoolean("End Game", true);
		}

	}

	@Override
	public void testPeriodic() 
	{
	}
}
