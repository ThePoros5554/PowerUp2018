package org.usfirst.frc.team5554.robot;


import edu.wpi.first.wpilibj.Joystick;
import vision.CameraHandler;
import vision.Stream;
import vision.VideoBox;

public class CameraThread extends Thread
{
	private Joystick joy;
	public static boolean toSwitch = false;
		
	public CameraThread(Joystick cameraManager)
	{
		joy = cameraManager;
	}
	
	@Override	
	public void run()
	{		
		/******************************Streaming Objects*******************************************/
		int liveCamera = 0;
		
		boolean ignoreSwitch = false;
		boolean ignoreClimb = false;

		
		CameraHandler cameras = new CameraHandler(RobotMap.NUMBER_OF_CAMERAS,320,240);
		VideoBox screen = new VideoBox("Live Feed" , 320 , 240);
		
		cameras.SetStreamer(0);
				
		/******************************The Thread Main body***************************************/
		while (!Thread.interrupted()) 
		{

				
				
				if(joy.getRawButton(RobotMap.SWITCHCAMERABUTTON) && ignoreSwitch == false)
				{
					ignoreSwitch = true;

					if(liveCamera == RobotMap.FORWARDCAMERA)
					{
						liveCamera = RobotMap.CUBECAMERA;
					}
					else
					{
						liveCamera = RobotMap.FORWARDCAMERA;
					}
				}
				else if(!joy.getRawButton(RobotMap.SWITCHCAMERABUTTON))
				{
					ignoreSwitch = false;
				}
				
				//climb
				if(joy.getRawButton(RobotMap.CLIMBCAMERABUTTON) && ignoreClimb == false)
				{
					ignoreClimb = true;

					liveCamera = RobotMap.CLIMBCAMERA;
					
				}
				else if(!joy.getRawButton(RobotMap.CLIMBCAMERABUTTON))
				{
					ignoreClimb = false;
				}
				
				cameras.SetStreamer(liveCamera);
				
				Stream stream = cameras.GetStream();
				
				if (stream.GetReport() == 0) 
				{
					
					continue;
				}
				else
				{
					screen.stream(stream.GetImage());
				}
		}
	}
	
}