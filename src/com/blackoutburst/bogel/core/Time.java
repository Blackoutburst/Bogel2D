package com.blackoutburst.bogel.core;

import org.lwjgl.glfw.GLFW;

public class Time {

	private static long init = System.nanoTime();
	private static final double UPDATE = 1000000000.0 / 60.0;
	
	public static boolean doUpdate() {
		if (System.nanoTime() - Time.init > Time.UPDATE) {
			Time.init += Time.UPDATE;
			return (true);
		}
		return (false);
	}
	
	public static double getRuntime() {
		return (GLFW.glfwGetTime());
	}
}
