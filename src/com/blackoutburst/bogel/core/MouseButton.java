package com.blackoutburst.bogel.core;

/**
 * <h1>Mouse Button</h1>
 * 
 * <p>
 * A simple Mouse button binding
 * </p>
 * 
 * @since 0.1
 * @author Blackoutburst
 */
public class MouseButton {
	
	protected int id;
	
	protected boolean press;
	protected boolean release;
	protected boolean down;
	
	/**
	 * <p>
	 * Create a new MouseButon
	 * </p>
	 * 
	 * @param int id
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public MouseButton(int id) {
		this.id = id;
	}
	
	/**
	 * <p>
	 * Get the MouseButton id
	 * </p>
	 * 
	 * @return int id
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * <p>
	 * Check if the button is pressed
	 * </p>
	 * 
	 * @return boolean pressed
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public boolean isPressed() {
		return press;
	}
	
	/**
	 * <h1>THIS IS USED FOR INTERNAL FUNCTIONEMENT DO NOT USE</h1>
	 * 
	 * <p>
	 * Set if the button is pressed
	 * </p>
	 * 
	 * @param boolean pressed
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setPressed(boolean press) {
		this.press = press;
	}
	
	/**
	 * <p>
	 * Check if the button is released
	 * </p>
	 * 
	 * @return boolean release
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public boolean isReleased() {
		return release;
	}
	
	/**
	 * <h1>THIS IS USED FOR INTERNAL FUNCTIONEMENT DO NOT USE</h1>
	 * 
	 * <p>
	 * Set if the button is released
	 * </p>
	 * 
	 * @param boolean released
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setReleased(boolean release) {
		this.release = release;
	}
	
	/**
	 * <p>
	 * Check if the button is down
	 * </p>
	 * 
	 * @return boolean down
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public boolean isDown() {
		return down;
	}
	
	/**
	 * <h1>THIS IS USED FOR INTERNAL FUNCTIONEMENT DO NOT USE</h1>
	 * 
	 * <p>
	 * Set if the button is down
	 * </p>
	 * 
	 * @param boolean down
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setDown(boolean down) {
		this.down = down;
	}
	
	/**
	 * <h1>THIS IS USED FOR INTERNAL FUNCTIONEMENT DO NOT USE</h1>
	 * 
	 * <p>
	 * Reset the MouseButton status
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void reset() {
		this.release = false;
		this.press = false;
	}
}
