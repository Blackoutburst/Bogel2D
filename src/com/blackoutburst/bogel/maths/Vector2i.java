package com.blackoutburst.bogel.maths;

public class Vector2i {

	public int x;
	public int y;
	
	public Vector2i() {
		this.x = 0;
		this.y = 0;
	}
	
	public Vector2i(int size) {
		this.x = size;
		this.y = size;
	}
	
	public Vector2i(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return (x);
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return (y);
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void set(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2i normalize() {
		int mag = (int) Math.sqrt(x * x + y * y);
		x /= mag;
		y /= mag;
		
		return (this);
	}
	
	public Vector2i mul(int v) {
		x *= v;
		y *= v;
		
		return (this);
	}
	
	public int length() {
		return ((int) Math.sqrt(x * x + y * y));
	}
}
