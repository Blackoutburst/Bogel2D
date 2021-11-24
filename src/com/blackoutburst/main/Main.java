package com.blackoutburst.main;

import org.lwjgl.glfw.GLFW;

import com.blackoutburst.bogel.core.Shader;
import com.blackoutburst.bogel.core.Time;
import com.blackoutburst.bogel.display.Display;
import com.blackoutburst.bogel.graphics.Color;
import com.blackoutburst.bogel.graphics.Quad;
import com.blackoutburst.bogel.graphics.RenderManager;
import com.blackoutburst.bogel.graphics.RenderQuad;
import com.blackoutburst.bogel.graphics.Texture;
import com.blackoutburst.bogel.maths.Vector2f;

public class Main {
	
	public static void main(String[] args) {
		Display display = new Display();
		display.create();
		
		Shader shader = Shader.loadShader(Shader.FRAGMENT, "shaders/test2.frag");
		
		Quad quad = new Quad(new Texture("assets/Logo.png"), new Vector2f(450, 250), new Vector2f(200), new Color (1, 1, 1, 0.5f));
		
		Quad quad2 = new Quad(new Texture("assets/test.png"), new Vector2f(1280 / 2, 720 / 2), new Vector2f(300));
		
		Quad q3 = new Quad(new Vector2f(100), new Vector2f(25), Color.ORANGE);
		Quad q4 = new Quad(new Texture("assets/light.png"), new Vector2f(100), new Vector2f(50), Color.ORANGE);
		
		Quad q5 = new Quad(new Vector2f(150, 100), new Vector2f(25), Color.ORANGE);
		Quad q6 = new Quad(new Texture("assets/light.png"), new Vector2f(150, 100), new Vector2f(50), Color.ORANGE);
		
		Quad q7 = new Quad(new Texture("assets/diamond.png"), new Vector2f(100, 400), new Vector2f(200));
		q7.setSmoothTexture(false);
		
		Quad q8 = new Quad(new Vector2f(1000, 400), new Vector2f(300, 200));
		q8.setShader(shader);
		
		shader.setUniform2f("resolution", display.getSizeF());
		
		while (!GLFW.glfwWindowShouldClose(display.getWindow())) {
			display.clear();
			
			shader.setUniform1f("time", (float) Time.getRuntime());
			quad2.setRotation((float) Time.getRuntime());
			
			RenderManager.enableBlending();
			RenderQuad.draw(q3);
			RenderQuad.draw(q4);
			RenderManager.disableBlending();
			
			RenderQuad.draw(q5);
			RenderQuad.draw(q6);
			
			RenderQuad.draw(q7);
			RenderQuad.draw(q8);
			
			RenderQuad.draw(quad2);
			RenderQuad.draw(quad);
			
			display.update();
		}
		display.destroy();
	}
}