package com.blackoutburst.bogel.graphics;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_LINEAR;
import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_INT;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glDrawElements;
import static org.lwjgl.opengl.GL11.glTexParameteri;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_ELEMENT_ARRAY_BUFFER;
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
import java.nio.IntBuffer;

import org.lwjgl.BufferUtils;

import com.blackoutburst.bogel.core.Camera;
import com.blackoutburst.bogel.maths.Matrix;

public class RenderQuad {

	private static int vaoID;
	public static Matrix model;
	
	private static float[] vertices = new float[]
	{
		0.5f, -0.5f, 1.0f, 1.0f, // Bottom right
		0.5f, 0.5f, 1.0f, 0.0f, // Top right
		-0.5f, 0.5f, 0.0f, 0.0f,  // Top left
		-0.5f, -0.5f, 0.0f, 1.0f // Bottom left
	};
	 
	private static int indices[] = {
		0, 1, 3,
		1, 2, 3
	}; 
	
	public static void initRenderer() {
		vaoID = glGenVertexArrays();
		int vbo = glGenBuffers();
		int ebo = glGenBuffers();
		
		glBindVertexArray(vaoID);
		
		FloatBuffer verticesBuffer = BufferUtils.createFloatBuffer(vertices.length);
		verticesBuffer.put(vertices).flip();

		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);
		
		IntBuffer indicesBuffer = BufferUtils.createIntBuffer(indices.length);
		indicesBuffer.put(indices).flip();
		
		
		glVertexAttribPointer(0, 2, GL_FLOAT, false, 16, 0);
		glEnableVertexAttribArray(0);
		
		// UV
		glVertexAttribPointer(1, 2, GL_FLOAT, false, 16, 8);
		glEnableVertexAttribArray(1);
		
		glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, ebo);
		glBufferData(GL_ELEMENT_ARRAY_BUFFER, indicesBuffer, GL_STATIC_DRAW); 
		
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		
		model = new Matrix();
	}
	
	private static void setDefaultUniform(Quad quad) {
		quad.shader.setUniform4f("color", quad.color);
	}
	
	private static void setMatricesUniform(Quad quad) {
		quad.shader.setUniformMat4("projection", RenderManager.projection);
		quad.shader.setUniformMat4("model", model);
		quad.shader.setUniformMat4("view", Camera.getMatrix());
	}
	
	private static void setTransformation(Quad quad) {
		Matrix.setIdentity(model);
		Matrix.translate(quad.position, model);
		Matrix.scale(quad.size, model);
		Matrix.rotate(quad.rotation, model);
	}
	
	private static void setTextureParrameter(Quad quad) {
		if (quad.texture.missing) {
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		} else {
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, quad.isSmoothTexture() ? GL_LINEAR : GL_NEAREST);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, quad.isSmoothTexture() ? GL_LINEAR : GL_NEAREST);
		}
	}
	
	public static void draw(Quad quad) {
		if (!quad.textureless)
			glBindTexture(GL_TEXTURE_2D, quad.getTextureID());
		
		if (quad.texture != null)
			setTextureParrameter(quad);
		
		setTransformation(quad);
		setMatricesUniform(quad);
		
		if (!quad.customShader)
			setDefaultUniform(quad);
		
		glUseProgram(quad.shaderProgram);
		glBindVertexArray(vaoID);
		glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, 0);
		glBindVertexArray(0);
		glUseProgram(0);
		glBindTexture(GL_TEXTURE_2D, 0);
	}
	
	public static void clear() {
		glDisableVertexAttribArray(0);
		glBindVertexArray(0);
		glUseProgram(0);
	}
}
