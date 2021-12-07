package com.blackoutburst.bogel.graphics;

import static org.lwjgl.opengl.GL11.GL_ONE;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;

import java.util.ArrayList;
import java.util.List;

import com.blackoutburst.bogel.core.Display;
import com.blackoutburst.bogel.core.Shader;

/**
 * 
 * <p>
 * Manager and render lights on screen
 * </p>
 * 
 * @author Blackoutburst
 * @since 0.2
 *
 */
public class Lights {
	
	/** The list of lights used limited to 100 */
	protected static List<Light> lights = new ArrayList<Light>();
	
	/** The plane used to draw lights*/
	private static Shape plane;
	
	/**
	 * <p>
	 * Initialize important values
	 * </p>
	 * 
	 * @author Blackoutburst
	 * @since 0.2
	 */
	protected static void init() {
		plane = new Shape();
		plane.setShader(Shader.lightsShader);
	}
	
	/**
	 * <p>
	 * Draw every lights on screen<br>
	 * <b>CALL AFTER DRAWING EVERY ELEMENTS OTHERWISE THEY MIGHT TURN INVISIBLE</b>
	 * </p>
	 * 
	 * @author Blackoutburst
	 * @since 0.2 
	 */
	public static void draw() {
		plane.setPosition(Display.getWidth() / 2, Display.getHeight() / 2);
		plane.setSize(Display.getSizeF());
		
		plane.shader.setUniform2f("resolution", Display.getSizeF());
		
		for (int i = 0; i < 100; i++) {
			if (i >= lights.size()) break;
			
			Light l = lights.get(i);
			plane.shader.setUniform2f("lights["+i+"].position", l.getPosition());
			plane.shader.setUniform3f("lights["+i+"].color", l.getColor());
			plane.shader.setUniform1f("lights["+i+"].intensity", l.getIntensity());
		}
		
		glBlendFunc(GL_ONE, GL_ONE);
		plane.drawQuad();
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
}
