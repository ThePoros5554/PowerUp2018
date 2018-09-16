package org.usfirst.frc.team5554.robot;

import org.usfirst.frc.team5554.robot.commands.Center_2Cube_Switch_ToLeft;
import org.usfirst.frc.team5554.robot.commands.Center_2Cube_Switch_ToRight;
import org.usfirst.frc.team5554.robot.commands.Center_Switch_ToLeft;
import org.usfirst.frc.team5554.robot.commands.Center_Switch_ToRight;
import org.usfirst.frc.team5554.robot.commands.Forward;
import org.usfirst.frc.team5554.robot.commands.Left_2Cube_Both_ToLeft;
import org.usfirst.frc.team5554.robot.commands.Left_2Cube_Both_ToRight;
import org.usfirst.frc.team5554.robot.commands.Left_2Cube_Scale_ToLeft;
import org.usfirst.frc.team5554.robot.commands.Left_2Cube_Scale_ToRight;
import org.usfirst.frc.team5554.robot.commands.Left_Scale_ToLeft;
import org.usfirst.frc.team5554.robot.commands.Left_Scale_ToRight;
import org.usfirst.frc.team5554.robot.commands.Left_Switch_ToLeft;
import org.usfirst.frc.team5554.robot.commands.Left_Switch_ToRight;
import org.usfirst.frc.team5554.robot.commands.Right_2Cube_Both_ToRight;
import org.usfirst.frc.team5554.robot.commands.Right_2Cube_Scale_ToRight;
import org.usfirst.frc.team5554.robot.commands.Right_Scale_ToLeft;
import org.usfirst.frc.team5554.robot.commands.Right_Scale_ToRight;
import org.usfirst.frc.team5554.robot.commands.Right_Switch_ToLeft;
import org.usfirst.frc.team5554.robot.commands.Right_Switch_ToRight;
import org.usfirst.frc.team5554.robot.commands.empty;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutonomusChooser {
	
	private SendableChooser<String> LLautoChooser = new SendableChooser<String>();
	private SendableChooser<String> LRautoChooser = new SendableChooser<String>();
	private SendableChooser<String> RLautoChooser = new SendableChooser<String>();
	private SendableChooser<String> RRautoChooser = new SendableChooser<String>();
	
	public AutonomusChooser()
	{
		LLautoChooser.addDefault("LL:", "LL:");
		LLautoChooser.addObject("Center_Switch_ToRight", "Center_Switch_ToRight");
		LLautoChooser.addObject("Center_Switch_ToLeft", "Center_Switch_ToLeft");
//		LLautoChooser.addObject("Left_Scale_ToLeft", "Left_Scale_ToLeft");
		LLautoChooser.addObject("Left_Switch_ToLeft", "Left_Switch_ToLeft");
		LLautoChooser.addObject("Left_Scale_ToRight", "Left_Scale_ToRight");
//		LLautoChooser.addObject("Left_Switch_ToRight", "Left_Switch_ToRight");
		LLautoChooser.addObject("Left_2Cube_Scale_ToLeft", "Left_2Cube_Scale_ToLeft");
		LLautoChooser.addObject("Left_2Cube_Both_ToLeft", "Left_2Cube_Both_ToLeft");
//		LLautoChooser.addObject("Right_Scale_ToRight", "Right_Scale_ToRight");
		LLautoChooser.addObject("Right_Switch_ToRight", "Right_Switch_ToRight");
		LLautoChooser.addObject("Right_Scale_ToLeft", "Right_Scale_ToLeft");
//		LLautoChooser.addObject("Right_Switch_ToLeft", "Right_Switch_ToLeft");
		LLautoChooser.addObject("Right_2Cube_Scale_ToRight", "Right_2Cube_Scale_ToRight");
		LLautoChooser.addObject("Right_2Cube_Both_ToRight", "Right_2Cube_Both_ToRight");
		LLautoChooser.addObject("Left_2Cube_Scale_ToRight", "Left_2Cube_Scale_ToRight");
		LLautoChooser.addObject("Left_2Cube_Both_ToRight", "Left_2Cube_Both_ToRight");
		LLautoChooser.addObject("Center_2Cube_Switch_ToRight", "Center_2Cube_Switch_ToRight");
		LLautoChooser.addObject("Center_2Cube_Switch_ToLeft", "Center_2Cube_Switch_ToLeft");
		LLautoChooser.addObject("Forward", "Forward");

		SmartDashboard.putData("LLautoChooser", LLautoChooser);
		
		LRautoChooser.addDefault("LR:", "LR:");
		LRautoChooser.addObject("Center_Switch_ToRight", "Center_Switch_ToRight");
		LRautoChooser.addObject("Center_Switch_ToLeft", "Center_Switch_ToLeft");
//		LRautoChooser.addObject("Left_Scale_ToLeft", "Left_Scale_ToLeft");
		LRautoChooser.addObject("Left_Switch_ToLeft", "Left_Switch_ToLeft");
		LRautoChooser.addObject("Left_Scale_ToRight", "Left_Scale_ToRight");
//		LRautoChooser.addObject("Left_Switch_ToRight", "Left_Switch_ToRight");
		LRautoChooser.addObject("Left_2Cube_Scale_ToLeft", "Left_2Cube_Scale_ToLeft");
		LRautoChooser.addObject("Left_2Cube_Both_ToLeft", "Left_2Cube_Both_ToLeft");
//		LRautoChooser.addObject("Right_Scale_ToRight", "Right_Scale_ToRight");
		LRautoChooser.addObject("Right_Switch_ToRight", "Right_Switch_ToRight");
//		LRautoChooser.addObject("Right_Scale_ToLeft", "Right_Scale_ToLeft");
		LRautoChooser.addObject("Right_Switch_ToLeft", "Right_Switch_ToLeft");
		LRautoChooser.addObject("Right_2Cube_Scale_ToRight", "Right_2Cube_Scale_ToRight");
		LRautoChooser.addObject("Right_2Cube_Both_ToRight", "Right_2Cube_Both_ToRight");
		LRautoChooser.addObject("Left_2Cube_Scale_ToRight", "Left_2Cube_Scale_ToRight");
		LRautoChooser.addObject("Left_2Cube_Both_ToRight", "Left_2Cube_Both_ToRight");
		LRautoChooser.addObject("Center_2Cube_Switch_ToRight", "Center_2Cube_Switch_ToRight");
		LRautoChooser.addObject("Center_2Cube_Switch_ToLeft", "Center_2Cube_Switch_ToLeft");
		LRautoChooser.addObject("Forward", "Forward");

		SmartDashboard.putData("LRautoChooser", LRautoChooser);
		
		RLautoChooser.addDefault("RL:", "RL:");
		RLautoChooser.addObject("Center_Switch_ToRight", "Center_Switch_ToRight");
		RLautoChooser.addObject("Center_Switch_ToLeft", "Center_Switch_ToLeft");
//		RLautoChooser.addObject("Left_Scale_ToLeft", "Left_Scale_ToLeft");
		RLautoChooser.addObject("Left_Switch_ToLeft", "Left_Switch_ToLeft");
		RLautoChooser.addObject("Left_Scale_ToRight", "Left_Scale_ToRight");
//		RLautoChooser.addObject("Left_Switch_ToRight", "Left_Switch_ToRight");
		RLautoChooser.addObject("Left_2Cube_Scale_ToLeft", "Left_2Cube_Scale_ToLeft");
		RLautoChooser.addObject("Left_2Cube_Both_ToLeft", "Left_2Cube_Both_ToLeft");
//		RLautoChooser.addObject("Right_Scale_ToRight", "Right_Scale_ToRight");
		RLautoChooser.addObject("Right_Switch_ToRight", "Right_Switch_ToRight");
		RLautoChooser.addObject("Right_Scale_ToLeft", "Right_Scale_ToLeft");
//		RLautoChooser.addObject("Right_Switch_ToLeft", "Right_Switch_ToLeft");
		RLautoChooser.addObject("Right_2Cube_Scale_ToRight", "Right_2Cube_Scale_ToRight");
		RLautoChooser.addObject("Right_2Cube_Both_ToRight", "Right_2Cube_Both_ToRight");
		RLautoChooser.addObject("Left_2Cube_Scale_ToRight", "Left_2Cube_Scale_ToRight");
		RLautoChooser.addObject("Left_2Cube_Both_ToRight", "Left_2Cube_Both_ToRight");
		RLautoChooser.addObject("Center_2Cube_Switch_ToRight", "Center_2Cube_Switch_ToRight");
		RLautoChooser.addObject("Center_2Cube_Switch_ToLeft", "Center_2Cube_Switch_ToLeft");
		RLautoChooser.addObject("Forward", "Forward");

		SmartDashboard.putData("RLautoChooser", RLautoChooser);
		
		RRautoChooser.addDefault("RR:", "RR:");
		RRautoChooser.addObject("Center_Switch_ToRight", "Center_Switch_ToRight");
		RRautoChooser.addObject("Center_Switch_ToLeft", "Center_Switch_ToLeft");
//		RRautoChooser.addObject("Left_Scale_ToLeft", "Left_Scale_ToLeft");
		RRautoChooser.addObject("Left_Switch_ToLeft", "Left_Switch_ToLeft");
		RRautoChooser.addObject("Left_Scale_ToRight", "Left_Scale_ToRight");
//		RRautoChooser.addObject("Left_Switch_ToRight", "Left_Switch_ToRight");
		RRautoChooser.addObject("Left_2Cube_Scale_ToLeft", "Left_2Cube_Scale_ToLeft");
		RRautoChooser.addObject("Left_2Cube_Both_ToLeft", "Left_2Cube_Both_ToLeft");
//		RRautoChooser.addObject("Right_Scale_ToRight", "Right_Scale_ToRight");
		RRautoChooser.addObject("Right_Switch_ToRight", "Right_Switch_ToRight");
		RRautoChooser.addObject("Right_Scale_ToLeft", "Right_Scale_ToLeft");
//		RRautoChooser.addObject("Right_Switch_ToLeft", "Right_Switch_ToLeft");
		RRautoChooser.addObject("Right_2Cube_Scale_ToRight", "Right_2Cube_Scale_ToRight");
		RRautoChooser.addObject("Right_2Cube_Both_ToRight", "Right_2Cube_Both_ToRight");
		RRautoChooser.addObject("Left_2Cube_Scale_ToRight", "Left_2Cube_Scale_ToRight");
		RRautoChooser.addObject("Left_2Cube_Both_ToRight", "Left_2Cube_Both_ToRight");
		RRautoChooser.addObject("Center_2Cube_Switch_ToRight", "Center_2Cube_Switch_ToRight");
		RRautoChooser.addObject("Center_2Cube_Switch_ToLeft", "Center_2Cube_Switch_ToLeft");
		RRautoChooser.addObject("Forward", "Forward");


		SmartDashboard.putData("RRautoChooser", RRautoChooser);
	}
	
	public Command LLGetSelected()
	{
		return GetAutonomous(LLautoChooser.getSelected());
	}
	
	public Command LRGetSelected()
	{
		return GetAutonomous(LRautoChooser.getSelected());
	}
	
	public Command RLGetSelected()
	{
		return GetAutonomous(RLautoChooser.getSelected());
	}
	
	public Command RRGetSelected()
	{
		return GetAutonomous(RRautoChooser.getSelected());
	}
	
	public Command GetAutonomous(String key)
	{
		switch(key)
		{
			case "LL:":
				
				return new empty();
				
			case "LR:":
				
				return new empty();
				
			case "RL:":
				
				return new empty();
				
			case "RR:":
				
				return new empty();
				
			case "Center_Switch_ToRight":
				
				return new Center_Switch_ToRight(); 
				
			case "Center_Switch_ToLeft":
				
				return new Center_Switch_ToLeft(); 
				
			case "Left_Scale_ToLeft":
				
				return new Left_Scale_ToLeft(); 
				
			case "Left_Switch_ToLeft":
				
				return new Left_Switch_ToLeft(); 
				
			case "Right_Switch_ToRight":
				
				return new Right_Switch_ToRight(); 
				
			case "Right_Scale_ToRight":
				
				return new Right_Scale_ToRight(); 
				
			case "Left_Switch_ToRight":
				
				return new Left_Switch_ToRight();
				
			case "Right_Switch_ToLeft":
				
				return new Right_Switch_ToLeft();
				
			case "Left_Scale_ToRight":
				
				return new Left_Scale_ToRight(); 
				
			case "Left_2Cube_Scale_ToLeft":
				
				return new Left_2Cube_Scale_ToLeft(); 
				
			case "Left_2Cube_Both_ToLeft":
				
				return new Left_2Cube_Both_ToLeft(); 
				
			case "Right_2Cube_Scale_ToRight":
				
				return new Right_2Cube_Scale_ToRight(); 
				
			case "Right_2Cube_Both_ToRight":
				
				return new Right_2Cube_Both_ToRight(); 
				
			case "Right_Scale_ToLeft":
				
				return new Right_Scale_ToLeft(); 
				
			case "Left_2Cube_Scale_ToRight":
				
				return new Left_2Cube_Scale_ToRight();
				
			case "Left_2Cube_Both_ToRight":
				
				return new Left_2Cube_Both_ToRight();
				
			case "Center_2Cube_Switch_ToRight":
				
				return new Center_2Cube_Switch_ToRight();
				
			case "Center_2Cube_Switch_ToLeft":
				
				return new Center_2Cube_Switch_ToLeft();
				
			case "Forward":
				
				return new Forward(); 				
		}
		
		return new empty();

	}
	
}
