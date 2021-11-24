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
		display.setDecoration(true).setSize(1280, 720);
		display.create();
		Quad q = new Quad(new Vector2f(), Display.getSizeF(), Color.ORANGE.darker().darker().darker());
		
		Camera c = new Camera();
		
		Vector2f tempMouse = new Vector2f();
		
		while (!GLFW.glfwWindowShouldClose(display.getWindow())) {
			display.clear();
			
			if (Mouse.getLeftButton().isPressed()) {
				tempMouse = Mouse.getPosition();
			}
			
			if (Mouse.getLeftButton().isDown()) {
				Vector2f tmp = new Vector2f(c.getPosition().x, c.getPosition().y);
				tmp.x += tempMouse.x - Mouse.getPosition().x;
				tmp.y += tempMouse.y - Mouse.getPosition().y;
				tempMouse = Mouse.getPosition();
				c.setPosition(tmp);
			}
			c.setPositionZ(c.getPosition().z + Mouse.getScroll() / 10);
			
			RenderManager.enableBlending();
			RenderManager.enableWireFrame();
			
			for (int i = 0; i < 10; i++) {
				q.draw();
				q.setRotation(5 * i + (float) Time.getRuntime());
				q.setSize(100 - 10 * i);
			}
			
			RenderManager.disableWireFrame();
			RenderManager.disableBlending();
			
			display.update();
		}
	}
}