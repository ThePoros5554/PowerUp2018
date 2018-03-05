package org.usfirst.frc.team5554.robot;

import java.util.HashMap;
import java.util.Map;
import org.opencv.core.Scalar;
import edu.wpi.first.wpilibj.Joystick;
import vision.CameraHandler;
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
	
		CameraHandler cameras = new CameraHandler(RobotMap.NUMBER_OF_CAMERAS,320,240);
		VideoBox screen = new VideoBox(320 , 240 , "Live Feed");		
				
		/******************************The Thread Main body***************************************/
		while (!Thread.interrupted()) 
		{
				cameras.SetStreamer(RobotMap.LIVECAMERA);
				screen.stream(cameras.GetStream());						
		}
	}
	
}