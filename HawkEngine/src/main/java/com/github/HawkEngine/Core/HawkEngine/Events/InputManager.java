package com.github.HawkEngine.Core.HawkEngine.Events;

import java.util.*;

/** The class that manages keyboard input. */

public class InputManager
{
	/** The HashMap that contains a key code and the specified function when it is pressed. */
	
	private static Map<Integer, KeyboardEvent> inputMap = new HashMap<>();
	
	/** Run the function linked to the specified key code.
	 * 
	 *  @param keyCode The specified key code.
	 *  @return This is a void function, it returns nothing.
	 *  */
	
	public static void RunInputEvent(int keyCode)
	{
		InputManager.inputMap.get(keyCode).OnKey();
	}
	
	
	/** This function adds a key code with a linked input event to the input map
	 * 
	 * @param keyCode The specified key code.
	 * @param event The linked keyboard event.
	 * @return This is a void function, it returns nothing. */
	
	public static void AddInputEvent(int keyCode, KeyboardEvent event)
	{
		InputManager.inputMap.put(keyCode, event);
	}
	
	/** This function removes a key code from the input map.
	 * 
	 * @param keyCode The specified key code.
	 * @return This is a void function, it returns nothing. */
	
	public static void RemoveInputEvent(int keyCode)
	{
		InputManager.inputMap.remove(keyCode);
	}
}