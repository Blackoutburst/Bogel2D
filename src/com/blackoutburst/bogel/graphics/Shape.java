package com.blackoutburst.bogel.graphics;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_RED;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glReadPixels;
import static org.lwjgl.opengl.GL20.glAttachShader;
import static org.lwjgl.opengl.GL20.glCreateProgram;
import static org.lwjgl.opengl.GL20.glDetachShader;
import static org.lwjgl.opengl.GL20.glLinkProgram;

import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;

import com.blackoutburst.bogel.core.Camera;
import com.blackoutburst.bogel.core.Display;
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
	
	/**
	 * <p>
	 * Define the shape of the shape ?
	 * </p>
	 * 
	 * @author Blackoutburst
	 * @since 0.4
	 *
	 */
	public static enum ShapeType {
		QUAD,
		TRIANGLE,
		CIRCLE
	}
	
	protected ShapeType type;
	
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
	protected boolean reactToLight;
	
	/**
	 * <p>
	 * Initialize default shape values
	 * </p>
	 * 
	 * @since 0.2
	 * @author Blackoutburst
	 */
	private void initShape() {
		this.reactToLight = false;
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
	public Shape(ShapeType type, Texture texture) {
		this.type = type;
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
	public Shape(ShapeType type, Texture texture, float x, float y) {
		this.type = type;
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
	public Shape(ShapeType type, Texture texture, Vector2f position) {
		this.type = type;
		this.textureless = false;
		this.texture = texture;
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
	 * @param Texture texture
	 * @param Vector2f position
	 * @param Vector2f size
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape(ShapeType type, Texture texture, Vector2f position, Vector2f size) {
		this.type = type;
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
	public Shape(ShapeType type, Texture texture, Vector2f position, Vector2f size, Color color) {
		this.type = type;
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
	public Shape(ShapeType type, Texture texture, Vector2f position, Vector2f size, float rotation) {
		this.type = type;
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
	public Shape(ShapeType type, Texture texture, Vector2f position, Vector2f size, Color color, float rotation) {
		this.type = type;
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
	public Shape(ShapeType type, Texture texture, float x, float y, float w, float h) {
		this.type = type;
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
	public Shape(ShapeType type, Texture texture, float x, float y, float w, float h, Color color) {
		this.type = type;
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
	public Shape(ShapeType type, Texture texture, float x, float y, float w, float h, float rotation) {
		this.type = type;
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
	public Shape(ShapeType type, Texture texture, float x, float y, float w, float h, Color color, float rotation) {
		this.type = type;
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
	public Shape(ShapeType type) {
		this.type = type;
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
	public Shape(ShapeType type, float x, float y) {
		this.type = type;
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
	public Shape(ShapeType type, Vector2f position) {
		this.type = type;
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
	public Shape(ShapeType type, Vector2f position, Vector2f size) {
		this.type = type;
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
	public Shape(ShapeType type, Vector2f position, Vector2f size, Color color) {
		this.type = type;
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
	public Shape(ShapeType type, Vector2f position, Vector2f size, float rotation) {
		this.type = type;
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
	public Shape(ShapeType type, Vector2f position, Vector2f size, Color color, float rotation) {
		this.type = type;
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
	public Shape(ShapeType type, float x, float y, float w, float h) {
		this.type = type;
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
	public Shape(ShapeType type, float x, float y, float w, float h, Color color) {
		this.type = type;
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
	public Shape(ShapeType type, float x, float y, float w, float h, float rotation) {
		this.type = type;
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
	public Shape(ShapeType type, float x, float y, float w, float h, Color color, float rotation) {
		this.type = type;
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
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, shader.id);
		glLinkProgram(this.shaderProgram);
        glDetachShader(this.shaderProgram, this.vertexShader.id);
        glDetachShader(this.shaderProgram, shader.id);
		this.shader = new Shader();
		this.shader.setShaderProgram(this.shaderProgram);
		
		this.customShader = true;
		return (this);
	}
	
	/**
	 * <p>
	 * Set the Shape shader
	 * </p>
	 * 
	 * @param Shader shader
	 * @return Shape
	 * @since 0.2
	 * @author Blackoutburst
	 */
	private Shape setShaderInternal(Shader shader) {
		this.shaderProgram = glCreateProgram();
		glAttachShader(this.shaderProgram, this.vertexShader.id);
		glAttachShader(this.shaderProgram, shader.id);
		glLinkProgram(this.shaderProgram);
        glDetachShader(this.shaderProgram, this.vertexShader.id);
        glDetachShader(this.shaderProgram, shader.id);
		this.shader = new Shader();
		this.shader.setShaderProgram(this.shaderProgram);
		
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
	 * @deprecated
	 * @see com.blackoutburst.bogel.graphics.Shape#draw()
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
	 * @deprecated
	 * @see com.blackoutburst.bogel.graphics.Shape#draw()
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
	 * @deprecated
	 * @see com.blackoutburst.bogel.graphics.Shape#draw()
	 */
	public void drawTriangle() {
		this.isCircle = false;
		RenderTriangle.draw(this);
	}

	/**
	 * <p>
	 * Check if the shape react to light
	 * </p>
	 * 
	 * @return reactToLight
	 * @since 0.2
	 * @author Blackoutburst
	 */
	public boolean isReactToLight() {
		return reactToLight;
	}
	
	/**
	 * <p>
	 * Set if the shape react to light
	 * </p>
	 * 
	 * @param reactToLight
	 * @since 0.2
	 * @author Blackoutburst
	 */
	public Shape setReactToLight(boolean reactToLight) {
		this.reactToLight = reactToLight;
		
		if (this.reactToLight && this.textureless)
			this.setShaderInternal(Shader.defaultFragNoTextureLight);
		
		if (this.reactToLight && !this.textureless)
			this.setShaderInternal(Shader.defaultFragLight);
		
		if (!this.reactToLight && this.textureless)
			this.setShaderInternal(Shader.defaultFragNoTexture);
		
		if (!this.reactToLight && !this.textureless)
			this.setShaderInternal(Shader.defaultFrag);
		
		return (this);
	}
	
	/**
	 * <p>
	 * Render the shape on screen
	 * </p>
	 * 
	 * @since 0.4
	 * @author Blackoutburst
	 */
	public void draw() {
		switch (this.type) {
			case CIRCLE: this.isCircle = true; RenderQuad.draw(this); break;
			case QUAD: this.isCircle = false; RenderQuad.draw(this); break;
			case TRIANGLE: RenderTriangle.draw(this); break;
			default: this.isCircle = false; RenderQuad.draw(this); break;
		}
	}
	
	/**
	 * <p>
	 * Check collision between two shapes
	 * </p>
	 * 
	 * @param shape
	 * @return boolean
	 * @since 0.4
	 * @author Blackoutburst
	 */
	public boolean collideWith(Shape shape) {
		glClearColor(1, 1, 1, 1);
		glClear(GL_COLOR_BUFFER_BIT);
		
		Shape s1 = new Shape(this.type);
		s1.setPosition(this.getPosition());
		s1.setSize(this.getSize());
		s1.setRotation(this.getRotation());
		s1.setColor(new Color(0, 0, 0, 0.5f));
		
		Shape s2 = new Shape(shape.type);
		s2.setPosition(shape.getPosition());
		s2.setSize(shape.getSize());
		s2.setRotation(shape.getRotation());
		s2.setColor(new Color(0, 0, 0, 0.5f));
		
		s1.draw();
		s2.draw();
		
	    ByteBuffer pixels = BufferUtils.createByteBuffer((int) ((s1.size.x * 2) * (s1.size.y * 2)));

	    boolean collide = false;
	    
	    glReadPixels((int)(s1.position.x - (s1.size.x / 2) - Camera.getPosition().x), (int)(s1.position.y - (s1.size.y / 2) - Camera.getPosition().y), (int)s1.size.x, (int)s1.size.y, GL_RED, GL_UNSIGNED_BYTE, pixels);
	    
	    for (int i = 0; i < pixels.capacity(); i++) {
    		if ((pixels.get(i) & 0xFF) == 64)  {
	    		collide = true;
	    		break;
	    	}
	    }
	    glClearColor(Display.clearColor.r, Display.clearColor.g, Display.clearColor.b, Display.clearColor.a);
	    glClear(GL_COLOR_BUFFER_BIT);
	    
	    return (collide);
	}
	
	/**
	 * <p>
	 * Check collision between two shapes
	 * </p>
	 * 
	 * @param shape
	 * @return boolean
	 * @since 0.4
	 * @author Blackoutburst
	 */
	public boolean collideWithTexture(Shape shape) {
		glClearColor(1, 1, 1, 1);
		glClear(GL_COLOR_BUFFER_BIT);
		
		Shape s1 = new Shape(this.type);
		if (!this.textureless) s1.setTexture(this.texture);
		s1.setPosition(this.getPosition());
		s1.setSize(this.getSize());
		s1.setRotation(this.getRotation());
		s1.setColor(new Color(0, 0, 0, 0.5f));
		s1.setReactToLight(false);
		
		Shape s2 = new Shape(shape.type);
		if (!shape.textureless) s2.setTexture(shape.texture);
		s2.setPosition(shape.getPosition());
		s2.setSize(shape.getSize());
		s2.setRotation(shape.getRotation());
		s2.setColor(new Color(0, 0, 0, 0.5f));
		s2.setReactToLight(false);
		
		s1.draw();
		s2.draw();
		
	    ByteBuffer pixels = BufferUtils.createByteBuffer((int) ((s1.size.x * 2) * (s1.size.y * 2)));

	    boolean collide = false;
	    
	    glReadPixels((int)(s1.position.x - (s1.size.x / 2) - Camera.getPosition().x), (int)(s1.position.y - (s1.size.y / 2) - Camera.getPosition().y), (int)s1.size.x, (int)s1.size.y, GL_RED, GL_UNSIGNED_BYTE, pixels);
	    
	    for (int i = 0; i < pixels.capacity(); i++) {
    		if ((pixels.get(i) & 0xFF) == 64)  {
	    		collide = true;
	    		break;
	    	}
	    }
	    glClearColor(Display.clearColor.r, Display.clearColor.g, Display.clearColor.b, Display.clearColor.a);
	    glClear(GL_COLOR_BUFFER_BIT);
	    
	    return (collide);
	}
}
