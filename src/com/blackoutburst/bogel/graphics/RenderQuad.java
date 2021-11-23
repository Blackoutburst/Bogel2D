package com.blackoutburst.bogel.graphics;

import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glGenBuffers;
import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glDeleteShader;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glLinkProgram;
import static org.lwjgl.opengl.GL20.glShaderSource;
import static org.lwjgl.opengl.GL20.glUseProgram;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBProgramInterfaceQuery;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL41;

import com.blackoutburst.bogel.maths.Matrix;
import com.blackoutburst.bogel.maths.Vector2f;

public class RenderQuad {

	private static int vertexShader, fragmentShader, shaderProgram, vaoID, vboVertID;
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
		vertexShader = glCreateShader(GL_VERTEX_SHADER);
		
		StringBuilder vertexShaderSource = new StringBuilder();
		try{
			BufferedReader reader = new BufferedReader(new FileReader("shaders/shader.vert"));
			String line;
			while((line = reader.readLine())!=null){
				vertexShaderSource.append(line).append("//\n");
			}
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
			System.exit(-1);
		}
		
		glShaderSource(vertexShader, vertexShaderSource);
		glCompileShader(vertexShader);
		
		
		fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
		
		StringBuilder fragmentShaderSource = new StringBuilder();
		try{
			BufferedReader reader = new BufferedReader(new FileReader("shaders/shader.frag"));
			String line;
			while((line = reader.readLine())!=null){
				fragmentShaderSource.append(line).append("//\n");
			}
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
			System.exit(-1);
		}
		
		glShaderSource(fragmentShader, fragmentShaderSource);
		glCompileShader(fragmentShader);
		
		shaderProgram = glCreateProgram();
		
		glAttachShader(shaderProgram, vertexShader);
		glAttachShader(shaderProgram, fragmentShader);
		glLinkProgram(shaderProgram);
		
		glUseProgram(shaderProgram);
		
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
	
	public static void renderQuad(Vector2f position, Vector2f size) {
		
		Matrix.setIdentity(model);
		
		Matrix.translate(position, model);
		Matrix.scale(size, model);
		
		glUseProgram(shaderProgram);
		glBindVertexArray(vaoID);
		glDrawArrays(GL11.GL_TRIANGLES, 0, 6);
		
		int model_loc = ARBProgramInterfaceQuery.glGetProgramResourceLocation(shaderProgram, ARBProgramInterfaceQuery.GL_UNIFORM, "model");
		GL41.glProgramUniformMatrix4fv(shaderProgram, model_loc, false, Matrix.getValues(model));
		
		int projection_loc = ARBProgramInterfaceQuery.glGetProgramResourceLocation(shaderProgram, ARBProgramInterfaceQuery.GL_UNIFORM, "projection");
		GL41.glProgramUniformMatrix4fv(shaderProgram, projection_loc, false, Matrix.getValues(RenderManager.projection));
		
		glBindVertexArray(0);
		glUseProgram(0);
	}
	
	public static void clear() {
		glDisableVertexAttribArray(0);
		glBindVertexArray(0);
		glUseProgram(0);
		glDeleteShader(vertexShader);
		glDeleteShader(fragmentShader);  
	}
}
