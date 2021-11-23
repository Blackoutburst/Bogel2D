package com.blackoutburst.bogel.core;

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
	
}
