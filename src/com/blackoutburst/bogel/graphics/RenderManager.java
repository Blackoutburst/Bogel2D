package com.blackoutburst.bogel.graphics;

import org.lwjgl.opengl.GL11;

import com.blackoutburst.bogel.display.Display;
import com.blackoutburst.bogel.maths.Matrix;

public class RenderManager {
	
	public static Matrix projection = new Matrix();

	public static void init(Display display) {
		Matrix.ortho2D(projection, 0, display.getWidth(), 0, display.getHeight(), -1, 1);
		
		RenderQuad.initRenderer();
		enableCulling(true);
	}
	
	public static void enableCulling(boolean enable) {
		if (enable) {
			GL11.glEnable(GL11.GL_CULL_FACE); 
			GL11.glCullFace(GL11.GL_BACK); 
		} else {
			GL11.glDisable(GL11.GL_CULL_FACE); 
		}
	}
	
	public static void enableWireFrame(boolean enable) {
		if (enable) {
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK , GL11.GL_LINE);
		} else {
			GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK , GL11.GL_FILL);
		}
	}
	
}
