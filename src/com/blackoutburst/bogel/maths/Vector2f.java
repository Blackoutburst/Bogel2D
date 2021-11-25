package com.blackoutburst.bogel.maths;

/**
 * <h1>Vector2f</h1>
 * 
 * <p>
 * Create and manager Vector2
 * </p>
 * 
 * @since 0.1
 * @author Blackoutburst
 */
public class Vector2f {

	/**x value*/
	public float x;
	
	/**y value*/
	public float y;
	
	/**
	 * <p>
	 * Create a new vector (0, 0)
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector2f() {
		this.x = 0.0f;
		this.y = 0.0f;
	}
	
	/**
	 * <p>
	 * Create a new vector (size, size)
	 * </p>
	 *
	 * @param float size
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector2f(float size) {
		this.x = size;
		this.y = size;
	}
	
	/**
	 * <p>
	 * Create a new vector (x, y)
	 * </p>
	 *
	 * @param float x
	 * @param float y
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * <p>
	 * Set vector values (x, y)
	 * </p>
	 *
	 * @param float x
	 * @param float y
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void set(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * <p>
	 * Get vector X value
	 * </p>
	 *
	 * @return float
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public float getX() {
		return (x);
	}

	/**
	 * <p>
	 * Set vector X value
	 * </p>
	 *
	 * @param float x
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * <p>
	 * Get vector Y value
	 * </p>
	 *
	 * @return float
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public float getY() {
		return (y);
	}

	/**
	 * <p>
	 * Set vector Y value
	 * </p>
	 *
	 * @param float y
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	/**
	 * <p>
	 * Normalize the vector
	 * </p>
	 *
	 * @return Vector2f
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector2f normalize() {
		float mag = (float) Math.sqrt(x * x + y * y);
		x /= mag;
		y /= mag;
		
		return (this);
	}
	
	/**
	 * <p>
	 * Multiply two vector
	 * </p>
	 *
	 * @param float v
	 * @return Vector2f
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector2f mul(float v) {
		x *= v;
		y *= v;
		
		return (this);
	}
	
	/**
	 * <p>
	 * 	Return the vector length
	 * </p>
	 *
	 * @return float
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public float length() {
		return ((float) Math.sqrt(x * x + y * y));
	}
}
