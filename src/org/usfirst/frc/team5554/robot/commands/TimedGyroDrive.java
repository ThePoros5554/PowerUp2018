package org.usfirst.frc.team5554.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import systems.RobotManager;
import systems.subsystems.DiffDriveTrain;
import systems.subsystems.DriveTrain;
import systems.subsystems.MechDriveTrain;

/**
 *
 */
public class TimedGyroDrive extends Command 
{
	private DriveTrain driveTrain;
	private String driveTrainClass;

	private Gyro gyro;
	double kP;
	double speed;

    public TimedGyroDrive(String speedKey, double kP, double time) 
    {
        super("TimedGyroDrive" , time);
    	this.gyro = RobotManager.GetGyro();
    	this.driveTrain = RobotManager.GetDriveTrain();
    	this.driveTrainClass = this.driveTrain.getClass().getTypeName();
    	this.kP = kP;
    	this.speed = RobotManager.GetSpeed(speedKey);
        requires(this.driveTrain);
    }

    @Override
    protected void initialize() 
    {
    	gyro.reset();
    }

    @Override
    protected void execute() 
    {
        double angle = gyro.getAngle() * (-this.kP);
        
		if(this.driveTrainClass == "systems.subsystems.DiffDriveTrain")
		{
			((DiffDriveTrain) this.driveTrain).ArcadeDrive(this.speed, angle);
		}
		else
		{
			if (this.driveTrain.IsReversed() == true)
			{
				((MechDriveTrain) this.driveTrain).MecanumDrive(0, -this.speed , angle);
			}
			else
			{
				((MechDriveTrain) this.driveTrain).MecanumDrive(0, this.speed , angle);
			}
		}
    }

    @Override
    protected boolean isFinished() 
    {
        if(isTimedOut())
        {
        	return true;
        }
        else
        {
        	return false;
        }
    }

    @Override
    protected void end() 
    {
		if(this.driveTrainClass == "systems.subsystems.DiffDriveTrain")
		{
			((DiffDriveTrain) this.driveTrain).ArcadeDrive(0, 0);
		}
		else
		{
			((MechDriveTrain) this.driveTrain).MecanumDrive(0, 0, 0);

		}
    }

    protected void interrupted() 
    {
    }
}
