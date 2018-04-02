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
	private Button feederOut45DriveJoyButton;
	private Button feederOut70DriveJoyButton;
	private Button feederOut60SystemJoyButton;
	private Button feederIn70SystemJoyButton;
	private Button cancellSwitchesButton;
	private Button enableSwitchesButton;
	
	private Button onlyRotateAxisButton;
	private Button onlyTwistButton;
	private Button reverseDriveButton;
	
	private ActivateMechSys elevatorUp;
	private ActivateMechSys elevatorDown;
	private ActivateMechSys feederAxisUp;
	private ActivateMechSys feederAxisDown;
	private ActivateMechSys climbUp;
	private ActivateMechSys climbDown;
	private ActivateMechSys feederIn70;
	private ActivateMechSys feederOut45;
	private ActivateMechSys feederOut60;
	private ActivateMechSys feederOut70;
	
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
		elevatorUpAxis = new JoyAxis(RobotManager.GetSystemsJoy(), RobotMap.ELEVATORUPBUTTON, 0, -1, 0 , -1);
		elevatorDownAxis = new JoyAxis(RobotManager.GetSystemsJoy(), RobotMap.ELEVATORDOWNBUTTON, 0, 0.5, 0, 1);
		feederAxisUpButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.FEEDERAXISUPBUTTON);
		feederAxisDownButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.FEEDERAXISDOWNBUTTON);
		climbUpButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.CLIMBUPBUTTON);
		climbDownButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.CLIMBDOWNBUTTON);
		feederOut45DriveJoyButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.FEEDEROUT45DRIVEJOYBUTTON);
		feederOut70DriveJoyButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.FEEDEROUT70DRIVEJOYBUTTON);
		feederOut60SystemJoyButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.FEEDEROUT60SYSTEMJOYBUTTON);
		feederIn70SystemJoyButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.FEEDERIN70SYSTEMJOYBUTTON);
		onlyRotateAxisButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.ONLYROTATEAXISBUTTON);
		onlyTwistButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.ONLYTWISTBUTTON);
		reverseDriveButton = new JoystickButton(RobotManager.GetDriveJoy(), RobotMap.REVERSEDRIVEBUTTON);
		cancellSwitchesButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.CANCELLSWITCHESBUTTON);
		enableSwitchesButton = new JoystickButton(RobotManager.GetSystemsJoy(), RobotMap.ENABLESWITCHESBUTTON);
				
		elevatorUp = new ActivateMechSys(RobotMap.ELEVATORKEY, elevatorUpAxis, RobotMap.ELEVATORSTAYUPSPEED);
		elevatorDown = new ActivateMechSys(RobotMap.ELEVATORKEY, elevatorDownAxis, RobotMap.ELEVATORSTAYUPSPEED);
		feederAxisUp = new ActivateMechSys(RobotMap.FEEDERAXISKEY, RobotMap.FEEDERAXISUPSPEED);
		feederAxisDown = new ActivateMechSys(RobotMap.FEEDERAXISKEY, RobotMap.FEEDERAXISDOWNSPEED);
		climbUp = new ActivateMechSys(RobotMap.CLIMBKEY, RobotMap.CLIMBUPSPEED);
		climbDown = new ActivateMechSys(RobotMap.CLIMBKEY, RobotMap.CLIMBDOWNSPEED, RobotMap.CLIMBDOWNCONST);
		feederIn70 = new ActivateMechSys(RobotMap.FEEDERKEY, RobotMap.FEEDERIN70SPEED, RobotMap.FEEDERSTAYINSPEED);
		feederOut45 = new ActivateMechSys(RobotMap.FEEDERKEY, RobotMap.FEEDEROUT45SPEED);
		feederOut60 = new ActivateMechSys(RobotMap.FEEDERKEY, RobotMap.FEEDEROUT60SPEED);
		feederOut70 = new ActivateMechSys(RobotMap.FEEDERKEY, RobotMap.FEEDEROUT70SPEED);
		
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
		feederOut45DriveJoyButton.whileHeld(feederOut45);
		feederOut70DriveJoyButton.whileHeld(feederOut70);
		feederIn70SystemJoyButton.whileHeld(feederIn70);
		feederOut60SystemJoyButton.whileHeld(feederOut60);
		onlyRotateAxisButton.whenPressed(disabledSpeed);
		onlyRotateAxisButton.whenPressed(disabledTwist);
		onlyRotateAxisButton.whenReleased(enabledSpeed);
		onlyRotateAxisButton.whenReleased(enabledTwist);
		onlyTwistButton.whenPressed(disabledRotate);
		onlyTwistButton.whenPressed(disabledSpeed);
		onlyTwistButton.whenReleased(enabledRotate);
		onlyTwistButton.whenReleased(enabledSpeed);
		reverseDriveButton.whenPressed(reverseDriveTrain);
		cancellSwitchesButton.whenPressed(cancellSwitches);
		enableSwitchesButton.whenPressed(enableSwitches);
	}
}
