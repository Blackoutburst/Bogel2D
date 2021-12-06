package com.blackoutburst.bogel.graphics;

import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glDetachShader;
import static org.lwjgl.opengl.GL20.glLinkProgram;

import com.blackoutburst.bogel.core.Shader;
import com.blackoutburst.bogel.maths.Vector2f;

/**
 * <h1>Shape</h1>
 * 
 * <p>
 * Create and use manage Shapes
 * </p>
 * 
 * @since 0.1
 * @author Blackoutburst
 */
public class Shape {
	
	protected boolean isCircle;
	
	protected Texture texture;
	
	protected Vector2f position;
	protected Vector2f size;
	
	protected float rotation;
	
	protected Color color;
	
	protected Shader vertexShader;
	protected Shader fragmentShader;
	protected Shader shader;
	
	protected int shaderProgram;
	
	protected boolean customShader;
	protected boolean smoothTexture;
	protected boolean textureless;
	
	
	private void initShape() {
		this.isCircle = false;
		this.smoothTexture = true;
		this.vertexShader = this.textureless ? Shader.defaultVertNoTexture : Shader.defaultVert;
		this.fragmentShader = this.textureless ? Shader.defaultFragNoTexture : Shader.defaultFrag;
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, this.fragmentShader.id);
		glLinkProgram(this.shaderProgram);
        glDetachShader(this.shaderProgram, this.vertexShader.id);
        glDetachShader(this.shaderProgram, this.fragmentShader.id);
		this.shader = new Shader();
		this.shader.setShaderProgram(this.shaderProgram);
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param Texture texture
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(Texture texture) {
		this.textureless = false;
		this.texture = texture;
		this.customShader = false;
		this.position = new Vector2f();
		this.size = new Vector2f(100, 100);
		this.rotation = 0;
		this.color = Color.WHITE;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param Texture texture
	 * @param float x
	 * @param float y
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(Texture texture, float x, float y) {
		this.textureless = false;
		this.texture = texture;
		this.customShader = false;
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(100, 100);
		this.rotation = 0;
		this.color = Color.WHITE;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param Texture texture
	 * @param Vector2f position
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(Texture texture, Vector2f position) {
		this.textureless = false;
		this.texture = texture;
		this.customShader = false;
		this.position = new Vector2f();
		this.size = new Vector2f(100, 100);
		this.rotation = 0;
		this.color = Color.WHITE;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param Texture texture
	 * @param Vector2f position
	 * @param Vector2f size
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(Texture texture, Vector2f position, Vector2f size) {
		this.textureless = false;
		this.texture = texture;
		this.customShader = false;
		this.position = position;
		this.size = size;
		this.rotation = 0;
		this.color = Color.WHITE;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param Texture texture
	 * @param Vector2f position
	 * @param Vector2f size
	 * @param Color color
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(Texture texture, Vector2f position, Vector2f size, Color color) {
		this.textureless = false;
		this.texture = texture;
		this.customShader = false;
		this.position = position;
		this.size = size;
		this.rotation = 0;
		this.color = color;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param Texture texture
	 * @param Vector2f position
	 * @param Vector2f size
	 * @param float rotation
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(Texture texture, Vector2f position, Vector2f size, float rotation) {
		this.textureless = false;
		this.texture = texture;
		this.customShader = false;
		this.position = position;
		this.size = size;
		this.rotation = rotation;
		this.color = Color.WHITE;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param Texture texture
	 * @param Vector2f position
	 * @param Vector2f size
	 * @param Color color
	 * @param float rotation
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(Texture texture, Vector2f position, Vector2f size, Color color, float rotation) {
		this.textureless = false;
		this.texture = texture;
		this.customShader = false;
		this.position = position;
		this.size = size;
		this.rotation = rotation;
		this.color = color;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param Texture texture
	 * @param float x
	 * @param float y
	 * @param float w
	 * @param float h
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(Texture texture, float x, float y, float w, float h) {
		this.textureless = false;
		this.texture = texture;
		this.customShader = false;
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(w, h);
		this.size.x = w;
		this.size.y = h;
		this.rotation = 0;
		this.color = Color.WHITE;
		initShape();
	}

	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param Texture texture
	 * @param float x
	 * @param float y
	 * @param float w
	 * @param float h
	 * @param Color color
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(Texture texture, float x, float y, float w, float h, Color color) {
		this.textureless = false;
		this.texture = texture;
		this.customShader = false;
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(w, h);
		this.color = color;
		this.rotation = 0;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param Texture texture
	 * @param float x
	 * @param float y
	 * @param float w
	 * @param float h
	 * @param float rotation
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(Texture texture, float x, float y, float w, float h, float rotation) {
		this.textureless = false;
		this.texture = texture;
		this.customShader = false;
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(w, h);
		this.size.x = w;
		this.size.y = h;
		this.rotation = rotation;
		this.color = Color.WHITE;
		initShape();
	}

	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param Texture texture
	 * @param float x
	 * @param float y
	 * @param float w
	 * @param float h
	 * @param Color color
	 * @param float rotation
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(Texture texture, float x, float y, float w, float h, Color color, float rotation) {
		this.textureless = false;
		this.texture = texture;
		this.customShader = false;
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(w, h);
		this.color = color;
		this.rotation = rotation;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape() {
		this.textureless = true;
		this.customShader = false;
		this.position = new Vector2f();
		this.size = new Vector2f(100, 100);
		this.rotation = 0;
		this.color = Color.WHITE;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param float x
	 * @param float y
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(float x, float y) {
		this.textureless = true;
		this.customShader = false;
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(100, 100);
		this.rotation = 0;
		this.color = Color.WHITE;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param Vector2f position
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(Vector2f position) {
		this.textureless = true;
		this.customShader = false;
		this.position = position;
		this.size = new Vector2f(100, 100);
		this.rotation = 0;
		this.color = Color.WHITE;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param Vector2f position
	 * @param Vector2f size
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(Vector2f position, Vector2f size) {
		this.textureless = true;
		this.customShader = false;
		this.position = position;
		this.size = size;
		this.rotation = 0;
		this.color = Color.WHITE;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param Vector2f position
	 * @param Vector2f size
	 * @param Color color
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(Vector2f position, Vector2f size, Color color) {
		this.textureless = true;
		this.customShader = false;
		this.position = position;
		this.size = size;
		this.rotation = 0;
		this.color = color;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param Vector2f position
	 * @param Vector2f size
	 * @param float rotation
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(Vector2f position, Vector2f size, float rotation) {
		this.textureless = true;
		this.customShader = false;
		this.position = position;
		this.size = size;
		this.rotation = rotation;
		this.color = Color.WHITE;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param Vector2f position
	 * @param Vector2f size
	 * @param Color color
	 * @param float rotation
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(Vector2f position, Vector2f size, Color color, float rotation) {
		this.textureless = true;
		this.customShader = false;
		this.position = position;
		this.size = size;
		this.rotation = rotation;
		this.color = color;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param float x
	 * @param float y
	 * @param float w
	 * @param float h
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(float x, float y, float w, float h) {
		this.textureless = true;
		this.customShader = false;
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(w, h);
		this.size.x = w;
		this.size.y = h;
		this.rotation = 0;
		this.color = Color.WHITE;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param float x
	 * @param float y
	 * @param float w
	 * @param float h
	 * @param Color color
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(float x, float y, float w, float h, Color color) {
		this.textureless = true;
		this.customShader = false;
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(w, h);
		this.color = color;
		this.rotation = 0;
		initShape();
	}
	
	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param float x
	 * @param float y
	 * @param float w
	 * @param float h
	 * @param float rotation
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(float x, float y, float w, float h, float rotation) {
		this.textureless = true;
		this.customShader = false;
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(w, h);
		this.size.x = w;
		this.size.y = h;
		this.rotation = rotation;
		this.color = Color.WHITE;
		initShape();
	}

	/**
	 * <p>
	 * Create a new Shape
	 * </p>
	 * 
	 * @param float x
	 * @param float y
	 * @param float w
	 * @param float h
	 * @param Color color
	 * @param float rotation
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(float x, float y, float w, float h, Color color, float rotation) {
		this.textureless = true;
		this.customShader = false;
		this.position = new Vector2f(x, y);
		this.size = new Vector2f(w, h);
		this.color = color;
		this.rotation = rotation;
		initShape();
	}

	/**
	 * <p>
	 * Get the Shape position
	 * </p>
	 * 
	 * @return Vector2f position
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector2f getPosition() {
		return position;
	}

	/**
	 * <p>
	 * Set the Shape position
	 * </p>
	 * 
	 * @param Vector2f position
	 * @return Shape
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape setPosition(Vector2f position) {
		this.position = position;
		return (this);
	}
	
	/**
	 * <p>
	 * Set the Shape position (x, y)
	 * </p>
	 * 
	 * @param float x
	 * @param float y
	 * @return Shape
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape setPosition(float x, float y) {
		this.position.x = x;
		this.position.y = y;
		return (this);
	}
	
	/**
	 * <p>
	 * Set the Shape position (pos, pos)
	 * </p>
	 * 
	 * @param float pos
	 * @return Shape
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape setPosition(float pos) {
		this.position.x = pos;
		this.position.y = pos;
		return (this);
	}

	/**
	 * <p>
	 * Get the Shape size
	 * </p>
	 * 
	 * @return Vector2f
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector2f getSize() {
		return size;
	}

	/**
	 * <p>
	 * Set the Shape size
	 * </p>
	 * 
	 * @param Vector2f size
	 * @return Shape
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape setSize(Vector2f size) {
		this.size = size;
		return (this);
	}
	
	/**
	 * <p>
	 * Set the Shape size (x, y)
	 * </p>
	 * 
	 * @param float x
	 * @param float y
	 * @return Shape
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape setSize(float x, float y) {
		this.size.x = x;
		this.size.y = y;
		return (this);
	}
	
	/**
	 * <p>
	 * Set the Shape size (size, size)
	 * </p>
	 * 
	 * @param float size
	 * @return Shape
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape setSize(float size) {
		this.size.x = size;
		this.size.y = size;
		return (this);
	}

	/**
	 * <p>
	 * Get the Shape color
	 * </p>
	 * 
	 * @return Color
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * <p>
	 * Set the Shape color
	 * </p>
	 * 
	 * @param Color color
	 * @return Shape
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape setColor(Color color) {
		this.color = color;
		return (this);
	}
	
	/**
	 * <p>
	 * Set the Shape color (r, g, b)
	 * </p>
	 * 
	 * @param float r
	 * @param float g
	 * @param float b
	 * @return Shape
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape setColor(float r, float g, float b) {
		this.color.r = r;
		this.color.g = g;
		this.color.b = b;
		return (this);
	}
	
	/**
	 * <p>
	 * Set the Shape color (r, g, b, a)
	 * </p>
	 * 
	 * @param float r
	 * @param float g
	 * @param float b
	 * @param float a
	 * @return Shape
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape setColor(float r, float g, float b, float a) {
		this.color.r = r;
		this.color.g = g;
		this.color.b = b;
		this.color.a = a;
		return (this);
	}
	
	/**
	 * <p>
	 * Set the Shape shader
	 * </p>
	 * 
	 * @param Shader shader
	 * @return Shape
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape setShader(Shader shader) {
		this.shader = shader;
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, shader.id);
		glLinkProgram(this.shaderProgram);
		glDetachShader(this.shaderProgram, this.vertexShader.id);
        glDetachShader(this.shaderProgram, shader.id);
		shader.setShaderProgram(this.shaderProgram);
		this.customShader = true;
		return (this);
	}

	/**
	 * <p>
	 * Get the Shape shader program
	 * </p>
	 * 
	 * @return int
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public int getShaderProgram() {
		return shaderProgram;
	}

	/**
	 * <p>
	 * Get the Shape rotation
	 * </p>
	 * 
	 * @return float
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public float getRotation() {
		return rotation;
	}

	/**
	 * <p>
	 * Set the Shape rotation
	 * </p>
	 * 
	 * @param float rotation
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	/**
	 * <p>
	 * Check if the Shape texture must be smoothed
	 * </p>
	 * 
	 * @return boolean
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public boolean isSmoothTexture() {
		return smoothTexture;
	}

	/**
	 * <p>
	 * Set the Shape texture smoothing parrameter
	 * </p>
	 * 
	 * @param booelan smoothTexture
	 * @return Shape
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape setSmoothTexture(boolean smoothTexture) {
		this.smoothTexture = smoothTexture;
		return (this);
	}
	
	/**
	 * <p>
	 * Get the Shape texture
	 * </p>
	 * 
	 * @return Texture
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Texture getTexture() {
		return texture;
	}

	/**
	 * <p>
	 * Set the Shape texture
	 * </p>
	 * 
	 * @param Texture texture
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setTexture(Texture texture) {
		this.textureless = false;
		this.vertexShader = Shader.defaultVert;
		this.fragmentShader = Shader.defaultFrag;
		this.texture = texture;
	}
	
	/**
	 * <p>
	 * Get the Shape texture id
	 * </p>
	 * 
	 * @return int
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public int getTextureID() {
		return (this.texture.id);
	}
	
	/**
	 * <p>
	 * Render the Shape on screen
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void drawQuad() {
		this.isCircle = false;
		RenderQuad.draw(this);
	}
	
	/**
	 * <p>
	 * Render the Shape on screen
	 * </p>
	 * 
	 * @since 0.2
	 * @author Blackoutburst
	 */
	public void drawCircle() {
		this.isCircle = true;
		RenderQuad.draw(this);
	}
	
	/**
	 * <p>
	 * Render the Shape on screen
	 * </p>
	 * 
	 * @since 0.2
	 * @author Blackoutburst
	 */
	public void drawTriangle() {
		this.isCircle = false;
		RenderTriangle.draw(this);
	}
}
