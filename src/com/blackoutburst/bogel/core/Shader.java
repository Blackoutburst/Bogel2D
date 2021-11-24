package com.blackoutburst.bogel.core;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glShaderSource;
import static org.lwjgl.opengl.GL41.glProgramUniform1f;
import static org.lwjgl.opengl.GL41.glProgramUniform2f;
import static org.lwjgl.opengl.GL41.glProgramUniform3f;
import static org.lwjgl.opengl.GL41.glProgramUniform4f;
import static org.lwjgl.opengl.GL41.glProgramUniformMatrix4fv;
import static org.lwjgl.opengl.ARBProgramInterfaceQuery.glGetProgramResourceLocation;
import static org.lwjgl.opengl.ARBProgramInterfaceQuery.GL_UNIFORM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.blackoutburst.bogel.graphics.Color;
import com.blackoutburst.bogel.maths.Matrix;
import com.blackoutburst.bogel.maths.Vector2f;
import com.blackoutburst.bogel.maths.Vector3f;
import com.blackoutburst.bogel.maths.Vector4f;

public class Shader {
	
	public int id;
	protected int shaderProgram;
	
	public static final int VERTEX = GL_VERTEX_SHADER;
	public static final int FRAGMENT = GL_FRAGMENT_SHADER;
	
	public static Shader defaultVert;
	public static Shader defaultFrag;
	public static Shader defaultVertNoTexture;
	public static Shader defaultFragNoTexture;

	public Shader() {
		this.id = 0;
		this.shaderProgram = 0; 
	}
	
	public Shader(int id) {
		this.id = id;
		this.shaderProgram = 0; 
	}
	
	public static void init() {
		defaultVert = loadShader(VERTEX, "shaders/quad.vert");
		defaultFrag = loadShader(FRAGMENT, "shaders/quad.frag");
		defaultVertNoTexture = loadShader(VERTEX, "shaders/quadNoTexture.vert");
		defaultFragNoTexture = loadShader(FRAGMENT, "shaders/quadNoTexture.frag");
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
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform1f(shaderProgram, loc, x);
	}
	
	public void setUniform2f(String varName, float x, float y) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform2f(shaderProgram, loc, x, y);
		
	}
	
	public void setUniform2f(String varName, Vector2f vec) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform2f(shaderProgram, loc, vec.x, vec.y);
	}
	
	public void setUniform3f(String varName, float x, float y, float z) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform3f(shaderProgram, loc, x, y, z);
	}
	
	public void setUniform3f(String varName, Vector3f vec) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform3f(shaderProgram, loc, vec.x, vec.y, vec.z);
	}
	
	public void setUniform3f(String varName, Color color) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform3f(shaderProgram, loc, color.r, color.g, color.b);
	}
	
	public void setUniform4f(String varName, float x, float y, float z, float w) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform4f(shaderProgram, loc, x, y, z, w);
	}
	
	public void setUniform4f(String varName, Vector4f vec) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform4f(shaderProgram, loc, vec.x, vec.y, vec.z, vec.w);
	}
	
	public void setUniform4f(String varName, Color color) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform4f(shaderProgram, loc, color.r, color.g, color.b, color.a);
	}
	
	public void setUniformMat4(String varName, Matrix mat) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniformMatrix4fv(shaderProgram, loc, false, Matrix.getValues(mat));
	}
}
