package com.blackoutburst.bogel.graphics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import static org.lwjgl.opengl.GL30.*;

public class RenderQuad {

	private static int vertexShader, fragmentShader, shaderProgram, vaoID, vboVertID;
	
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
	}
	
	public static void renderQuad() {
		glUseProgram(shaderProgram);
		glBindVertexArray(vaoID);
		glDrawArrays(GL11.GL_TRIANGLES, 0, 6);
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
