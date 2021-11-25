package com.blackoutburst.bogel.maths;

/**
 * <h1>Vector4i</h1>
 * 
 * <p>
 * Create and manager Vector4
 * </p>
 * 
 * @since 0.1
 * @author Blackoutburst
 */
public class Vector4i {

	/**x value*/
	public int x;
	
	/**y value*/
	public int y;
	
	/**z value*/
	public int z;
	
	/**w value*/
	public int w;
	
	/**
	 * <p>
	 * Create a new vector (0, 0, 0, 0)
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector4i() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.w = 0;
	}
	
	/**
	 * <p>
	 * Create a new vector (size, size, size, size)
	 * </p>
	 *
	 * @param int size
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector4i(int size) {
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
	 * @param int x
	 * @param int y
	 * @param int z
	 * @param int w
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector4i(int x, int y, int z, int w) {
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
	 * @param int x
	 * @param int y
	 * @param int z
	 * @param int w
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void set(int x, int y, int z, int w) {
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
	 * @return int
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public int getX() {
		return (x);
	}

	/**
	 * <p>
	 * Set vector X value
	 * </p>
	 *
	 * @param int x
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * <p>
	 * Get vector Y value
	 * </p>
	 *
	 * @return int
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public int getY() {
		return (y);
	}

	/**
	 * <p>
	 * Set vector Y value
	 * </p>
	 *
	 * @param int y
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * <p>
	 * Get vector Z value
	 * </p>
	 *
	 * @return int
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public int getZ() {
		return (z);
	}

	/**
	 * <p>
	 * Set vector Z value
	 * </p>
	 *
	 * @param int z
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setZ(int z) {
		this.z = z;
	}
	
	/**
	 * <p>
	 * Get vector W value
	 * </p>
	 *
	 * @return int
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public int getW() {
		return (w);
	}

	/**
	 * <p>
	 * Set vector W value
	 * </p>
	 *
	 * @param int w
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public void setW(int w) {
		this.w = w;
	}
	
	/**
	 * <p>
	 * Normalize the vector
	 * </p>
	 *
	 * @return Vector4i
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector4i normalize() {
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
	 * @return Vector4i
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector4i mul(float v) {
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
