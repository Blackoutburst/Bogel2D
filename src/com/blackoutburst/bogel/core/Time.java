package com.blackoutburst.bogel.core;

import org.lwjgl.glfw.GLFW;

/**
 * <h1>Time</h1>
 * 
 * <p>
 * manager Time
 * </p>
 * 
 * @since 0.1
 * @author Blackoutburst
 */
public class Time {

	private static long init = System.nanoTime();
	private static final double UPDATE = 1000000000.0 / 60.0;
	
	/**
	 * <p>
	 * A very important function used to fix the game update at a rate of 60 time per seconds<br>
	 * Use this inside your main loop to prevent the game running at CPU speed
	 * </p>
	 * 
	 * <pre>
	 * while (Display.isOpen()) {
	 *   display.clear();
	 *   
	 *   //draw game
	 *   
	 *   if (Time.doUpdate()) {
	 *     //update game logic
	 *   }
	 *   
	 *   display.update();
	 * }
	 * </pre>
	 * 
	 * @return boolean canUpdate
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static boolean doUpdate() {
		if (System.nanoTime() - Time.init > Time.UPDATE) {
			Time.init += Time.UPDATE;
			return (true);
		}
		return (false);
	}
	
	/**
	 * <p>
	 * Give the time since the program started
	 * </p>
	 * 
	 * @return double time
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static double getRuntime() {
		return (GLFW.glfwGetTime());
	}
}
