//
//package org.usfirst.frc.team5554.robot.commands;
//
//import edu.wpi.first.wpilibj.command.Command;
//import systems.RobotManager;
//import systems.subsystems.MechSys;
//
///**
// *
// */
//public class SysLimitControl extends Command 
//{
//
//	private MechSys subsystem;
//	private double minSpeed;
//	
//    public SysLimitControl(String key, double minSpeed) 
//    {
//		System.out.println("osadasdasdasdasdasdk");
//
//    	this.subsystem = ((MechSys)RobotManager.GetSubsystem(key));
//        requires(this.subsystem);
//        this.minSpeed = minSpeed;
//    }
//
//    protected void initialize() 
//    {
//    }
//
//    protected void execute() 
//    {
//    		this.subsystem.ManActivate(this.minSpeed);
//    }
//
//    protected boolean isFinished() 
//    {
//        return false;
//    }
//
//    protected void end() 
//    {
//    }
//
//
//    protected void interrupted() 
//    {
//    }
//}
