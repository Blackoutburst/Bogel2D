package com.blackoutburst.bogel.core;

import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;

import com.blackoutburst.bogel.graphics.Color;
import com.blackoutburst.bogel.graphics.Shape;

import static org.lwjgl.opengl.GL11.glReadPixels;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_RGBA;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;

/**
 * <p>
 * Simple button binding
 * </p>
 * 
 * @since 0.3
 * @author Blackoutburst
 *
 */
public class Button {
	
	/**
	 * <p>
	 * Define the shape of the button
	 * </p>
	 * 
	 * @author Blackoutburst
	 * @since 0.3
	 *
	 */
	public static enum ButtonShape {
		QUAD,
		TRIANGLE,
		CIRCLE
	}
	
	protected Shape shape;
	protected ButtonShape bshape;
	
	/**
	 * <p>
	 * Create a new button
	 * </p>
	 * 
	 * @param button
	 * @param pressed
	 * @param hover
	 * @param down
	 * @param released
	 * @since 0.3
	 * @author Blackoutburst
	 */
	public Button(Shape shape, ButtonShape bshape) {
		this.shape = shape;
		this.bshape = bshape;
	}

	/**
	 * <p>
	 * Get the button shape
	 * </p>
	 * 
	 * @return shape
	 * @since 0.3
	 * @author Blackoutburst
	 */
	public Shape getShape() {
		return shape;
	}

	/**
	 * <p>
	 * Set the button shape
	 * </p>
	 * 
	 * @param shape
	 * @since 0.3
	 * @author Blackoutburst
	 */
	public void setShape(Shape shape) {
		this.shape = shape;
	}

	/**
	 * <p>
	 * Check if the button is pressed
	 * </p>
	 * 
	 * @return pressed
	 * @since 0.3
	 * @author Blackoutburst
	 */
	public boolean isPressed() {
		glClearColor(0, 0, 0, 0);
		glClear(GL_COLOR_BUFFER_BIT);
		
		Shape tmp = new Shape();
		tmp.setPosition(this.shape.getPosition());
		tmp.setSize(this.shape.getSize());
		tmp.setRotation(this.shape.getRotation());
		tmp.setColor(Color.RED);
		
		switch (this.bshape) {
			case CIRCLE: tmp.drawCircle(); break;
			case QUAD: tmp.drawQuad(); break;
			case TRIANGLE: tmp.drawTriangle(); break;
			default: tmp.drawQuad(); break;
		}
		
	    int size = 10;
	    ByteBuffer pixels = BufferUtils.createByteBuffer(Display.getWidth() * Display.getHeight() * 4);

	    glReadPixels((int)Mouse.getX(), (int)Mouse.getY(), size, size, GL_RGBA, GL_UNSIGNED_BYTE, pixels);
	    int px = (pixels.get(0) & 0xFF);
	    
	    glClearColor(Display.clearColor.r, Display.clearColor.g, Display.clearColor.b, Display.clearColor.a);
	    glClear(GL_COLOR_BUFFER_BIT);	
		
		return (px == 255 && Mouse.getLeftButton().isPressed());
	}

	/**
	 * <p>
	 * Check if the button is hover
	 * </p>
	 * 
	 * @return hover
	 * @since 0.3
	 * @author Blackoutburst
	 */
	public boolean isHover() {
		glClearColor(0, 0, 0, 0);
		glClear(GL_COLOR_BUFFER_BIT);
		
		Shape tmp = new Shape();
		tmp.setPosition(this.shape.getPosition());
		tmp.setSize(this.shape.getSize());
		tmp.setRotation(this.shape.getRotation());
		tmp.setColor(Color.RED);
		
		switch (this.bshape) {
			case CIRCLE: tmp.drawCircle(); break;
			case QUAD: tmp.drawQuad(); break;
			case TRIANGLE: tmp.drawTriangle(); break;
			default: tmp.drawQuad(); break;
		}
		
	    int size = 10;
	    ByteBuffer pixels = BufferUtils.createByteBuffer(Display.getWidth() * Display.getHeight() * 4);

	    glReadPixels((int)Mouse.getX(), (int)Mouse.getY(), size, size, GL_RGBA, GL_UNSIGNED_BYTE, pixels);
	    int px = (pixels.get(0) & 0xFF);
	    
	    glClearColor(Display.clearColor.r, Display.clearColor.g, Display.clearColor.b, Display.clearColor.a);
	    glClear(GL_COLOR_BUFFER_BIT);	
		
		return (px == 255);
	}

