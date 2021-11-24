package com.blackoutburst.main;

import org.lwjgl.glfw.GLFW;

import com.blackoutburst.bogel.display.Display;
import com.blackoutburst.bogel.graphics.Color;

public class Main {
	
	public static void main(String[] args) {
		Display display = new Display();
		
		display.setClearColor(Color.ORANGE);
		display.create();
		
		
		while (!GLFW.glfwWindowShouldClose(display.getWindow())) {
			display.clear();
			
			display.update();
		}
		display.destroy();
	}
}