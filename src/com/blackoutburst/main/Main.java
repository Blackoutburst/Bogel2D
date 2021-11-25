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
		
		Quad q = new Quad();
		
		while (!GLFW.glfwWindowShouldClose(Display.getWindow())) {
			display.clear();
			q.draw();
			display.update();
			
			if (Time.doUpdate()) {
				if (Keyboard.isKeyDown(Keyboard.W))
					q.setPosition(q.getPosition().x, q.getPosition().y + 10);
				if (Keyboard.isKeyDown(Keyboard.S))
					q.setPosition(q.getPosition().x, q.getPosition().y - 10);
				if (Keyboard.isKeyDown(Keyboard.D))
					q.setPosition(q.getPosition().x + 10, q.getPosition().y);
				if (Keyboard.isKeyDown(Keyboard.A))
					q.setPosition(q.getPosition().x - 10, q.getPosition().y);
			}
		}
	}
}