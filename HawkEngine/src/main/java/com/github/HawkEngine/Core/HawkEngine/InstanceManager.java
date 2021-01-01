package com.github.HawkEngine.Core.HawkEngine;

import com.github.HawkEngine.Core.HawkEngine.Windows.*;

public class InstanceManager
{
	/** This variable shows if the InstanceManager has created a window instance yet. */
	
	public static boolean hasWindowInstance = false;
	
	/** Initializes a window instance using the current window API
	 * 
	 * @param title The window title.
	 * @param width The window width in pixels.
	 * @param height The window height in pixels.
	 * @return The new window instance the function created. */
	
	public static Window InitializeWindow(String title, int width, int height)
	{
		WindowAPIS windowApi = APIManager.getSelectedWindowAPI();
		
		switch(windowApi)
		{
		case GLFW:
			InstanceManager.hasWindowInstance = true;
			
			Window instance = new GLFWPlatformWindow();
			instance.Initialize(title, width, height);
			
			return instance;
		case Unknown:
			System.err.println("[HawkEngine (InstanceManager[Window(FATAL)])] No Window API selected!");
			
			throw new NullPointerException("Failed to create new window using HawkEngine InstanceManager!");
		}
		
		return null;
	}
}
