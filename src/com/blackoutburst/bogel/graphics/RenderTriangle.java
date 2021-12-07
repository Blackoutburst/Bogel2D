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
 * <h1>RenderTriangle</h1>
 * 
 * <p>
 * Manger the triangle render process
 * </p>
 * 
 * @since 0.2
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
	 * @since 0.2
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
	 * @param shape
	 * @since 0.2
	 * @author Blackoutburst
	 */
	private static void setDefaultUniform(Shape shape) {
		shape.shader.setUniform4f("color", shape.color);
		shape.shader.setUniform1f("radius", 1.0f);
	}
	
	/**
	 * <p>
	 * Set default shader matrices
	 * </p>
	 * 
	 * @param shape
	 * @since 0.2
	 * @author Blackoutburst
	 */
	private static void setMatricesUniform(Shape shape) {
		shape.shader.setUniformMat4("projection", RenderManager.projection);
		shape.shader.setUniformMat4("model", model);
		shape.shader.setUniformMat4("view", Camera.getMatrix());
	}
	
	/**
	 * <p>
	 * Apply shape transformation
	 * </p>
	 * 
	 * @param shape
	 * @since 0.2
	 * @author Blackoutburst
	 */
	private static void setTransformation(Shape shape) {
		Matrix.setIdentity(model);
		Matrix.translate(shape.position, model);
		Matrix.scale(shape.size, model);
		Matrix.rotate(shape.rotation, model);
	}
	
	/**
	 * <p>
	 * Apply shape texture processing
	 * </p>
	 * 
	 * @param shape
	 * @since 0.2
	 * @author Blackoutburst
	 */
	private static void setTextureParrameter(Shape shape) {
		if (shape.texture.missing) {
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
		} else {
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, shape.isSmoothTexture() ? GL_LINEAR : GL_NEAREST);
			glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, shape.isSmoothTexture() ? GL_LINEAR : GL_NEAREST);
		}
	}
	
	/**
	 * <p>
	 * Check if the shape is out of frame
	 * </p>
	 * 
	 * @param shape
	 * @since 0.2
	 * @author Blackoutburst
	 */
	private static boolean outOfFrame(Shape shape) {
		if ((shape.position.x + shape.size.x / 2) < (Camera.getPosition().x))
			return (true);
		if ((shape.position.x - shape.size.x / 2) > (Display.getWidth() + Camera.getPosition().x))
			return (true);
		if ((shape.position.y - shape.size.y / 2) > (Display.getHeight() + Camera.getPosition().y))
			return (true);
		if ((shape.position.y + shape.size.y / 2) < (Camera.getPosition().y))
			return (true);
		
		return (false);
	}
	
	/**
	 * <p>
	 * Set default shader uniform
	 * </p>
	 * 
	 * @param shape
	 * @since 0.2
	 * @author Blackoutburst
	 */
	private static void setLightUniform(Shape shape) {
		shape.shader.setUniform2f("resolution", Display.getSizeF());
		shape.shader.setUniform3f("ambiant", Lights.ambiant);
		
		for (int i = 0; i < 100; i++) {
			if (i >= Lights.lights.size()) break;
			
			Light l = Lights.lights.get(i);
			shape.shader.setUniform2f("lights["+i+"].position", l.getPosition());
			shape.shader.setUniform3f("lights["+i+"].color", l.getColor());
			shape.shader.setUniform1f("lights["+i+"].intensity", l.getIntensity());
		}
	}
	
	/**
	 * <p>
	 * Render the shape on screen
	 * </p>
	 * 
	 * @param shape
	 * @since 0.2
	 * @author Blackoutburst
	 */
	protected static void draw(Shape shape) {
		if (outOfFrame(shape)) return;
		
		if (shape.reactToLight)
			setLightUniform(shape);
		
		if (!shape.textureless)
			glBindTexture(GL_TEXTURE_2D, shape.getTextureID());
		
		if (shape.texture != null)
			setTextureParrameter(shape);
		
		setTransformation(shape);
		setMatricesUniform(shape);
		
		if (!shape.customShader)
			setDefaultUniform(shape);
		
		glUseProgram(shape.shaderProgram);
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
	 * @since 0.2
	 * @author Blackoutburst
	 */
	public static void clear() {
		glDisableVertexAttribArray(0);
		glBindVertexArray(0);
		glUseProgram(0);
	}
}
