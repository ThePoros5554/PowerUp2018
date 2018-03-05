package org.usfirst.frc.team5554.robot;

import org.usfirst.frc.team5554.robot.commands.Center_Exchange;
import org.usfirst.frc.team5554.robot.commands.Center_Scale_ToLeft;
import org.usfirst.frc.team5554.robot.commands.Center_Scale_ToRight;
import org.usfirst.frc.team5554.robot.commands.Center_Switch_ToLeft;
import org.usfirst.frc.team5554.robot.commands.Center_Switch_ToRight;
import org.usfirst.frc.team5554.robot.commands.Forward;
import org.usfirst.frc.team5554.robot.commands.Left_Exchange;
import org.usfirst.frc.team5554.robot.commands.Left_Scale_ToLeft;
import org.usfirst.frc.team5554.robot.commands.Left_Scale_ToRight;
import org.usfirst.frc.team5554.robot.commands.Left_Switch_ToLeft;
import org.usfirst.frc.team5554.robot.commands.Left_Switch_ToRight;
import org.usfirst.frc.team5554.robot.commands.Right_Exchange;
import org.usfirst.frc.team5554.robot.commands.Right_Scale_ToLeft;
import org.usfirst.frc.team5554.robot.commands.Right_Scale_ToRight;
import org.usfirst.frc.team5554.robot.commands.Right_Switch_ToLeft;
import org.usfirst.frc.team5554.robot.commands.Right_Switch_ToRight;
import org.usfirst.frc.team5554.robot.commands.empty;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomusChooser {
	
	private SendableChooser<Command> LLautoChooser = new SendableChooser<Command>();
	private SendableChooser<Command> LRautoChooser = new SendableChooser<Command>();
	private SendableChooser<Command> RLautoChooser = new SendableChooser<Command>();
	private SendableChooser<Command> RRautoChooser = new SendableChooser<Command>();
	
	public AutonomusChooser()
	{
		LLautoChooser.addDefault("LL:", new empty());
		LLautoChooser.addObject("Center_Switch_ToRight", new Center_Switch_ToRight());
		LLautoChooser.addObject("Center_Switch_ToLeft", new Center_Switch_ToLeft());
		LLautoChooser.addObject("Left_Scale_ToLeft", new Left_Scale_ToLeft());
		LLautoChooser.addObject("Left_Switch_ToLeft", new Left_Switch_ToLeft());
		LLautoChooser.addObject("Right_Switch_ToRight", new Right_Switch_ToRight());
		LLautoChooser.addObject("Right_Scale_ToRight", new Right_Scale_ToRight());
		LLautoChooser.addObject("Left_Switch_ToRight", new Left_Switch_ToRight());
		LLautoChooser.addObject("Right_Switch_ToLeft", new Right_Switch_ToLeft());
		LLautoChooser.addObject("Forward", new Forward());
//		LLautoChooser.addObject("Center_Scale_ToLeft", new Center_Scale_ToLeft());
//		LLautoChooser.addObject("Center_Exchange", new Center_Exchange());
//		LLautoChooser.addObject("Right_Switch_ToLeft", new Right_Switch_ToLeft());
//		LLautoChooser.addObject("Right_Scale_ToLeft", new Right_Scale_ToLeft());
//		LLautoChooser.addObject("Right_Exchange", new Right_Exchange());
		SmartDashboard.putData("LLautoChooser", LLautoChooser);
		
		LRautoChooser.addDefault("LR:", new empty());
		LRautoChooser.addObject("Center_Switch_ToRight", new Center_Switch_ToRight());
		LRautoChooser.addObject("Center_Switch_ToLeft", new Center_Switch_ToLeft());
		LRautoChooser.addObject("Left_Scale_ToLeft", new Left_Scale_ToLeft());
		LRautoChooser.addObject("Left_Switch_ToLeft", new Left_Switch_ToLeft());
		LRautoChooser.addObject("Right_Switch_ToRight", new Right_Switch_ToRight());
		LRautoChooser.addObject("Right_Scale_ToRight", new Right_Scale_ToRight());
		LRautoChooser.addObject("Left_Switch_ToRight", new Left_Switch_ToRight());
		LRautoChooser.addObject("Right_Switch_ToLeft", new Right_Switch_ToLeft());
		LRautoChooser.addObject("Forward", new Forward());
//		LRautoChooser.addObject("Left_Exchange", new Left_Exchange());
//		LRautoChooser.addObject("Center_Scale_ToRight", new Center_Scale_ToRight());
//		LRautoChooser.addObject("Center_Exchange", new Center_Exchange());
//		LRautoChooser.addObject("Right_Exchange", new Right_Exchange());
		SmartDashboard.putData("LRautoChooser", LRautoChooser);
		
		RLautoChooser.addDefault("RL:", new empty());
		RLautoChooser.addObject("Center_Switch_ToRight", new Center_Switch_ToRight());
		RLautoChooser.addObject("Center_Switch_ToLeft", new Center_Switch_ToLeft());
		RLautoChooser.addObject("Left_Scale_ToLeft", new Left_Scale_ToLeft());
		RLautoChooser.addObject("Left_Switch_ToLeft", new Left_Switch_ToLeft());
		RLautoChooser.addObject("Right_Switch_ToRight", new Right_Switch_ToRight());
		RLautoChooser.addObject("Right_Scale_ToRight", new Right_Scale_ToRight());
		RLautoChooser.addObject("Left_Switch_ToRight", new Left_Switch_ToRight());
		RLautoChooser.addObject("Right_Switch_ToLeft", new Right_Switch_ToLeft());
		RLautoChooser.addObject("Forward", new Forward());
//		RLautoChooser.addObject("Center_Scale_ToLeft", new Center_Scale_ToLeft());
//		RLautoChooser.addObject("Left_Exchange", new Left_Exchange());
//		RLautoChooser.addObject("Center_Exchange", new Center_Exchange());
//		RLautoChooser.addObject("Right_Exchange", new Right_Exchange());
		SmartDashboard.putData("RLautoChooser", RLautoChooser);
		
		RRautoChooser.addDefault("RR:", new empty());
		RRautoChooser.addObject("Center_Switch_ToRight", new Center_Switch_ToRight());
		RRautoChooser.addObject("Center_Switch_ToLeft", new Center_Switch_ToLeft());
		RRautoChooser.addObject("Left_Scale_ToLeft", new Left_Scale_ToLeft());
		RRautoChooser.addObject("Left_Switch_ToLeft", new Left_Switch_ToLeft());
		RRautoChooser.addObject("Right_Switch_ToRight", new Right_Switch_ToRight());
		RRautoChooser.addObject("Right_Scale_ToRight", new Right_Scale_ToRight());
		RRautoChooser.addObject("Left_Switch_ToRight", new Left_Switch_ToRight());
		RRautoChooser.addObject("Right_Switch_ToLeft", new Right_Switch_ToLeft());
		RRautoChooser.addObject("Forward", new Forward());
//		RRautoChooser.addObject("Left_Exchange", new Left_Exchange());
//		RRautoChooser.addObject("Center_Scale_ToRight", new Center_Scale_ToRight());
//		RRautoChooser.addObject("Center_Exchange", new Center_Exchange());
//		RRautoChooser.addObject("Right_Exchange", new Right_Exchange());
		SmartDashboard.putData("RRautoChooser", RRautoChooser);
	}
	
	public Command LLGetSelected()
	{
		return (LLautoChooser.getSelected());
	}
	
	public Command LRGetSelected()
	{
		return (LRautoChooser.getSelected());
	}
	
	public Command RLGetSelected()
	{
		return (RLautoChooser.getSelected());
	}
	
	public Command RRGetSelected()
	{
		return (RRautoChooser.getSelected());
	}
	
}
