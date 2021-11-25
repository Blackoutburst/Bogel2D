package com.blackoutburst.bogel.core;

import com.blackoutburst.bogel.maths.Vector2f;


/**
 * <h1>Mouse</h1>
 * 
 * <p>
 * A simple Mouse binding
 * </p>
 * 
 * @since 0.1
 * @author Blackoutburst
 */
public class Mouse {
	
	private static float x;
	private static float y;
	private static float scroll;
	
	private static Vector2f position = new Vector2f();
	
	private static MouseButton leftButton = new MouseButton(0);
	private static MouseButton rightButton = new MouseButton(1);
	private static MouseButton middleButton = new MouseButton(2);
	
	/**
	 * <p>
	 * Return the mouse X position
	 * </p>
	 * 
	 * @return float x
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static float getX() {
		return x;
	}
	
	/**
	 * <h1>THIS IS USED FOR INTERNAL FUNCTIONEMENT DO NOT USE</h1>
	 * 
	 * <p>
	 * Set the mouse X position
	 * </p>
	 * 
	 * @param float x
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static void setX(float x) {
		Mouse.x = x;
	}
	
	/**
	 * <p>
	 * Return the mouse Y position
	 * </p>
	 * 
	 * @return float y
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static float getY() {
		return y;
	}
	
	/**
	 * <h1>THIS IS USED FOR INTERNAL FUNCTIONEMENT DO NOT USE</h1>
	 * 
	 * <p>
	 * Set the mouse Y position
	 * </p>
	 * 
	 * @param float y
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static void setY(float y) {
		Mouse.y = y;
	}
	
	/**
	 * <p>
	 * Return the mouse position
	 * </p>
	 * 
	 * @return Vector2f position
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static Vector2f getPosition() {
		return position;
	}
	
	/**
	 * <h1>THIS IS USED FOR INTERNAL FUNCTIONEMENT DO NOT USE</h1>
	 * 
	 * <p>
	 * Set the mouse position
	 * </p>
	 * 
	 * @param Vector2f y
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static void setPosition(Vector2f position) {
		Mouse.position = position;
	}
	
	/**
	 * <p>
	 * Return the mouse left button
	 * </p>
	 * 
	 * @return MouseButton left
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static MouseButton getLeftButton() {
		return leftButton;
	}
	
	/**
	 * <p>
	 * Return the mouse right button
	 * </p>
	 * 
	 * @return MouseButton right
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static MouseButton getRightButton() {
		return rightButton;
	}
	
	/**
	 * <p>
	 * Return the mouse middle button (scroll wheel)
	 * </p>
	 * 
	 * @return MouseButton middle (scroll wheel)
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static MouseButton getMiddleButton() {
		return middleButton;
	}
	
	/**
	 * <p>
	 * Return the mouse scroll amount
	 * </p>
	 * 
	 * @return float scroll
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static float getScroll() {
		return scroll;
	}
	
	/**
	 * <h1>THIS IS USED FOR INTERNAL FUNCTIONEMENT DO NOT USE</h1>
	 * 
	 * <p>
	 * Set the mouse scroll
	 * </p>
	 * 
	 * @param float scroll
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public static void setScroll(float scroll) {
		Mouse.scroll = scroll;
	}
}
