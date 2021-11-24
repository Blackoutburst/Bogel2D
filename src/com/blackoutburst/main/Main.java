package com.blackoutburst.main;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL20;

import com.blackoutburst.bogel.core.Shader;
import com.blackoutburst.bogel.display.Display;
import com.blackoutburst.bogel.graphics.Color;
import com.blackoutburst.bogel.graphics.Quad;
import com.blackoutburst.bogel.graphics.RenderQuad;

public class Main {
	
	public static void main(String[] args) {
		Display display = new Display();
		
		display.create();
		display.setIcons("assets/test.png");
		
		Shader shader = Shader.loadShader(GL20.GL_FRAGMENT_SHADER, "shaders/test.frag");
		
		Quad quadShader = new Quad();
		quadShader.setPosition(600, 400).setSize(200).setColor(Color.LIGHT_BLUE).setShader(shader);
		
		Quad quadSimple = new Quad(200, 200, 200, 200, Color.ORANGE, 45);
		
		while (!GLFW.glfwWindowShouldClose(display.getWindow())) {
			display.clear();
			
			
			RenderQuad.draw(quadShader);
			RenderQuad.draw(quadSimple);
			
			display.update();
		}
		display.destroy();
	}
}