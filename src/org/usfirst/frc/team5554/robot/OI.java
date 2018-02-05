/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5554.robot;

import commands.ActivateMechSys;
import commands.ReverseAxisDisabled;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import systems.RobotManager;

public class OI 
{
	Button elevatorButton;
	Button rightRampButton;
	Button climbButton;
	Button leftRampButton;
	Button feederAxisButton;
	Button feederButton;
	
	ActivateMechSys elevatorActivate;
	ActivateMechSys rightRampActivate;
	ActivateMechSys climbActivate;
	ActivateMechSys leftRampActivate;
	ActivateMechSys feederAxisActivate;
	ActivateMechSys feederActivate;


	public OI()
	{
//		elevatorButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.ELEVATORBUTTON);
//		rightRampButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.RIGHTRAMPBUTTON);
//		climbButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.CLIMBBUTTON);
//		leftRampButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.LEFTRAMPBUTTON);
//		feederAxisButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.FEEDERAXISBUTTON);
//		feederButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.FEEDERBUTTON);
//		
//		elevatorActivate = new ActivateMechSys(RobotMap.ELEVATORKEY, RobotMap.ELEVATORKEY);
//		rightRampActivate = new ActivateMechSys(RobotMap.RIGHTRAMPKEY, RobotMap.RIGHTRAMPKEY);
//		climbActivate = new ActivateMechSys(RobotMap.CLIMBKEY, RobotMap.CLIMBKEY);
//		leftRampActivate = new ActivateMechSys(RobotMap.LEFTRAMPKEY, RobotMap.LEFTRAMPKEY);
//		feederAxisActivate = new ActivateMechSys(RobotMap.FEEDERAXISKEY, RobotMap.FEEDERAXISKEY);
//		feederActivate = new ActivateMechSys(RobotMap.FEEDERKEY, RobotMap.FEEDERKEY);
//		
//		elevatorButton.whileHeld(elevatorActivate);
//		rightRampButton.whileHeld(rightRampActivate);
//		climbButton.whileHeld(climbActivate);
//		leftRampButton.whileHeld(leftRampActivate);
//		feederAxisButton.whileHeld(feederAxisActivate);
//		feederButton.whileHeld(feederActivate);	
		
		Button b = new JoystickButton(RobotManager.GetDriveJoy(), 2);
		b.whenPressed(new ReverseAxisDisabled(RobotManager.GetDriveJoy(), 2));
	}
}
