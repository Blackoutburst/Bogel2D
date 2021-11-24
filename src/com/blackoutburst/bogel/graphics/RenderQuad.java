package com.blackoutburst.bogel.graphics;

import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glGenBuffers;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glUseProgram;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBProgramInterfaceQuery;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL41;

import com.blackoutburst.bogel.maths.Matrix;

public class RenderQuad {

	private static int vaoID, vboVertID;
	public static Matrix model;
	
	private static float[] vertices = new float[]
	{
		-0.5f, 0.5f,	// Top left
		-0.5f, -0.5f,	// Bottom left
		0.5f, 0.5f,	 // top right
		0.5f, 0.5f,	// Top right
		-0.5f, -0.5f,	// Bottom left
		0.5f, -0.5f	 // Bottom right
	};
	
	public static void initRenderer() {
		vaoID = glGenVertexArrays();
		glBindVertexArray(vaoID);
		
		FloatBuffer verticesBuffer = BufferUtils.createFloatBuffer(vertices.length);
		verticesBuffer.put(vertices).flip();

		vboVertID = glGenBuffers();
		glBindBuffer(GL_ARRAY_BUFFER, vboVertID);
		glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);

		glVertexAttribPointer(0, 2, GL11.GL_FLOAT, false, 0, 0);
		glEnableVertexAttribArray(0);
		glBindVertexArray(0);
		
		model = new Matrix();
	}
	
	private static void setDefaultUniform(Quad quad) {
		int color_loc = ARBProgramInterfaceQuery.glGetProgramResourceLocation(quad.shaderProgram, ARBProgramInterfaceQuery.GL_UNIFORM, "color");
		GL41.glProgramUniform4f(quad.shaderProgram, color_loc, quad.color.r, quad.color.g, quad.color.b, quad.color.a);
	}
	
	private static void setMatricesUniform(Quad quad) {
		int projection_loc = ARBProgramInterfaceQuery.glGetProgramResourceLocation(quad.shaderProgram, ARBProgramInterfaceQuery.GL_UNIFORM, "projection");
		GL41.glProgramUniformMatrix4fv(quad.shaderProgram, projection_loc, false, Matrix.getValues(RenderManager.projection));
		
		int model_loc = ARBProgramInterfaceQuery.glGetProgramResourceLocation(quad.shaderProgram, ARBProgramInterfaceQuery.GL_UNIFORM, "model");
		GL41.glProgramUniformMatrix4fv(quad.shaderProgram, model_loc, false, Matrix.getValues(model));
	}
	
	public static void draw(Quad quad) {
		Matrix.setIdentity(model);
		Matrix.translate(quad.position, model);
		Matrix.scale(quad.size, model);
		Matrix.rotate(quad.rotation, model);
		
		setMatricesUniform(quad);
		if (!quad.customShader)
			setDefaultUniform(quad);
		
		glUseProgram(quad.shaderProgram);
		glBindVertexArray(vaoID);
		glDrawArrays(GL11.GL_TRIANGLES, 0, 6);
		
		glBindVertexArray(0);
		glUseProgram(0);
	}
	
	public static void clear() {
		glDisableVertexAttribArray(0);
		glBindVertexArray(0);
		glUseProgram(0);
	}
}
