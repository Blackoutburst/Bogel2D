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
	protected float rotation;
	protected Color color;
	protected Shader vertexShader;
	protected Shader fragmentShader;
	protected int shaderProgram;
	public boolean customShader;
	
	public Quad() {
		customShader = false;
		this.position = new Vector2f();
		this.size = new Vector2f();
		this.rotation = 0;
		this.color = Color.WHITE;
		this.vertexShader = Shader.loadShader(GL_VERTEX_SHADER, "shaders/quad.vert");
		this.fragmentShader = Shader.loadShader(GL_FRAGMENT_SHADER, "shaders/quad.frag");
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, this.fragmentShader.id);
		glLinkProgram(this.shaderProgram);
	}
	
	public Quad(Vector2f position, Vector2f size) {
		customShader = false;
		this.position = position;
		this.size = size;
		this.rotation = 0;
		this.color = Color.WHITE;
		this.vertexShader = Shader.loadShader(GL_VERTEX_SHADER, "shaders/quad.vert");
		this.fragmentShader = Shader.loadShader(GL_FRAGMENT_SHADER, "shaders/quad.frag");
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, this.fragmentShader.id);
		glLinkProgram(this.shaderProgram);
	}
	
	public Quad(Vector2f position, Vector2f size, Color color) {
		customShader = false;
		this.position = position;
		this.size = size;
		this.rotation = 0;
		this.color = color;
		this.vertexShader = Shader.loadShader(GL_VERTEX_SHADER, "shaders/quad.vert");
		this.fragmentShader = Shader.loadShader(GL_FRAGMENT_SHADER, "shaders/quad.frag");
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, this.fragmentShader.id);
		glLinkProgram(this.shaderProgram);
	}
	
	public Quad(Vector2f position, Vector2f size, float rotation) {
		customShader = false;
		this.position = position;
		this.size = size;
		this.rotation = rotation;
		this.color = Color.WHITE;
		this.vertexShader = Shader.loadShader(GL_VERTEX_SHADER, "shaders/quad.vert");
		this.fragmentShader = Shader.loadShader(GL_FRAGMENT_SHADER, "shaders/quad.frag");
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, this.fragmentShader.id);
		glLinkProgram(this.shaderProgram);
	}
	
	public Quad(Vector2f position, Vector2f size, Color color, float rotation) {
		customShader = false;
		this.position = position;
		this.size = size;
		this.rotation = rotation;
		this.color = color;
		this.vertexShader = Shader.loadShader(GL_VERTEX_SHADER, "shaders/quad.vert");
		this.fragmentShader = Shader.loadShader(GL_FRAGMENT_SHADER, "shaders/quad.frag");
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, this.fragmentShader.id);
		glLinkProgram(this.shaderProgram);
	}
	
	public Quad(float x, float y, float w, float h) {
		customShader = false;
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(w, h);
		this.size.x = w;
		this.size.y = h;
		this.rotation = 0;
		this.color = Color.WHITE;
		this.vertexShader = Shader.loadShader(GL_VERTEX_SHADER, "shaders/quad.vert");
		this.fragmentShader = Shader.loadShader(GL_FRAGMENT_SHADER, "shaders/quad.frag");
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, this.fragmentShader.id);
		glLinkProgram(this.shaderProgram);
	}

	public Quad(float x, float y, float w, float h, Color color) {
		customShader = false;
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(w, h);
		this.color = color;
		this.rotation = 0;
		this.vertexShader = Shader.loadShader(GL_VERTEX_SHADER, "shaders/quad.vert");
		this.fragmentShader = Shader.loadShader(GL_FRAGMENT_SHADER, "shaders/quad.frag");
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, this.fragmentShader.id);
		glLinkProgram(this.shaderProgram);
	}
	
	public Quad(float x, float y, float w, float h, float rotation) {
		customShader = false;
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(w, h);
		this.size.x = w;
		this.size.y = h;
		this.rotation = rotation;
		this.color = Color.WHITE;
		this.vertexShader = Shader.loadShader(GL_VERTEX_SHADER, "shaders/quad.vert");
		this.fragmentShader = Shader.loadShader(GL_FRAGMENT_SHADER, "shaders/quad.frag");
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, this.fragmentShader.id);
		glLinkProgram(this.shaderProgram);
	}

	public Quad(float x, float y, float w, float h, Color color, float rotation) {
		customShader = false;
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(w, h);
		this.color = color;
		this.rotation = rotation;
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
		shader.setShaderProgram(this.shaderProgram);
		customShader = true;
		return (this);
	}

	public int getShaderProgram() {
		return shaderProgram;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	
}
