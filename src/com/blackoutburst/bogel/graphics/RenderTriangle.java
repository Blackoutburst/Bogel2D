package com.blackoutburst.bogel.graphics;

import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL11.GL_LINEAR;
import static org.lwjgl.opengl.GL11.GL_NEAREST;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MAG_FILTER;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_MIN_FILTER;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL11.glTexParameteri;
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

import java.nio.Buffer;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

import com.blackoutburst.bogel.core.Camera;
import com.blackoutburst.bogel.core.Display;
import com.blackoutburst.bogel.maths.Matrix;

/**
 * <h1>RenderQuad</h1>
 * 
 * <p>
 * Manger the quad render process
 * </p>
 * 
 * @since 0.1
 * @author Blackoutburst
 */
public class RenderTriangle {

	private static int vaoID;
	
	/**Model matrix*/
	public static Matrix model;
	
	private static float[] vertices = new float[]
	{
		-0.5f, -0.5f, 0.0f, 0.0f, // Left
		0.5f, -0.5f, 1.0f, 0.0f, // Right
		0.0f, 0.5f, 0.5f, 1.0f,  // Top
	};
	 
	
	/**
	 * <p>
	 * Initialize important values<br>
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	protected static void initRenderer() {
		vaoID = glGenVertexArrays();
		int vbo = glGenBuffers();
		
		glBindVertexArray(vaoID);
		
		FloatBuffer verticesBuffer = BufferUtils.createFloatBuffer(vertices.length);
		((Buffer) verticesBuffer.put(vertices)).flip();

		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, verticesBuffer, GL_STATIC_DRAW);
		
		glVertexAttribPointer(0, 2, GL_FLOAT, false, 16, 0);
		glEnableVertexAttribArray(0);
		
		glVertexAttribPointer(1, 2, GL_FLOAT, false, 16, 8);
		glEnableVertexAttribArray(1);
		
		model = new Matrix();
	}
	
	/**
	 * <p>
	 * Set default shader uniform
	 * </p>
	 * 
	 * @param quad
	 * @since 0.1
	 * @author Blackoutburst
	 */
	private static void setDefaultUniform(Shape quad) {
		quad.shader.setUniform4f("color", quad.color);
	}
	
	/**
	 * <p>
	 * Set default shader matrices
	 * </p>
	 * 
	 * @param quad
	 * @since 0.1
	 * @author Blackoutburst
	 */
	private static void setMatricesUniform(Shape quad) {
		quad.shader.setUniformMat4("projection", RenderManager.projection);
		quad.shader.setUniformMat4("model", model);
		quad.shader.setUniformMat4("view", Camera.getMatrix());
	}
	
	/**
	 * <p>
	 * Apply quad transformation
	 * </p>
	 * 
	 * @param quad
	 * @since 0.1
	 * @author Blackoutburst
	 */
	private static void setTransformation(Shape quad) {
		Matrix.setIdentity(model);
		Matrix.translate(quad.position, model);
		Matrix.scale(quad.size, model);
		Matrix.rotate(quad.rotation, model);
	}
	
	/**
	 * <p>
	 * Apply quad texture processing
	 * </p>
	 * 
	 * @param quad
	 * @since 0.1
	 * @author Blackoutburst
	 */
	private static void setTextureParrameter(Shape quad) {
		if (quad.texture.missing) {
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		} else {
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, quad.isSmoothTexture() ? GL_LINEAR : GL_NEAREST);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, quad.isSmoothTexture() ? GL_LINEAR : GL_NEAREST);
		}
	}
	
	/**
	 * <p>
	 * Check if the quad is out of frame
	 * </p>
	 * 
	 * @param quad
	 * @since 0.1
	 * @author Blackoutburst
	 */
	private static boolean outOfFrame(Shape quad) {
		if ((quad.position.x + quad.size.x / 2) < (Camera.getPosition().x))
			return (true);
		if ((quad.position.x - quad.size.x / 2) > (Display.getWidth() + Camera.getPosition().x))
			return (true);
		if ((quad.position.y - quad.size.y / 2) > (Display.getHeight() + Camera.getPosition().y))
			return (true);
		if ((quad.position.y + quad.size.y / 2) < (Camera.getPosition().y))
			return (true);
		
		return (false);
	}
	
	/**
	 * <p>
	 * Render the quad on screen
	 * </p>
	 * 
	 * @param quad
	 * @since 0.1
	 * @author Blackoutburst
	 */
	protected static void draw(Shape quad) {
		if (outOfFrame(quad)) return;
		
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
		glDrawArrays(GL_TRIANGLES, 0, 3);
		glBindVertexArray(0);
		glUseProgram(0);
		glBindTexture(GL_TEXTURE_2D, 0);
	}
	
	/**
	 * <h1>This is automatically called after closing the window</h1>
	 * <p>
	 * Clean important values<br>
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static void clear() {
		glDisableVertexAttribArray(0);
		glBindVertexArray(0);
		glUseProgram(0);
	}
}
