package com.blackoutburst.main;

import org.lwjgl.glfw.GLFW;

import com.blackoutburst.bogel.display.Display;
import com.blackoutburst.bogel.graphics.Color;
import com.blackoutburst.bogel.graphics.Quad;
import com.blackoutburst.bogel.graphics.RenderQuad;
import com.blackoutburst.bogel.maths.Vector2f;

public class Main {
	public static void main(String[] args) {
		Display display = new Display();
		
		display.create();
		
		Quad quad = new Quad();
		quad.setPosition(new Vector2f(100, 200)).setSize(new Vector2f(50)).setColor(Color.LIGHT_BLUE);
		
		while (!GLFW.glfwWindowShouldClose(display.getWindow())) {
			display.clear();
			RenderQuad.renderQuad(quad);
			display.update();
		}
		display.destroy();
	}
}