/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5554.robot;

import commands.ActivateMechSys;
import commands.DisableJoyAxis;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import systems.RobotManager;
import triggers.AxisAsButton;
import triggers.SmartJoystick;

public class OI 
{
	private AxisAsButton elevatorUpButton;
	private AxisAsButton elevatorDownButton;
	private Button feederAxisUpButton;
	private Button feederAxisDownButton;
	private Button climbUpButton;
	private Button climbDownButton;
	private Button feederInButton;
	private Button feederOutButton;
	
	private Button onlyRotateAxisButton;
	private Button onlySpeedButton;
	
	
	private ActivateMechSys elevatorUp;
	private ActivateMechSys elevatorDown;
	private ActivateMechSys feederAxisUp;
	private ActivateMechSys feederAxisDown;
	private ActivateMechSys climbUp;
	private ActivateMechSys climbDown;
	private ActivateMechSys feederIn;
	private ActivateMechSys feederOut;
	
	private DisableJoyAxis disabledSpeed;
	private DisableJoyAxis disabledRotate;
	private DisableJoyAxis disabledTwist;
	private DisableJoyAxis enabledSpeed;
	private DisableJoyAxis enabledRotate;
	private DisableJoyAxis enabledTwist;
	
	public OI()
	{
		elevatorUpButton = new AxisAsButton(RobotManager.GetSystemsJoy(), RobotMap.ELEVATORUPBUTTON);
		elevatorDownButton = new AxisAsButton(RobotManager.GetSystemsJoy(), RobotMap.ELEVATORDOWNBUTTON);
		feederAxisUpButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.FEEDERAXISUPBUTTON);
		feederAxisDownButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.FEEDERAXISDOWNBUTTON);
		climbUpButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.CLIMBUPBUTTON);
		climbDownButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.CLIMBDOWNBUTTON);
		feederInButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.FEEDERINBUTTON);
		feederOutButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.FEEDEROUTBUTTON);
		onlyRotateAxisButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.ONLYROTATEAXISBUTTON);
		onlySpeedButton = new	JoystickButton(RobotManager.GetDriveJoy(), RobotMap.ONLYSPEEDBUTTON);
				
		elevatorUp = new ActivateMechSys(RobotMap.ELEVATORKEY, RobotMap.ELEVATORUPSPEED);
		elevatorDown = new ActivateMechSys(RobotMap.ELEVATORKEY, RobotMap.ELEVATORDOWNSPEED);
		feederAxisUp = new ActivateMechSys(RobotMap.FEEDERAXISKEY, RobotMap.FEEDERAXISUPSPEED);
		feederAxisDown = new ActivateMechSys(RobotMap.FEEDERAXISKEY, RobotMap.FEEDERAXISDOWNSPEED);
		climbUp = new ActivateMechSys(RobotMap.CLIMBKEY, RobotMap.CLIMBUPKEY);
		climbDown = new ActivateMechSys(RobotMap.CLIMBKEY, RobotMap.CLIMBDOWNKEY);
		feederIn = new ActivateMechSys(RobotMap.FEEDERKEY, RobotMap.FEEDERINKEY);
		feederOut = new ActivateMechSys(RobotMap.FEEDERKEY, RobotMap.FEEDEROUTKEY);
		
		disabledSpeed = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.SPEEDAXIS, true);
		disabledRotate = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.ROTATEAXIS, true);
		disabledTwist = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.TWISTAXIS, true);
		enabledSpeed = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.SPEEDAXIS, false);
		enabledRotate = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.ROTATEAXIS, false);
		enabledTwist = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.TWISTAXIS, false);
		
		elevatorUpButton.whileActive(elevatorUp);
		elevatorDownButton.whileActive(elevatorDown);
		feederAxisUpButton.whileActive(feederAxisUp);
		feederAxisDownButton.whileActive(feederAxisDown);
		climbUpButton.whileHeld(climbUp);
		climbDownButton.whileHeld(climbDown);
		feederInButton.whileHeld(feederIn);
		feederOutButton.whileHeld(feederOut);		
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
