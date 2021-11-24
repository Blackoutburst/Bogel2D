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
import static org.lwjgl.opengl.GL11.GL_FRONT_AND_BACK;
import static org.lwjgl.opengl.GL11.GL_LINE;
import static org.lwjgl.opengl.GL11.GL_FILL;
import static org.lwjgl.opengl.GL11.GL_ONE;

import com.blackoutburst.bogel.display.Display;
import com.blackoutburst.bogel.maths.Matrix;

public class RenderManager {
	
	public static Matrix projection = new Matrix();

	public static void init(Display display) {
		Matrix.ortho2D(projection, 0, display.getWidth(), 0, display.getHeight(), -1, 1);
		
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		
		RenderQuad.initRenderer();
		enableCulling();
	}
	
	public static void enableCulling() {
		glEnable(GL_CULL_FACE); 
		glCullFace(GL_BACK); 
		glDisable(GL_CULL_FACE); 
	}
	
	public static void disableCulling() {
		glDisable(GL_CULL_FACE); 
	}
	
	public static void enableBlending() {
		glBlendFunc(GL_SRC_ALPHA, GL_ONE);
	}
	
	public static void disableBlending() {
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
	}
	
	public static void enableWireFrame() {
		glPolygonMode(GL_FRONT_AND_BACK , GL_LINE);
	}
	
	public static void disableWireFrame() {
		glPolygonMode(GL_FRONT_AND_BACK , GL_FILL);
	}
	
}
