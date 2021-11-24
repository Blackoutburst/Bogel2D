package com.blackoutburst.bogel.core;

import com.blackoutburst.bogel.display.Display;
import com.blackoutburst.bogel.graphics.RenderManager;
import com.blackoutburst.bogel.graphics.RenderQuad;

public class Core {
		
	private static int renderPasses = 0;
	private static int fps = 0;
	private static double previousTime = Time.getRuntime();
	
	public static int getFPS() {
		double currentTime = Time.getRuntime();
		renderPasses++;
		
		if (currentTime - previousTime >= 1.0) {
			fps = renderPasses;
			renderPasses = 0;
			previousTime = currentTime;
		}
		return (fps);
	}
	
	public static void init(Display display) {
		RenderManager.init();
		Shader.init();
	}
	
	public static void update() {
		Mouse.getLeftButton().reset();
		Mouse.getRightButton().reset();
		Mouse.getMiddleButton().reset();
	}
	
	public static void clear() {
		RenderQuad.clear();
	}
	
}
