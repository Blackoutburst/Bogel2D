package com.blackoutburst.bogel.maths;

public class Vector2f {

	public float x;
	public float y;
	
	public Vector2f() {
		this.x = 0.0f;
		this.y = 0.0f;
	}
	
	public Vector2f(float size) {
		this.x = size;
		this.y = size;
	}
	
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public void set(float x, float y) {
		this.x = x;
		this.y = y;
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
	
	public Vector2f normalize() {
		float mag = (float) Math.sqrt(x * x + y * y);
		x /= mag;
		y /= mag;
		
		return (this);
	}
	
	public Vector2f mul(float v) {
		x *= v;
		y *= v;
		
		return (this);
	}
	
	public float length() {
		return ((float) Math.sqrt(x * x + y * y));
	}
}
