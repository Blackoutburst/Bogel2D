package com.blackoutburst.main;

import org.lwjgl.glfw.GLFW;

import com.blackoutburst.bogel.core.Shader;
import com.blackoutburst.bogel.core.Time;
import com.blackoutburst.bogel.display.Display;
import com.blackoutburst.bogel.graphics.Color;
import com.blackoutburst.bogel.graphics.Quad;
import com.blackoutburst.bogel.graphics.RenderQuad;
import com.blackoutburst.bogel.maths.Vector2f;

public class Main {
	
	public static void main(String[] args) {
		Display display = new Display();
		display.setTransparent(true);
		display.setClearColor(Color.TRANSPARENT);
		display.create();
		
		Shader shader = Shader.loadShader(Shader.FRAGMENT, "shaders/test2.frag");
		
		Quad quad = new Quad(new Vector2f(Display.getWidth() / 2, Display.getHeight() / 2), Display.getSizeF());
		quad.setShader(shader);
		
		shader.setUniform2f("resolution", Display.getSizeF());
		
		while (!GLFW.glfwWindowShouldClose(display.getWindow())) {
			display.clear();
			
			shader.setUniform1f("time", (float) Time.getRuntime());
			
			RenderQuad.draw(quad);
			
			display.update();
		}
		display.destroy();
	}
}