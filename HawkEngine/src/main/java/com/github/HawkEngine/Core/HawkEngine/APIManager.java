package com.github.HawkEngine.Core.HawkEngine;

/** The manager to select the APIs of the engine. */

public class APIManager
{
	/** The selected graphics API the engine uses. (default: OpenGL) */
	
	private static GraphicsAPIS selectedGraphicsAPI = GraphicsAPIS.OpenGL;
	
	/** The selected window API the engine uses. (default: GLFW) */
	
	private static WindowAPIS selectedWindowAPI = WindowAPIS.GLFW;
	
	/** Gets the selected graphics API.
	 * 
	 * @return The selected graphics API.*/
	
	public static GraphicsAPIS getSelectedGraphicsAPI()
	{
		return APIManager.selectedGraphicsAPI;
	}

	/** Sets the selected graphics API.
	 * 
	 * @param selectedGraphicsAPI The value to set the selected graphics API to.
	 * @return This is a void function, it returns nothing.*/
	
	public static void setSelectedGraphicsAPI(GraphicsAPIS selectedGraphicsAPI)
	{
		APIManager.selectedGraphicsAPI = selectedGraphicsAPI;
	}
	
	/** Gets the selected window API.
	 * 
	 * @return The selected window API.*/
	
	public static WindowAPIS getSelectedWindowAPI() {
		return APIManager.selectedWindowAPI;
	}
	
	/** Sets the selected window API.
	 * 
	 * @param selectedWindowAPI The value to set the selected window API to.
	 * @return This is a void function, it returns nothing.*/
	
	public static void setSelectedWindowAPI(WindowAPIS selectedWindowAPI)
	{
		APIManager.selectedWindowAPI = selectedWindowAPI;
	}
}