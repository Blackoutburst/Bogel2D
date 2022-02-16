package com.blackoutburst.bogel.core;

import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;

import com.blackoutburst.bogel.graphics.Color;
import com.blackoutburst.bogel.graphics.Shape;
import com.blackoutburst.bogel.graphics.Shape.ShapeType;

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
	
	protected Shape shape;

	/**
	 * <p>
	 * Create a new button
	 * </p>
	 * 
	 * @param shape the button shape
	 * @since 0.3
	 * @author Blackoutburst
	 */
	public Button(Shape shape) {
		this.shape = shape;
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
	 * @param shape the button shape
	 * @since 0.3
	 * @author Blackoutburst
	 */
	public void setShape(Shape shape) {
		this.shape = shape;
	}

	/**
	 * <p>
	 * Check if the mouse is on the button
	 * </p>
	 *
	 * @return boolean
	 * @since 0.3
	 * @author Blackoutburst
	 */
	private boolean onButton() {
		glClearColor(1, 1, 1, 1);
		glClear(GL_COLOR_BUFFER_BIT);
		
		Shape tmp = new Shape(shape.getType(), shape.getPosition(), shape.getSize(), shape.getRotation(), false);
		tmp.setColor(new Color(0 ,0 ,0 ,0.5f));
		tmp.draw();
		
	    glReadPixels((int)Mouse.getX(), (int)Mouse.getY(), 10, 10, GL_RGBA, GL_UNSIGNED_BYTE, shape.getPixels());
	    int px = (shape.getPixels().get(0) & 0xFF);
	    
	    glClearColor(Display.clearColor.r, Display.clearColor.g, Display.clearColor.b, Display.clearColor.a);
	    glClear(GL_COLOR_BUFFER_BIT);
	    return (px == 128);
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
		return (onButton() && Mouse.getLeftButton().isPressed());
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
		return (onButton());
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
		return (onButton() && Mouse.getLeftButton().isDown());
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
		return (onButton() && Mouse.getLeftButton().isReleased());
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
		this.shape.draw();
	}
}
