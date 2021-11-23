package com.blackoutburst.main;

import org.lwjgl.glfw.GLFW;

import com.blackoutburst.bogel.core.Core;
import com.blackoutburst.bogel.display.Display;
import com.blackoutburst.bogel.graphics.Color;
import com.blackoutburst.bogel.graphics.RenderQuad;
import com.blackoutburst.bogel.maths.Vector2f;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Display display = new Display();
		
		display.setTransparent(true)
		.setClearColor(Color.TRANSPARENT)
		.setDecoration(false)
		.create()
		.setVSync(false);
		
		while (!GLFW.glfwWindowShouldClose(display.getWindow())) {
			display.clear();
			RenderQuad.renderQuad(new Vector2f(1280 / 2, 720 / 2), new Vector2f(400));
			System.out.println("FPS: "+Core.getFPS());
			display.update();
		}
		display.destroy();
	}
}