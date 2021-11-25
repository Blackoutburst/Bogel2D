package com.blackoutburst.bogel.maths;

public class Vector4f {

	public float x;
	public float y;
	public float z;
	public float w;
	
	public Vector4f() {
		this.x = 0.0f;
		this.y = 0.0f;
		this.z = 0.0f;
		this.w = 0.0f;
	}
	
	public Vector4f(float size) {
		this.x = size;
		this.y = size;
		this.z = size;
		this.w = size;
	}
	
	public Vector4f(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public void set(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public float getX() {
		return (x);
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return (y);
	}

	public void setY(float y) {
		this.y = y;
	}
	
	public float getZ() {
		return (z);
	}

	public void setZ(float z) {
		this.z = z;
	}
	
	public float getW() {
		return (w);
	}

	public void setW(float w) {
		this.w = w;
	}
	
	public Vector4f normalize() {
		float mag = (float) Math.sqrt(x * x + y * y + z * z + w * w);
		x /= mag;
		y /= mag;
		z /= mag;
		w /= mag;
		
		return (this);
	}
	
	public Vector4f mul(float v) {
		x *= v;
		y *= v;
		z *= v;
		w *= v;
		
		return (this);
	}
	
	public float length() {
		return ((float) Math.sqrt(x * x + y * y + z * z + w * w));
	}
}