	/**
	 * <p>
	 * Check if the button is down
	 * </p>
	 * 
	 * @return down
	 * @since 0.3
	 * @author Blackoutburst
	 */
	public boolean isDown() {
		glClearColor(0, 0, 0, 0);
		glClear(GL_COLOR_BUFFER_BIT);
		
		Shape tmp = new Shape();
		tmp.setPosition(this.shape.getPosition());
		tmp.setSize(this.shape.getSize());
		tmp.setRotation(this.shape.getRotation());
		tmp.setColor(Color.RED);
		
		switch (this.bshape) {
			case CIRCLE: tmp.drawCircle(); break;
			case QUAD: tmp.drawQuad(); break;
			case TRIANGLE: tmp.drawTriangle(); break;
			default: tmp.drawQuad(); break;
		}
		
	    int size = 10;
	    ByteBuffer pixels = BufferUtils.createByteBuffer(Display.getWidth() * Display.getHeight() * 4);

	    glReadPixels((int)Mouse.getX(), (int)Mouse.getY(), size, size, GL_RGBA, GL_UNSIGNED_BYTE, pixels);
	    int px = (pixels.get(0) & 0xFF);
	    
	    glClearColor(Display.clearColor.r, Display.clearColor.g, Display.clearColor.b, Display.clearColor.a);
	    glClear(GL_COLOR_BUFFER_BIT);	
		
		return (px == 255 && Mouse.getLeftButton().isDown());
	}

	/**
	 * <p>
	 * Check if the button is released
	 * </p>
	 * 
	 * @return released
	 * @since 0.3
	 * @author Blackoutburst 
	 */
	public boolean isReleased() {
		glClearColor(0, 0, 0, 0);
		glClear(GL_COLOR_BUFFER_BIT);
		
		Shape tmp = new Shape();
		tmp.setPosition(this.shape.getPosition());
		tmp.setSize(this.shape.getSize());
		tmp.setRotation(this.shape.getRotation());
		tmp.setColor(Color.RED);
		
		switch (this.bshape) {
			case CIRCLE: tmp.drawCircle(); break;
			case QUAD: tmp.drawQuad(); break;
			case TRIANGLE: tmp.drawTriangle(); break;
			default: tmp.drawQuad(); break;
		}
		
	    int size = 10;
	    ByteBuffer pixels = BufferUtils.createByteBuffer(Display.getWidth() * Display.getHeight() * 4);

	    glReadPixels((int)Mouse.getX(), (int)Mouse.getY(), size, size, GL_RGBA, GL_UNSIGNED_BYTE, pixels);
	    int px = (pixels.get(0) & 0xFF);
	    
	    glClearColor(Display.clearColor.r, Display.clearColor.g, Display.clearColor.b, Display.clearColor.a);
	    glClear(GL_COLOR_BUFFER_BIT);	
		
		return (px == 255 && Mouse.getLeftButton().isReleased());
	}
	/**
	 * <p>
	 * Get the button shape
	 * </p>
	 * 
	 * @return bshape
	 * @since 0.3
	 * @author Blackoutburst 
	 */
	public ButtonShape getBshape() {
		return bshape;
	}

	/**
	 * <p>
	 * Set the button shape
	 * </p>
	 * 
	 * @param bshape
	 * @since 0.3
	 * @author Blackoutburst 
	 */
	public void setBshape(ButtonShape bshape) {
		this.bshape = bshape;
	}

	/**
	 * <p>
	 * Draw the button on screen
	 * </p>
	 * 
	 * @since 0.3
	 * @author Blackoutburst 
	 */
	public void draw() {
		switch (this.bshape) {
		case CIRCLE: this.shape.drawCircle(); break;
		case QUAD: this.shape.drawQuad(); break;
		case TRIANGLE: this.shape.drawTriangle(); break;
		default: this.shape.drawQuad(); break;
	}
	}
}
