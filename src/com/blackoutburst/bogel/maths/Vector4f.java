package com.blackoutburst.bogel.maths;

/**
 * <h1>Vector4f</h1>
 * 
 * <p>
 * Create and manager Vector4
 * </p>
 * 
 * @since 0.1
 * @author Blackoutburst
 */
public class Vector4f {

	/**x value*/
	public float x;
	
	/**y value*/
	public float y;
	
	/**z value*/
	public float z;
	
	/**w value*/
	public float w;
	
	/**
	 * <p>
	 * Create a new vector (0, 0, 0, 0)
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector4f() {
		this.x = 0.0f;
		this.y = 0.0f;
		this.z = 0.0f;
		this.w = 0.0f;
	}
	
	/**
	 * <p>
	 * Create a new vector (size, size, size, size)
	 * </p>
	 *
	 * @param float size
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector4f(float size) {
		this.x = size;
		this.y = size;
		this.z = size;
		this.w = size;
	}
	
	/**
	 * <p>
	 * Create a new vector (x, y, z, w)
	 * </p>
	 *
	 * @param float x
	 * @param float y
	 * @param float z
	 * @param float w
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector4f(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	/**
	 * <p>
	 * Set vector values (x, y, z, w)
	 * </p>
	 *
	 * @param float x
	 * @param float y
	 * @param float z
	 * @param float w
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void set(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
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
	 * Get vector Z value
	 * </p>
	 *
	 * @return float
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public float getZ() {
		return (z);
	}

	/**
	 * <p>
	 * Set vector Z value
	 * </p>
	 *
	 * @param float z
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setZ(float z) {
		this.z = z;
	}
	
	/**
	 * <p>
	 * Get vector W value
	 * </p>
	 *
	 * @return float
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public float getW() {
		return (w);
	}

	/**
	 * <p>
	 * Set vector W value
	 * </p>
	 *
	 * @param float w
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setW(float w) {
		this.w = w;
	}

	/**
	 * <p>
	 * Normalize the vector
	 * </p>
	 *
	 * @return Vector4f
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector4f normalize() {
		float mag = (float) Math.sqrt(x * x + y * y + z * z + w * w);
		x /= mag;
		y /= mag;
		z /= mag;
		w /= mag;
		
		return (this);
	}
	
	/**
	 * <p>
	 * Multiply two vector
	 * </p>
	 *
	 * @param float v
	 * @return Vector4f
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector4f mul(float v) {
		x *= v;
		y *= v;
		z *= v;
		w *= v;
		
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
		return ((float) Math.sqrt(x * x + y * y + z * z + w * w));
	}
}
