/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5554.robot;

import commands.ActivateMechSys;
import commands.DisableJoyAxis;
import commands.auto.TimedGyroDrive;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import systems.RobotManager;
import triggers.SmartJoystick;

public class OI 
{
	Button elevatorButton;
	Button rightRampButton;
	Button climbButton;
	Button leftRampButton;
	Button feederAxisButton;
	Button feederButton;
	
	Button onlyRotateAxisButton;
	Button onlySpeedButton;
	
	
	ActivateMechSys elevatorActivate;
	ActivateMechSys rightRampActivate;
	ActivateMechSys climbActivate;
	ActivateMechSys leftRampActivate;
	ActivateMechSys feederAxisActivate;
	ActivateMechSys feederActivate;
	
	DisableJoyAxis disabledSpeed;
	DisableJoyAxis disabledRotate;
	DisableJoyAxis disabledTwist;
	DisableJoyAxis enabledSpeed;
	DisableJoyAxis enabledRotate;
	DisableJoyAxis enabledTwist;
	
	public OI()
	{
		elevatorButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.ELEVATORBUTTON);
		rightRampButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.RIGHTRAMPBUTTON);
		climbButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.CLIMBBUTTON);
		leftRampButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.LEFTRAMPBUTTON);
		feederAxisButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.FEEDERAXISBUTTON);
		feederButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.FEEDERBUTTON);
		onlyRotateAxisButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.ONLYROTATEAXISBUTTON);
		onlySpeedButton = new	JoystickButton(RobotManager.GetDriveJoy(), RobotMap.ONLYSPEEDBUTTON);
				
		elevatorActivate = new ActivateMechSys(RobotMap.ELEVATORKEY, RobotMap.ELEVATORKEY);
		rightRampActivate = new ActivateMechSys(RobotMap.RIGHTRAMPKEY, RobotMap.RIGHTRAMPKEY);
		climbActivate = new ActivateMechSys(RobotMap.CLIMBKEY, RobotMap.CLIMBKEY);
		leftRampActivate = new ActivateMechSys(RobotMap.LEFTRAMPKEY, RobotMap.LEFTRAMPKEY);
		feederAxisActivate = new ActivateMechSys(RobotMap.FEEDERAXISKEY, RobotMap.FEEDERAXISKEY);
		feederActivate = new ActivateMechSys(RobotMap.FEEDERKEY, RobotMap.FEEDERKEY);
		
		disabledSpeed = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.SPEEDAXIS, true);
		disabledRotate = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.ROTATEAXIS, true);
		disabledTwist = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.TWISTAXIS, true);
		enabledSpeed = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.SPEEDAXIS, false);
		enabledRotate = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.ROTATEAXIS, false);
		enabledTwist = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.TWISTAXIS, false);
		
		elevatorButton.whileHeld(elevatorActivate);
		rightRampButton.whileHeld(rightRampActivate);
		climbButton.whileHeld(climbActivate);
		leftRampButton.whileHeld(leftRampActivate);
		feederAxisButton.whileHeld(feederAxisActivate);
		feederButton.whileHeld(feederActivate);
		
		onlyRotateAxisButton.whenPressed(disabledSpeed);
		onlyRotateAxisButton.whenPressed(disabledTwist);
		onlyRotateAxisButton.whenReleased(enabledSpeed);
		onlyRotateAxisButton.whenReleased(enabledTwist);
		onlySpeedButton.whenPressed(disabledRotate);
		onlySpeedButton.whenPressed(disabledTwist);
		onlySpeedButton.whenReleased(enabledRotate);
		onlySpeedButton.whenReleased(enabledTwist);
	}
}
