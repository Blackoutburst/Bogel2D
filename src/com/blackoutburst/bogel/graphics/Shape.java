package com.blackoutburst.bogel.graphics;

import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_RED;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glReadPixels;

import java.nio.ByteBuffer;

import com.blackoutburst.bogel.core.ShaderProgram;
import org.lwjgl.BufferUtils;

import com.blackoutburst.bogel.core.Camera;
import com.blackoutburst.bogel.core.Display;
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
	public enum ShapeType {
		QUAD,
		TRIANGLE,
		CIRCLE
	}
	
	protected ShapeType type;

	protected Texture texture;

	protected Vector2f position;
	protected Vector2f size;

	protected float rotation;

	protected Color color;

	protected ShaderProgram shaderProgram;

	protected boolean isCircle;
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
		color = Color.WHITE;
		reactToLight = false;
		isCircle = type == ShapeType.CIRCLE;
		smoothTexture = true;
	}

	public Shape(ShapeType type, Texture texture, Vector2f position, Vector2f size, float rotation) {
		this.type = type;
		this.textureless = false;
		this.texture = texture;
		this.position = position;
		this.size = size;
		this.rotation = rotation;
		this.shaderProgram = ShaderProgram.TEXTURE;
		initShape();
	}

	public Shape(ShapeType type, Vector2f position, Vector2f size, float rotation) {
		this.type = type;
		this.textureless = true;
		this.position = position;
		this.size = size;
		this.rotation = rotation;
		this.shaderProgram = ShaderProgram.COLOR;
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
	 * @param position shape position
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
	 * @param x shape x position
	 * @param y shape y position
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
	 * @param size shape size
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
	 * @param width shape width
	 * @param height shape height
	 * @return Shape
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape setSize(float width, float height) {
		this.size.x = width;
		this.size.y = height;
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
	 * @param color shape color
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
	 * @param r shape color red
	 * @param g shape color green
	 * @param b shape color blue
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
	 * @param r shape color red
	 * @param g shape color green
	 * @param b shape color blue
	 * @param a shape color alpha
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
	 * Set the Shape shader program
	 * </p>
	 *
	 * @return Shape
	 * @param program the new shader program
	 * @since 0.5
	 * @author Blackoutburst
	 */
	public Shape setShaderProgram(ShaderProgram program) {
		this.shaderProgram = program;
		return (this);
	}

	/**
	 * <p>
	 * Get the Shape shader program
	 * </p>
	 * 
	 * @return ShaderProgram
	 * @since 0.5
	 * @author Blackoutburst
	 */
	public ShaderProgram getShaderProgram() {
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
	 * @param rotation shape rotation
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Shape setRotation(float rotation) {
		this.rotation = rotation;
		return (this);
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
	 * Set the Shape texture smoothing parameter
	 * </p>
	 * 
	 * @param smoothTexture define if the texture must be smoothed when up/down scaled
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
	 * @param reactToLight make the shape react to light
	 * @since 0.2
	 * @author Blackoutburst
	 */
	public Shape setReactToLight(boolean reactToLight) {
		this.reactToLight = reactToLight;

		if (this.reactToLight && this.textureless)
			this.setShaderProgram(ShaderProgram.COLOR_LIGHT);

		if (this.reactToLight && !this.textureless)
			this.setShaderProgram(ShaderProgram.TEXTURE_LIGHT);

		if (!this.reactToLight && this.textureless)
			this.setShaderProgram(ShaderProgram.COLOR);

		if (!this.reactToLight && !this.textureless)
			this.setShaderProgram(ShaderProgram.TEXTURE);

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
			case TRIANGLE: RenderTriangle.draw(this); break;
			default: this.isCircle = false; RenderQuad.draw(this); break;
		}
	}


	/**
	 * <p>
	 * Check collision between two shapes
	 * </p>
	 *
	 * @param shape the shape used for collision
	 * @return boolean
	 * @since 0.5
	 * @author Blackoutburst
	 */
	public boolean AABB(Shape shape) {
		return (this.getPosition().x + this.getSize().x / 2 >= shape.getPosition().x - shape.getSize().x / 2 &&
				this.getPosition().x - this.getSize().x / 2 <= shape.getPosition().x + shape.getSize().x / 2 &&
				this.getPosition().y + this.getSize().y / 2 >= shape.getPosition().y - shape.getSize().y / 2 &&
				this.getPosition().y - this.getSize().y / 2 <= shape.getPosition().y + shape.getSize().y / 2);
	}

	/**
	 * <p>
	 * Check collision between two shapes
	 * </p>
	 * 
	 * @param shape the shape used for collision
	 * @return boolean
	 * @since 0.4
	 * @author Blackoutburst
	 */
	public boolean collideWith(Shape shape) {
		glClearColor(1, 1, 1, 1);
		glClear(GL_COLOR_BUFFER_BIT);
		
		Shape s1 = new Shape(this.type, this.position, this.size, this.rotation);
		s1.setColor(new Color(0, 0, 0, 0.5f));
		
		Shape s2 = new Shape(shape.type, shape.position, shape.size, shape.rotation);
		s2.setPosition(shape.getPosition());
		s2.setSize(shape.getSize());
		s2.setRotation(shape.getRotation());
		s2.setColor(new Color(0, 0, 0, 0.5f));
		
		s1.draw();
		s2.draw();
		
	    final ByteBuffer pixels = BufferUtils.createByteBuffer((int) ((s1.size.x * 2) * (s1.size.y * 2)));

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

		pixels.clear();
	    return (collide);
	}
	
	/**
	 * <p>
	 * Check collision between two shapes
	 * </p>
	 * 
	 * @param shape the shape used for collision
	 * @return boolean
	 * @since 0.4
	 * @author Blackoutburst
	 */
	public boolean collideWithTexture(Shape shape) {
		glClearColor(1, 1, 1, 1);
		glClear(GL_COLOR_BUFFER_BIT);
		
		Shape s1 = new Shape(this.type, this.texture, this.position, this.size, this.rotation);
		s1.setPosition(this.getPosition());
		s1.setSize(this.getSize());
		s1.setRotation(this.getRotation());
		s1.setColor(new Color(0, 0, 0, 0.5f));
		s1.setReactToLight(false);
		
		Shape s2 = new Shape(shape.type, shape.texture, shape.position, shape.size, shape.rotation);
		s2.setColor(new Color(0, 0, 0, 0.5f));
		s2.setReactToLight(false);
		
		s1.draw();
		s2.draw();
		
	    final ByteBuffer pixels = BufferUtils.createByteBuffer((int) ((s1.size.x * 2) * (s1.size.y * 2)));

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
		pixels.clear();
	    return (collide);
	}
}
