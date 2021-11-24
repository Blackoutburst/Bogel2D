package com.blackoutburst.bogel.core;

import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glShaderSource;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.lwjgl.opengl.ARBProgramInterfaceQuery;
import org.lwjgl.opengl.GL41;

import com.blackoutburst.bogel.graphics.Color;
import com.blackoutburst.bogel.maths.Vector2f;
import com.blackoutburst.bogel.maths.Vector3f;
import com.blackoutburst.bogel.maths.Vector4f;

public class Shader {
	
	public int id;
	protected int shaderProgram;
	
	public Shader(int id) {
		this.id = id;
		this.shaderProgram = 0; 
	}
	
	public static Shader loadShader(int shaderType, String filePath) {
		int shader = glCreateShader(shaderType);
		
		StringBuilder shaderSource = new StringBuilder();
		try{
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			String line;
			while((line = reader.readLine())!=null){
				shaderSource.append(line).append("//\n");
			}
			reader.close();
		}catch(IOException e){
			e.printStackTrace();
			System.exit(-1);
		}
		glShaderSource(shader, shaderSource);
		glCompileShader(shader);
		return (new Shader(shader));
	}

	public void setShaderProgram(int shaderProgram) {
		this.shaderProgram = shaderProgram;
	}
	
	public void setUniform1f(String varName, float x) {
		int loc = ARBProgramInterfaceQuery.glGetProgramResourceLocation(shaderProgram, ARBProgramInterfaceQuery.GL_UNIFORM, varName);
		GL41.glProgramUniform1f(shaderProgram, loc, x);
	}
	
	public void setUniform2f(String varName, float x, float y) {
		int loc = ARBProgramInterfaceQuery.glGetProgramResourceLocation(shaderProgram, ARBProgramInterfaceQuery.GL_UNIFORM, varName);
		GL41.glProgramUniform2f(shaderProgram, loc, x, y);
		
	}
	
	public void setUniform2f(String varName, Vector2f vec) {
		int loc = ARBProgramInterfaceQuery.glGetProgramResourceLocation(shaderProgram, ARBProgramInterfaceQuery.GL_UNIFORM, varName);
		GL41.glProgramUniform2f(shaderProgram, loc, vec.x, vec.y);
	}
	
	public void setUniform3f(String varName, float x, float y, float z) {
		int loc = ARBProgramInterfaceQuery.glGetProgramResourceLocation(shaderProgram, ARBProgramInterfaceQuery.GL_UNIFORM, varName);
		GL41.glProgramUniform3f(shaderProgram, loc, x, y, z);
	}
	
	public void setUniform3f(String varName, Vector3f vec) {
		int loc = ARBProgramInterfaceQuery.glGetProgramResourceLocation(shaderProgram, ARBProgramInterfaceQuery.GL_UNIFORM, varName);
		GL41.glProgramUniform3f(shaderProgram, loc, vec.x, vec.y, vec.z);
	}
	
	public void setUniform3f(String varName, Color color) {
		int loc = ARBProgramInterfaceQuery.glGetProgramResourceLocation(shaderProgram, ARBProgramInterfaceQuery.GL_UNIFORM, varName);
		GL41.glProgramUniform3f(shaderProgram, loc, color.r, color.g, color.b);
	}
	
	public void setUniform4f(String varName, float x, float y, float z, float w) {
		int loc = ARBProgramInterfaceQuery.glGetProgramResourceLocation(shaderProgram, ARBProgramInterfaceQuery.GL_UNIFORM, varName);
		GL41.glProgramUniform4f(shaderProgram, loc, x, y, z, w);
	}
	
	public void setUniform4f(String varName, Vector4f vec) {
		int loc = ARBProgramInterfaceQuery.glGetProgramResourceLocation(shaderProgram, ARBProgramInterfaceQuery.GL_UNIFORM, varName);
		GL41.glProgramUniform4f(shaderProgram, loc, vec.x, vec.y, vec.z, vec.w);
	}
	
	public void setUniform4f(String varName, Color color) {
		int loc = ARBProgramInterfaceQuery.glGetProgramResourceLocation(shaderProgram, ARBProgramInterfaceQuery.GL_UNIFORM, varName);
		GL41.glProgramUniform4f(shaderProgram, loc, color.r, color.g, color.b, color.a);
	}
}
