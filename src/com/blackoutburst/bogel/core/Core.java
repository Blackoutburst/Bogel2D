package com.blackoutburst.bogel.core;

import com.blackoutburst.bogel.display.Display;
import com.blackoutburst.bogel.graphics.RenderManager;
import com.blackoutburst.bogel.graphics.RenderQuad;

/**
 * <h1>Core</h1>
 * 
 * <p>
 * Contains vital function for the library<br>
 * Some of them must <b>NOT</b> be called<br>
 * </p>
 *
 * 
 * @since 0.1
 * @author Blackoutburst
 *
 */
public class Core {
		
	private static int renderPasses = 0;
	private static int fps = 0;
	private static double previousTime = Time.getRuntime();
	
	/**
	 * <p>
	 * Return the current framerate
	 * </p>
	 * 
	 * @return int FPS
	 * @since 0.1
	 * @author Blackoutburst
	 */
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
	
	/**
	 * <p>
	 * Initialize important values<br>
	 * Must <b>NOT</b> be called
	 * </p>
	 * 
	 * @param Display display
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static void init(Display display) {
		RenderManager.init();
		Shader.init();
	}
	
	/**
	 * <p>
	 * Update important values<br>
	 * Must <b>NOT</b> be called
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static void update() {
		Mouse.getLeftButton().reset();
		Mouse.getRightButton().reset();
		Mouse.getMiddleButton().reset();
		Mouse.setScroll(0);
	}
	
	/**
	 * <p>
	 * Clean important values<br>
	 * Must <b>NOT</b> be called
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static void clear() {
		RenderQuad.clear();
	}
	
}
