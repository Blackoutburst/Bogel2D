package com.blackoutburst.bogel.graphics;

import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glCullFace;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_BACK;
import static org.lwjgl.opengl.GL11.glPolygonMode;

import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.GL_FRONT_AND_BACK;
import static org.lwjgl.opengl.GL11.GL_LINE;
import static org.lwjgl.opengl.GL11.GL_FILL;
import static org.lwjgl.opengl.GL11.GL_ONE;

import com.blackoutburst.bogel.core.Display;
import com.blackoutburst.bogel.maths.Matrix;

/**
 * <h1>RenderManager</h1>
 * 
 * <p>
 * Manger the global OpenGL render pipeline
 * </p>
 * 
 * @since 0.1
 * @author Blackoutburst
 */
public class RenderManager {
	
	/**Projection matrix*/
	public static Matrix projection = new Matrix();
	
	/**
	 * <h1>This is automatically called when creating the window</h1>
	 * <p>
	 * Initialize important values<br>
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static void init() {
		setOrtho(Display.getWidth(), Display.getHeight());
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		Lights.init();
		RenderQuad.initRenderer();
		RenderTriangle.initRenderer();
		enableCulling();
	}
	
	/**
	 * <p>
	 * Set the projection matrix and viewport<br>
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static void setOrtho(int width, int height) {
		GL11.glViewport(0, 0, width, height);
		Matrix.ortho2D(projection, 0, width, 0, height, -1, 1);
	}
	
	/**
	 * <p>
	 * Enable backface culling
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static void enableCulling() {
		glEnable(GL_CULL_FACE); 
		glCullFace(GL_BACK); 
		glDisable(GL_CULL_FACE); 
	}
	
	/**
	 * <p>
	 * Disable backface culling
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static void disableCulling() {
		glDisable(GL_CULL_FACE); 
	}
	
	/**
	 * <p>
	 * Enable additive blending
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static void enableBlending() {
		glBlendFunc(GL_SRC_ALPHA, GL_ONE);
	}
	
	/**
	 * <p>
	 * Disable additive blending
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static void disableBlending() {
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	/**
	 * <p>
	 * Enable wireframe render
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static void enableWireFrame() {
		glPolygonMode(GL_FRONT_AND_BACK , GL_LINE);
	}
	
	/**
	 * <p>
	 * Disable wireframe render
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static void disableWireFrame() {
		glPolygonMode(GL_FRONT_AND_BACK , GL_FILL);
	}
}
