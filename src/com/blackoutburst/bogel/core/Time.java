package com.blackoutburst.bogel.core;

import org.lwjgl.glfw.GLFW;

public class Time {

	public static double getRuntime() {
		return (GLFW.glfwGetTime());
	}
}
