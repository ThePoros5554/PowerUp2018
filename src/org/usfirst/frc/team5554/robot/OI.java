/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5554.robot;

import commands.ActivateMechSys;
import commands.DisableJoyAxis;
import commands.ReverseDriveTrain;
import commands.SetAllLimits;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import systems.RobotManager;
import triggers.JoyAxis;
import triggers.SmartJoystick;

public class OI 
{
	private JoyAxis elevatorUpAxis;
	private JoyAxis elevatorDownAxis;
	private Button feederAxisUpButton;
	private Button feederAxisDownButton;
	private Button climbUpButton;
	private Button climbDownButton;
	private Button feederInDriveJoyButton;
	private Button feederOutDriveJoyButton;
	private Button feederInSystemJoyButton;
	private Button feederOutSystemJoyButton;
	private Button cancellSwitchesButton;
	private Button enableSwitchesButton;
	
	private Button onlyRotateAxisButton;
	private Button onlySpeedButton;
	private Button reverseDriveButton;
	
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
	
	private SetAllLimits cancellSwitches;
	private SetAllLimits enableSwitches;
	
	private ReverseDriveTrain reverseDriveTrain;
	
	public OI()
	{
		elevatorUpAxis = new JoyAxis(RobotManager.GetSystemsJoy(), RobotMap.ELEVATORUPBUTTON, 0, -1);
		elevatorDownAxis = new JoyAxis(RobotManager.GetSystemsJoy(), RobotMap.ELEVATORDOWNBUTTON, 0, 1);
		feederAxisUpButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.FEEDERAXISUPBUTTON);
		feederAxisDownButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.FEEDERAXISDOWNBUTTON);
		climbUpButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.CLIMBUPBUTTON);
		climbDownButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.CLIMBDOWNBUTTON);
		feederInDriveJoyButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.FEEDERINDRIVEJOYBUTTON);
		feederOutDriveJoyButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.FEEDEROUTDRIVEJOYBUTTON);
		feederInSystemJoyButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.FEEDERINSYSTEMJOYBUTTON);
		feederOutSystemJoyButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.FEEDEROUTSYSTEMJOYBUTTON);
		onlyRotateAxisButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.ONLYROTATEAXISBUTTON);
		onlySpeedButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.ONLYSPEEDBUTTON);
		reverseDriveButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.REVERSEDRIVEBUTTON);
		cancellSwitchesButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.CANCELLSWITCHESBUTTON);
		enableSwitchesButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.ENABLESWITCHESBUTTON);
				
		elevatorUp = new ActivateMechSys(RobotMap.ELEVATORKEY, RobotMap.ELEVATORUPSPEEDCONST, RobotMap.ELEVATORSTAYUPSPEED);
		elevatorDown = new ActivateMechSys(RobotMap.ELEVATORKEY, RobotMap.ELEVATORDOWNSPEEDCONST, RobotMap.ELEVATORSTAYUPSPEED);
		feederAxisUp = new ActivateMechSys(RobotMap.FEEDERAXISKEY, RobotMap.FEEDERAXISUPSPEED);
		feederAxisDown = new ActivateMechSys(RobotMap.FEEDERAXISKEY, RobotMap.FEEDERAXISDOWNSPEED);
		climbUp = new ActivateMechSys(RobotMap.CLIMBKEY, RobotMap.CLIMBUPSPEED);
		climbDown = new ActivateMechSys(RobotMap.CLIMBKEY, RobotMap.CLIMBDOWNSPEED);
		feederIn = new ActivateMechSys(RobotMap.FEEDERKEY, RobotMap.FEEDERINSPEED);
		feederOut = new ActivateMechSys(RobotMap.FEEDERKEY, RobotMap.FEEDEROUTSPEED);
		
		reverseDriveTrain = new ReverseDriveTrain();
		
		disabledSpeed = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.SPEEDAXIS, true);
		disabledRotate = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.ROTATEAXIS, true);
		disabledTwist = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.TWISTAXIS, true);
		enabledSpeed = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.SPEEDAXIS, false);
		enabledRotate = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.ROTATEAXIS, false);
		enabledTwist = new DisableJoyAxis((SmartJoystick) RobotManager.GetDriveJoy(), RobotMap.TWISTAXIS, false);
		
		cancellSwitches = new SetAllLimits(false);
		enableSwitches = new SetAllLimits(true);
		
		elevatorUpAxis.whileActive(elevatorUp);
		elevatorDownAxis.whileActive(elevatorDown);
		feederAxisUpButton.whileActive(feederAxisUp);
		feederAxisDownButton.whileActive(feederAxisDown);
		climbUpButton.whileHeld(climbUp);
		climbDownButton.whileHeld(climbDown);
		feederInDriveJoyButton.whileHeld(feederIn);
		feederOutDriveJoyButton.whileHeld(feederOut);
		feederInSystemJoyButton.whileHeld(feederIn);
		feederOutSystemJoyButton.whileHeld(feederOut);
		onlyRotateAxisButton.whenPressed(disabledSpeed);
		onlyRotateAxisButton.whenPressed(disabledTwist);
		onlyRotateAxisButton.whenReleased(enabledSpeed);
		onlyRotateAxisButton.whenReleased(enabledTwist);
		onlySpeedButton.whenPressed(disabledRotate);
		onlySpeedButton.whenPressed(disabledTwist);
		onlySpeedButton.whenReleased(enabledRotate);
		onlySpeedButton.whenReleased(enabledTwist);
		reverseDriveButton.whenPressed(reverseDriveTrain);
		cancellSwitchesButton.whenPressed(cancellSwitches);
		enableSwitchesButton.whenPressed(enableSwitches);
	}
}
