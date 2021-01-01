package com.github.HawkEngine.Core.HawkEngine;

import org.junit.*;
import static org.junit.Assert.*;

public class HawkEngineTests
{
	@Test
	public void apiManagerTesting()
	{
		/* Test APIManager class */
		
		boolean graphics = APIManager.getSelectedGraphicsAPI() instanceof GraphicsAPIS;
		
		assertEquals(graphics, true);
		
		boolean window = APIManager.getSelectedWindowAPI() instanceof WindowAPIS;
		
		assertEquals(window, true);
	}
}