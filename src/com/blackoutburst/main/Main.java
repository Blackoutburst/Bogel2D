package com.blackoutburst.main;

import org.lwjgl.glfw.GLFW;

import com.blackoutburst.bogel.core.Keyboard;
import com.blackoutburst.bogel.core.Time;
import com.blackoutburst.bogel.display.Display;
import com.blackoutburst.bogel.graphics.Quad;

public class Main {
	
	public static void main(String[] args) {
		Display display = new Display();
		display.create();
		display.setVSync(true);
		
		Quad q = new Quad();
		
		float x = 0;
		float y = 0;
		
		
		while (!GLFW.glfwWindowShouldClose(Display.getWindow())) {
			display.clear();
			
			q.draw();
			q.setPosition(x , y);
			
			display.update();
			
			if (Time.doUpdate()) {
				if (Keyboard.isKeyDown(Keyboard.W))
					y += 10;
				if (Keyboard.isKeyDown(Keyboard.S))
					y -= 10;
				if (Keyboard.isKeyDown(Keyboard.D))
					x += 10;
				if (Keyboard.isKeyDown(Keyboard.A))
					x -= 10;
			}
		}
	}
}