package com.blackoutburst.main;

import org.lwjgl.glfw.GLFW;

import com.blackoutburst.bogel.display.Display;
import com.blackoutburst.bogel.graphics.Quad;

public class Main {
	
	public static void main(String[] args) {
		Display display = new Display();
		
		display.create();
		Quad q = new Quad();
		
		while (!GLFW.glfwWindowShouldClose(display.getWindow())) {
			display.clear();
			
			q.draw();
			
			display.update();
		}
		display.destroy();
	}
}