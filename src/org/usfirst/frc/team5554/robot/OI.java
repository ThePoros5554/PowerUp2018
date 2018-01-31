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
		climbButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.CLIMBBUTTON);
		elevatorButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.ELEVATORBUTTON);
		feederButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.FEEDERBUTTON);
		
		climbActivate = new ActivateMechSys(RobotMap.CLIMBKEY, RobotMap.CLIMBKEY);
		elevatorActivate = new ActivateMechSys(RobotMap.ELEVATORKEY, RobotMap.ELEVATORKEY);
		feederActivate = new ActivateMechSys(RobotMap.FEEDERKEY, RobotMap.FEEDERKEY);
		
		climbButton.whileHeld(climbActivate);
		elevatorButton.whileHeld(elevatorActivate);
		feederButton.whileHeld(feederActivate);	
	}
}
