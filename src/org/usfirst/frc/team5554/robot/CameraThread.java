package org.usfirst.frc.team5554.robot;

import java.util.HashMap;
import java.util.Map;

import org.opencv.core.Mat;
import org.opencv.core.Scalar;

import edu.wpi.first.wpilibj.CameraServer;
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
//		CameraServer.getInstance().startAutomaticCapture();
		/******************************Streaming Objects*******************************************/
	
		CameraHandler cameras = new CameraHandler(RobotMap.NUMBER_OF_CAMERAS,320,240);
		VideoBox screen = new VideoBox("Live Feed" , 320 , 240);
		
		cameras.SetStreamer(0);

				
		/******************************The Thread Main body***************************************/
		while (!Thread.interrupted()) 
		{
				
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