package com.github.HawkEngine.Core.HawkPlayer;

import com.github.HawkEngine.Core.HawkEngine.*;
import com.github.HawkEngine.Core.HawkEngine.Events.*;

public class Player
{
	public static void main(String[] args)
	{	
		Window window = InstanceManager.InitializeWindow("Hawk Player", 1280, 720);
				
		while (!window.ShouldClose())
		{
			window.Clear(0.3294117647f, 0.72156862745f, 1.0f, 1.0f);
			window.SwapBuffers();
		}
	}
}
