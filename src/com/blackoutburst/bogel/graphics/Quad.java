package com.blackoutburst.bogel.graphics;

import static org.lwjgl.opengl.GL20.GL_FRAGMENT_SHADER;
import static org.lwjgl.opengl.GL20.GL_VERTEX_SHADER;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glLinkProgram;

import com.blackoutburst.bogel.core.Shader;
import com.blackoutburst.bogel.maths.Vector2f;

public class Quad {
	protected Vector2f position;
	protected Vector2f size;
	protected Color color;
	protected Shader vertexShader;
	protected Shader fragmentShader;
	protected int shaderProgram;
	
	public Quad() {
		this.position = new Vector2f();
		this.size = new Vector2f();
		this.color = Color.WHITE;
		this.vertexShader = Shader.loadShader(GL_VERTEX_SHADER, "shaders/quad.vert");
		this.fragmentShader = Shader.loadShader(GL_FRAGMENT_SHADER, "shaders/quad.frag");
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, this.fragmentShader.id);
		glLinkProgram(this.shaderProgram);
	}
	
	public Quad(Vector2f position, Vector2f size) {
		this.position = position;
		this.size = size;
		this.color = Color.WHITE;
		this.vertexShader = Shader.loadShader(GL_VERTEX_SHADER, "shaders/quad.vert");
		this.fragmentShader = Shader.loadShader(GL_FRAGMENT_SHADER, "shaders/quad.frag");
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, this.fragmentShader.id);
		glLinkProgram(this.shaderProgram);
	}
	
	public Quad(Vector2f position, Vector2f size, Color color) {
		this.position = position;
		this.size = size;
		this.color = color;
		this.vertexShader = Shader.loadShader(GL_VERTEX_SHADER, "shaders/quad.vert");
		this.fragmentShader = Shader.loadShader(GL_FRAGMENT_SHADER, "shaders/quad.frag");
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, this.fragmentShader.id);
		glLinkProgram(this.shaderProgram);
	}
	
	public Quad(float x, float y, float w, float h) {
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(w, h);
		this.size.x = w;
		this.size.y = h;
		this.color = Color.WHITE;
		this.vertexShader = Shader.loadShader(GL_VERTEX_SHADER, "shaders/quad.vert");
		this.fragmentShader = Shader.loadShader(GL_FRAGMENT_SHADER, "shaders/quad.frag");
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, this.fragmentShader.id);
		glLinkProgram(this.shaderProgram);
	}

	public Quad(float x, float y, float w, float h, Color color) {
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(w, h);
		this.color = color;
		this.vertexShader = Shader.loadShader(GL_VERTEX_SHADER, "shaders/quad.vert");
		this.fragmentShader = Shader.loadShader(GL_FRAGMENT_SHADER, "shaders/quad.frag");
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, this.fragmentShader.id);
		glLinkProgram(this.shaderProgram);
	}

	public Vector2f getPosition() {
		return position;
	}

	public Quad setPosition(Vector2f position) {
		this.position = position;
		return (this);
	}
	
	public Quad setPosition(float x, float y) {
		this.position.x = x;
		this.position.y = y;
		return (this);
	}
	
	public Quad setPosition(float pos) {
		this.position.x = pos;
		this.position.y = pos;
		return (this);
	}

	public Vector2f getSize() {
		return size;
	}

	public Quad setSize(Vector2f size) {
		this.size = size;
		return (this);
	}
	
	public Quad setSize(float x, float y) {
		this.size.x = x;
		this.size.y = y;
		return (this);
	}
	
	public Quad setSize(float size) {
		this.size.x = size;
		this.size.y = size;
		return (this);
	}

	public Color getColor() {
		return color;
	}

	public Quad setColor(Color color) {
		this.color = color;
		return (this);
	}
	
	public Quad setColor(float r, float g, float b) {
		this.color.r = r;
		this.color.g = g;
		this.color.b = b;
		return (this);
	}
	
	public Quad setColor(float r, float g, float b, float a) {
		this.color.r = r;
		this.color.g = g;
		this.color.b = b;
		this.color.a = a;
		return (this);
	}
	
	public Quad setShader(Shader shader) {
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, shader.id);
		glLinkProgram(this.shaderProgram);
		return (this);
	}

	public int getShaderProgram() {
		return shaderProgram;
	}
}
