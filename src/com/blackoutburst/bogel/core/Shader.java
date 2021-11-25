package com.blackoutburst.bogel.core;

import static org.lwjgl.opengl.ARBProgramInterfaceQuery.GL_UNIFORM;
import static org.lwjgl.opengl.ARBProgramInterfaceQuery.glGetProgramResourceLocation;
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.blackoutburst.bogel.graphics.Color;
import com.blackoutburst.bogel.maths.Matrix;
import com.blackoutburst.bogel.maths.Vector2f;
import com.blackoutburst.bogel.maths.Vector3f;
import com.blackoutburst.bogel.maths.Vector4f;

/**
 * <h1>Shader</h1>
 * 
 * <p>
 * Create and manager shaders
 * </p>
 * 
 * @since 0.1
 * @author Blackoutburst
 */
public class Shader {
	
	protected int shaderProgram;
	
	/**The shader id*/
	public int id;
	
	/**Vertex shader type*/
	public static final int VERTEX = GL_VERTEX_SHADER;
	
	/**Fragment shader type*/
	public static final int FRAGMENT = GL_FRAGMENT_SHADER;
	
	/**Default vertex shader*/
	public static Shader defaultVert;
	
	/**Default fragment shader*/
	public static Shader defaultFrag;
	
	/**Default vertex shader with no texture*/
	public static Shader defaultVertNoTexture;
	
	/**Default fragment shader with no texture*/
	public static Shader defaultFragNoTexture;

	/**
	 * <p>
	 * Create a new empty shader
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shader() {
		this.id = 0;
		this.shaderProgram = 0; 
	}
	
	/**
	 * <p>
	 * Create a new empty shader with a specific id
	 * </p>
	 * 
	 * @deprecated
	 * @param int id
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shader(int id) {
		this.id = id;
		this.shaderProgram = 0; 
	}
	
	/**
	 * <h1>THIS IS USED FOR INTERNAL FUNCTIONEMENT DO NOT USE</h1>
	 * 
	 * <p>
	 * Load default shaders into memory
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static void init() {
		defaultVert = loadShader(VERTEX, "quad.vert");
		defaultFrag = loadShader(FRAGMENT, "quad.frag");
		defaultVertNoTexture = loadShader(VERTEX, "quadNoTexture.vert");
		defaultFragNoTexture = loadShader(FRAGMENT, "quadNoTexture.frag");
	}
	
	/**
	 * <p>
	 * Create a new shader from a file
	 * </p>
	 * 
	 * @param int shaderType
	 * @param String filePath
	 * @return Shader shader
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static Shader loadShader(int shaderType, String filePath) {
		int shader = glCreateShader(shaderType);
		
		StringBuilder shaderSource = new StringBuilder();
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(Shader.class.getResourceAsStream("/"+filePath)));
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

	/**
	 * <p>
	 * Set the shader program
	 * </p>
	 * 
	 * @param int shaderProgram
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setShaderProgram(int shaderProgram) {
		this.shaderProgram = shaderProgram;
	}
	
	/**
	 * <p>
	 * Set a <b>float</b> uniform variable
	 * </p>
	 * 
	 * @param String varName
	 * @param float x
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setUniform1f(String varName, float x) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform1f(shaderProgram, loc, x);
	}
	
	/**
	 * <p>
	 * Set a <b>vec2</b> uniform variable
	 * </p>
	 * 
	 * @param String varName
	 * @param float x
	 * @param float y
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setUniform2f(String varName, float x, float y) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform2f(shaderProgram, loc, x, y);
	}
	
	/**
	 * <p>
	 * Set a <b>vec2</b> uniform variable
	 * </p>
	 * 
	 * @param String varName
	 * @param Vector2f vec
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setUniform2f(String varName, Vector2f vec) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform2f(shaderProgram, loc, vec.x, vec.y);
	}
	
	/**
	 * <p>
	 * Set a <b>vec3</b> uniform variable
	 * </p>
	 * 
	 * @param String varName
	 * @param float x
	 * @param float y
	 * @param float z
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setUniform3f(String varName, float x, float y, float z) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform3f(shaderProgram, loc, x, y, z);
	}
	
	/**
	 * <p>
	 * Set a <b>vec3</b> uniform variable
	 * </p>
	 * 
	 * @param String varName
	 * @param Vector3f vec
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setUniform3f(String varName, Vector3f vec) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform3f(shaderProgram, loc, vec.x, vec.y, vec.z);
	}
	
	/**
	 * <p>
	 * Set a <b>vec3</b> uniform variable
	 * </p>
	 * 
	 * @param String varName
	 * @param Color color
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setUniform3f(String varName, Color color) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform3f(shaderProgram, loc, color.r, color.g, color.b);
	}
	
	/**
	 * <p>
	 * Set a <b>vec4</b> uniform variable
	 * </p>
	 * 
	 * @param String varName
	 * @param float x
	 * @param float y
	 * @param float z
	 * @param float w
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setUniform4f(String varName, float x, float y, float z, float w) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform4f(shaderProgram, loc, x, y, z, w);
	}
	
	/**
	 * <p>
	 * Set a <b>vec4</b> uniform variable
	 * </p>
	 * 
	 * @param String varName
	 * @param Vector4f vec
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setUniform4f(String varName, Vector4f vec) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform4f(shaderProgram, loc, vec.x, vec.y, vec.z, vec.w);
	}
	
	/**
	 * <p>
	 * Set a <b>vec4</b> uniform variable
	 * </p>
	 * 
	 * @param String varName
	 * @param Color color
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setUniform4f(String varName, Color color) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniform4f(shaderProgram, loc, color.r, color.g, color.b, color.a);
	}
	
	/**
	 * <p>
	 * Set a <b>mat4</b> uniform variable
	 * </p>
	 * 
	 * @param String varName
	 * @param Matrix mat
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setUniformMat4(String varName, Matrix mat) {
		int loc = glGetProgramResourceLocation(shaderProgram, GL_UNIFORM, varName);
		glProgramUniformMatrix4fv(shaderProgram, loc, false, Matrix.getValues(mat));
	}
}
