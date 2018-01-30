/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5554.robot;

import commands.ActivateMechSys;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import systems.RobotManager;

public class OI 
{
	Button climbButton;
	Button elevatorButton;
	Button feederButton;
	
	ActivateMechSys climbActivate;
	ActivateMechSys elevatorActivate;
	ActivateMechSys feederActivate;


	public OI()
	{
		climbButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.climbButton);
		elevatorButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.elevatorButton);
		feederButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.feederButton);
		
		climbActivate = new ActivateMechSys(RobotMap.climbKey, RobotMap.climbKey);
		elevatorActivate = new ActivateMechSys(RobotMap.elevatorKey, RobotMap.elevatorKey);
		feederActivate = new ActivateMechSys(RobotMap.feederKey, RobotMap.feederKey);
		
		climbButton.whileHeld(climbActivate);
		elevatorButton.whileHeld(elevatorActivate);
		feederButton.whileHeld(feederActivate);	
	}
}
