package org.usfirst.frc.team5554.robot.commands;

public class PIDControllerValues
{
	private double kP;
	private double kI;
	private double kD;
	private double kF;
	
	private double percentTolerence;
	
	private double minInputRange;
	private double maxInputRange;
	
	private double setPoint;
	
	public PIDControllerValues(double kP, double kI, double kD)
	{
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
		this.kF = 0;
	}
	
	public PIDControllerValues(double kP, double kI, double kD, double kF)
	{
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
		this.kF = kF;
	}
	
	public void SetP(double kP)
	{
		this.kP = kP;
	}
	
	public void SetI(double kI)
	{
		this.kI = kI;
	}
	
	public void SetD(double kD)
	{
		this.kD = kD;
	}
	
	public void SetF(double kF)
	{
		this.kF = kF;
	}
	
	public void SetInputRange(double min, double max)
	{
		this.minInputRange = min;
		this.maxInputRange = max;
	}
	
	public void SetMinInputRange(double min)
	{
		this.minInputRange = min;
	}
	
	public void SetMaxInputRange(double max)
	{
		this.maxInputRange = max;
	}
	
	public void SetPercentTolerance(double percent)
	{
		this.percentTolerence = percent;
	}
	
	public void SetSetPoint(double setPoint)
	{
		this.setPoint = setPoint;
	}
	
	public double GetP()
	{
		return this.kP;
	}
	
	public double GetI()
	{
		return this.kI;
	}
	
	public double GetD()
	{
		return this.kD;
	}
	
	public double GetF()
	{
		return this.kF;
	}
	
	public double GetMinInput()
	{
		return this.minInputRange;
	}
	
	public double GetMaxOutput()
	{
		return this.maxInputRange;
	}
	
	public double GetPercentTolerance()
	{
		return this.percentTolerence;
	}
	
	public double GetSetPoint()
	{
		return this.setPoint;
	}
}
