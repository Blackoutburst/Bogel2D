package com.blackoutburst.main;

import org.lwjgl.glfw.GLFW;

import com.blackoutburst.bogel.core.Core;
import com.blackoutburst.bogel.display.Display;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Display display = new Display();
		
		display.create();
		
		while (!GLFW.glfwWindowShouldClose(display.getWindow())) {
			display.clear();
			System.out.println(Core.getFPS());
			/*
			 * Draw here
			 */
			display.update();
		}
		display.destroy();
	}

}