package com.blackoutburst.main;

import org.lwjgl.glfw.GLFW;

import com.blackoutburst.bogel.core.Camera;
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
		
		display.setSize(750, 750).create();
		
		Camera c = new Camera();
		
		Quad q = new Quad(new Vector2f(Display.getWidth() / 2, Display.getHeight() / 2), new Vector2f(100), Color.LIGHT_BLUE.darker().darker());
		
		
		Vector2f tempMouse = new Vector2f();
		while (!GLFW.glfwWindowShouldClose(display.getWindow())) {
			display.clear();
			
			if (Mouse.getLeftButton().isPressed()) {
				tempMouse = Mouse.getPosition();
			}
			
			if (Mouse.getLeftButton().isDown()) {
				Vector2f tmp = new Vector2f(Camera.getPosition().x, Camera.getPosition().y);
				tmp.x += tempMouse.x - Mouse.getPosition().x;
				tmp.y += tempMouse.y - Mouse.getPosition().y;
				tempMouse = Mouse.getPosition();
				c.setPosition(tmp);
			}
			
			RenderManager.enableBlending();
			RenderManager.enableWireFrame();
			for (int i = 0; i < 10; i++) {
				q.setRotation(((float) Time.getRuntime() * i) / 5);
				q.setSize(500 - 50 * i);
				q.draw();
			}
			RenderManager.disableBlending();
			RenderManager.disableWireFrame();
			
			display.update();
		}
	}
}