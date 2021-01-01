package com.github.HawkEngine.Core.HawkEngine.Windows;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;
import com.github.HawkEngine.Core.HawkEngine.*;
import com.github.HawkEngine.Core.HawkEngine.Events.*;

public class GLFWPlatformWindow extends Window
{
	private long handle;
	
	public void SwapBuffers()
	{
		glfwSwapBuffers(handle);
		glfwPollEvents();
	}
	
	public boolean ShouldClose()
	{
		return glfwWindowShouldClose(handle);
	}
	
	public void Initialize(String title, int width, int height)
	{
		GLFWErrorCallback.createPrint(System.err).set();
		
		if(!glfwInit())
		{
			System.err.println("[HawkEngine (GLFW Logger[FATAL])] Failed to initialize GLFW!");
		}
		
		glfwDefaultWindowHints();
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
		
		this.handle = glfwCreateWindow(width, height, title, NULL, NULL);
		
		if(this.handle == NULL)
		{
			System.err.println("[HawkEngine (GLFW Logger[FATAL])] Failed to initialize GLFW window!");
		}
		
		glfwSetKeyCallback(this.handle, (handle, key, scancode, action, mods) -> 
		{
			if(action == GLFW_PRESS || action == GLFW_REPEAT)
			{
				InputManager.RunInputEvent(key);
			}
		});
		
		try(MemoryStack stack = stackPush())
		{
			IntBuffer pWidth = stack.mallocInt(1);
			IntBuffer pHeight = stack.mallocInt(1);
			
			glfwGetWindowSize(handle, pWidth, pHeight);
			
			GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
			
			glfwSetWindowPos(handle, (vidmode.width() - pWidth.get(0)) / 2, (vidmode.height() - pHeight.get(0)) / 2);
		}
		
		glfwMakeContextCurrent(handle);
		
		glfwShowWindow(handle);
		
		GL.createCapabilities();
	}
	
	public void Clear(float r, float g, float b, float a)
	{
		glClearColor(r, g, b, a);
		glClear(GL_COLOR_BUFFER_BIT);
	}
}
