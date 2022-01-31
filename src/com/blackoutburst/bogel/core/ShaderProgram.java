package com.blackoutburst.bogel.core;

import com.blackoutburst.bogel.graphics.Color;
import com.blackoutburst.bogel.maths.Matrix;
import com.blackoutburst.bogel.maths.Vector2f;
import com.blackoutburst.bogel.maths.Vector3f;
import com.blackoutburst.bogel.maths.Vector4f;

import static org.lwjgl.opengl.ARBProgramInterfaceQuery.GL_UNIFORM;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL20.glDetachShader;
import static org.lwjgl.opengl.GL41.glProgramUniform4f;
import static org.lwjgl.opengl.ARBProgramInterfaceQuery.glGetProgramResourceLocation;
import static org.lwjgl.opengl.GL41.glProgramUniform1f;
import static org.lwjgl.opengl.GL41.glProgramUniform2f;
import static org.lwjgl.opengl.GL41.glProgramUniform3f;
import static org.lwjgl.opengl.GL41.glProgramUniformMatrix4fv;

public class ShaderProgram {

    protected int id;

    protected Shader vertex;
    protected Shader fragment;

    /** Basic program for shape with simple color */
    public static ShaderProgram COLOR = new ShaderProgram(Shader.DEFAULT_VERTEX, Shader.DEFAULT_FRAGMENT);

    /** Basic program for shape with simple texture */
    public static ShaderProgram TEXTURE = new ShaderProgram(Shader.VERTEX_TEXTURE, Shader.FRAGMENT_TEXTURE);

    /** Basic program for shape with color and light effect */
    public static ShaderProgram COLOR_LIGHT = new ShaderProgram(Shader.DEFAULT_VERTEX, Shader.FRAGMENT_LIGHT);

    /** Basic program for shape with texture and light effect */
    public static ShaderProgram TEXTURE_LIGHT = new ShaderProgram(Shader.VERTEX_TEXTURE, Shader.FRAGMENT_TEXTURE_LIGHT);

    public ShaderProgram(Shader vertex, Shader fragment) {
        this.vertex = vertex;
        this.fragment = fragment;
        createProgram();
    }

    private void createProgram() {
        id = glCreateProgram();
        glAttachShader(id, vertex.id);
        glAttachShader(id, fragment.id);
        glLinkProgram(id);
        glDetachShader(id, vertex.id);
        glDetachShader(id, fragment.id);
    }

    public void clean() {
        glDeleteProgram(id);
    }

    public int getID() {
        return (id);
    }

    public Shader getVertex() {
        return (vertex);
    }

    public Shader getFragment() {
        return (fragment);
    }

    /**
     * <p>
     * Set a <b>float</b> uniform variable
     * </p>
     *
     * @param varName the variable name
     * @param x the x value
     * @since 0.1
     * @author Blackoutburst
     */
    public void setUniform1f(String varName, float x) {
        int loc = glGetProgramResourceLocation(id, GL_UNIFORM, varName);
        glProgramUniform1f(id, loc, x);
    }

    /**
     * <p>
     * Set a <b>vec2</b> uniform variable
     * </p>
     *
     * @param varName the variable name
     * @param x the x value
     * @param y the y value
     * @since 0.1
     * @author Blackoutburst
     */
    public void setUniform2f(String varName, float x, float y) {
        int loc = glGetProgramResourceLocation(id, GL_UNIFORM, varName);
        glProgramUniform2f(id, loc, x, y);
    }

    /**
     * <p>
     * Set a <b>vec2</b> uniform variable
     * </p>
     *
     * @param varName the variable name
     * @param vec the vector value
     * @since 0.1
     * @author Blackoutburst
     */
    public void setUniform2f(String varName, Vector2f vec) {
        int loc = glGetProgramResourceLocation(id, GL_UNIFORM, varName);
        glProgramUniform2f(id, loc, vec.x, vec.y);
    }

    /**
     * <p>
     * Set a <b>vec3</b> uniform variable
     * </p>
     *
     * @param varName the variable name
     * @param x the x value
     * @param y the y value
     * @param z the z value
     * @since 0.1
     * @author Blackoutburst
     */
    public void setUniform3f(String varName, float x, float y, float z) {
        int loc = glGetProgramResourceLocation(id, GL_UNIFORM, varName);
        glProgramUniform3f(id, loc, x, y, z);
    }

    /**
     * <p>
     * Set a <b>vec3</b> uniform variable
     * </p>
     *
     * @param varName the variable name
     * @param vec the vector value
     * @since 0.1
     * @author Blackoutburst
     */
    public void setUniform3f(String varName, Vector3f vec) {
        int loc = glGetProgramResourceLocation(id, GL_UNIFORM, varName);
        glProgramUniform3f(id, loc, vec.x, vec.y, vec.z);
    }

    /**
     * <p>
     * Set a <b>vec3</b> uniform variable
     * </p>
     *
     * @param varName the variable name
     * @param color the color value
     * @since 0.1
     * @author Blackoutburst
     */
    public void setUniform3f(String varName, Color color) {
        int loc = glGetProgramResourceLocation(id, GL_UNIFORM, varName);
        glProgramUniform3f(id, loc, color.r, color.g, color.b);
    }

    /**
     * <p>
     * Set a <b>vec4</b> uniform variable
     * </p>
     *
     * @param varName the variable name
     * @param x the x value
     * @param y the y value
     * @param z the z value
     * @param w the w value
     * @since 0.1
     * @author Blackoutburst
     */
    public void setUniform4f(String varName, float x, float y, float z, float w) {
        int loc = glGetProgramResourceLocation(id, GL_UNIFORM, varName);
        glProgramUniform4f(id, loc, x, y, z, w);
    }

    /**
     * <p>
     * Set a <b>vec4</b> uniform variable
     * </p>
     *
     * @param varName the variable name
     * @param vec the vector value
     * @since 0.1
     * @author Blackoutburst
     */
    public void setUniform4f(String varName, Vector4f vec) {
        int loc = glGetProgramResourceLocation(id, GL_UNIFORM, varName);
        glProgramUniform4f(id, loc, vec.x, vec.y, vec.z, vec.w);
    }

    /**
     * <p>
     * Set a <b>vec4</b> uniform variable
     * </p>
     *
     * @param varName the variable name
     * @param color the color value
     * @since 0.1
     * @author Blackoutburst
     */
    public void setUniform4f(String varName, Color color) {
        int loc = glGetProgramResourceLocation(id, GL_UNIFORM, varName);
        glProgramUniform4f(id, loc, color.r, color.g, color.b, color.a);
    }

    /**
     * <p>
     * Set a <b>mat4</b> uniform variable
     * </p>
     *
     * @param varName the variable name
     * @param mat the matrix value
     * @since 0.1
     * @author Blackoutburst
     */
    public void setUniformMat4(String varName, Matrix mat) {
        int loc = glGetProgramResourceLocation(id, GL_UNIFORM, varName);
        glProgramUniformMatrix4fv(id, loc, false, Matrix.getValues(mat));
    }

}
