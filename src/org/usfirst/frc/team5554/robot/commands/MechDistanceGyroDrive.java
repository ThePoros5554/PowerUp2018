package org.usfirst.frc.team5554.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import systems.ControllerOutput;
import systems.RobotManager;
import systems.subsystems.MechDriveTrain;
import systems.subsystems.MechDriveTrain.MechDrivingDirection;

/**
 *
 */
public class MechDistanceGyroDrive extends Command {

	private MechDriveTrain driveTrain;
	
	private Encoder enc;
	private PIDController controller;
	private ControllerOutput encPIDOutput;
	
	private Gyro gyro;
	private double gyroKP;
	
	private MechDrivingDirection drivingDirection;

	
    public MechDistanceGyroDrive(double kP, double kI, double kD,  double percentTolerance, double setPoint, Encoder enc, double gyroKP, MechDrivingDirection drivingDirection) 
    {
    	this.driveTrain = (MechDriveTrain)RobotManager.GetDriveTrain();
    	requires(this.driveTrain);
    	
    	this.enc = enc;
    	this.enc.setPIDSourceType(PIDSourceType.kDisplacement);
    	this.encPIDOutput = new ControllerOutput();
    	this.controller = new PIDController(kP, kI, kD, enc, this.encPIDOutput);
    	
    	if(setPoint > 0)
    	{
    		this.controller.setInputRange(0, setPoint);
    	}
    	else
    	{
    		this.controller.setInputRange(setPoint, 0);
    	}
    	
    	this.controller.setPercentTolerance(percentTolerance);
    	this.controller.setSetpoint(setPoint);
    	
    	this.gyro = RobotManager.GetGyro();
    	this.gyroKP = gyroKP;
    	
    	this.drivingDirection = drivingDirection;
    	System.out.println("ctord");

    }

    protected void initialize() 
    {
    	this.controller.reset();
    	System.out.println("initid");
    	this.gyro.reset();
    	this.enc.reset();
    	
    	this.controller.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        double angle;
        double output;
        
        if(this.driveTrain.IsReversed() == true)
        {
        	angle = gyro.getAngle() * (-this.gyroKP);
        	output = -this.encPIDOutput.GetOutput();
        }
        else
        {
        	angle = gyro.getAngle() * (this.gyroKP);
        	output = this.encPIDOutput.GetOutput();
        }
        
        if (drivingDirection == MechDrivingDirection.Forward)
        {	
    			this.driveTrain.MecanumDrive(0, output , angle);	
        }
        if (drivingDirection == MechDrivingDirection.Sideways)
        {
    			this.driveTrain.MecanumDrive(output, 0, angle);
        }
        
        System.out.println(this.encPIDOutput.GetOutput());
    }

    protected boolean isFinished() 
    {
    	return this.controller.onTarget();
    }

    protected void end() 
    {
    	this.controller.disable();
    	
    	this.driveTrain.StopSystem();
    }

    protected void interrupted()
    {
    	this.end();
    }
}
