package com.blackoutburst.main;

import org.lwjgl.glfw.GLFW;

import com.blackoutburst.bogel.core.Mouse;
import com.blackoutburst.bogel.core.Time;
import com.blackoutburst.bogel.display.Display;
import com.blackoutburst.bogel.graphics.Color;
import com.blackoutburst.bogel.graphics.Quad;
import com.blackoutburst.bogel.graphics.RenderManager;
import com.blackoutburst.bogel.maths.Vector2f;

public class Main {
	
	public static void main(String[] args) {
		Display display = new Display();
		display.setDecoration(true).setSize(150, 150);
		display.create();
		Quad q = new Quad(new Vector2f(Display.getWidth() / 2, Display.getHeight() / 2), Display.getSizeF(), Color.ORANGE.darker().darker().darker());
		
		while (!GLFW.glfwWindowShouldClose(display.getWindow())) {
			display.clear();
			
			RenderManager.enableBlending();
			RenderManager.enableWireFrame();
			
			for (int i = 0; i < 10; i++) {
				q.draw();
				q.setPosition(Mouse.getPosition());
				q.setRotation(5 * i + (float) Time.getRuntime());
				q.setSize(100 - 10 * i);
			}
			
			RenderManager.disableWireFrame();
			RenderManager.disableBlending();
			
			display.update();
		}
	}
}