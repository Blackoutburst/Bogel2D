package com.blackoutburst.bogel.core;

import static org.lwjgl.opengl.GL20.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Shader {
	
	public int id;
	
	public Shader(int id) {
		this.id = id;
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
}
