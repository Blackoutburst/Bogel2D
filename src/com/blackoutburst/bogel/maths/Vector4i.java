package com.blackoutburst.bogel.maths;

public class Vector4i {

	public int x;
	public int y;
	public int z;
	public int w;
	
	public Vector4i() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
		this.w = 0;
	}
	
	public Vector4i(int size) {
		this.x = size;
		this.y = size;
		this.z = size;
		this.w = size;
	}
	
	public Vector4i(int x, int y, int z, int w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	public void set(int x, int y, int z, int w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
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
	
	public int getZ() {
		return (z);
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	public int getW() {
		return (w);
	}

	public void setW(int w) {
		this.w = w;
	}
	
	public Vector4i normalize() {
		int mag = (int) Math.sqrt(x * x + y * y + z * z + w * w);
		x /= mag;
		y /= mag;
		z /= mag;
		w /= mag;
		
		return (this);
	}
	
	public Vector4i mul(int v) {
		x *= v;
		y *= v;
		z *= v;
		w *= v;
		
		return (this);
	}
	
	public int length() {
		return ((int) Math.sqrt(x * x + y * y + z * z + w * w));
	}
}
