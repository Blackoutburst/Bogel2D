package com.blackoutburst.bogel.core;

import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

import com.blackoutburst.bogel.graphics.Color;
import com.blackoutburst.bogel.graphics.Shape;

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
	 * @param button
	 * @param pressed
	 * @param hover
	 * @param down
	 * @param released
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
		GL11.glClearColor(0, 0, 0, 0);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		Shape tmp = new Shape();
		tmp.setPosition(this.shape.getPosition());
		tmp.setSize(this.shape.getSize());
		tmp.setRotation(this.shape.getRotation());
		tmp.setColor(Color.RED);
		tmp.drawQuad();
	    int size = 10;
	    ByteBuffer pixels = BufferUtils.createByteBuffer(Display.getWidth() * Display.getHeight() * 4);

	    GL11.glReadPixels((int)Mouse.getX(), (int)Mouse.getY(), size, size, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, pixels);
	    int px = (pixels.get(0) & 0xFF);
	    
	    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);	
		
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
		GL11.glClearColor(0, 0, 0, 0);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		Shape tmp = new Shape();
		tmp.setPosition(this.shape.getPosition());
		tmp.setSize(this.shape.getSize());
		tmp.setRotation(this.shape.getRotation());
		tmp.setColor(Color.RED);
		tmp.drawQuad();
	    int size = 10;
	    ByteBuffer pixels = BufferUtils.createByteBuffer(Display.getWidth() * Display.getHeight() * 4);

	    GL11.glReadPixels((int)Mouse.getX(), (int)Mouse.getY(), size, size, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, pixels);
	    int px = (pixels.get(0) & 0xFF);
	    
	    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);	
		
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
		GL11.glClearColor(0, 0, 0, 0);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		Shape tmp = new Shape();
		tmp.setPosition(this.shape.getPosition());
		tmp.setSize(this.shape.getSize());
		tmp.setRotation(this.shape.getRotation());
		tmp.setColor(Color.RED);
		tmp.drawQuad();
	    int size = 10;
	    ByteBuffer pixels = BufferUtils.createByteBuffer(Display.getWidth() * Display.getHeight() * 4);

	    GL11.glReadPixels((int)Mouse.getX(), (int)Mouse.getY(), size, size, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, pixels);
	    int px = (pixels.get(0) & 0xFF);
	    
	    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);	
		
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
		GL11.glClearColor(0, 0, 0, 0);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		
		Shape tmp = new Shape();
		tmp.setPosition(this.shape.getPosition());
		tmp.setSize(this.shape.getSize());
		tmp.setRotation(this.shape.getRotation());
		tmp.setColor(Color.RED);
		tmp.drawQuad();
	    int size = 10;
	    ByteBuffer pixels = BufferUtils.createByteBuffer(Display.getWidth() * Display.getHeight() * 4);

	    GL11.glReadPixels((int)Mouse.getX(), (int)Mouse.getY(), size, size, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, pixels);
	    int px = (pixels.get(0) & 0xFF);
	    
	    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);	
		
		return (px == 255 && Mouse.getLeftButton().isReleased());
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
		this.shape.drawQuad();
	}
}
