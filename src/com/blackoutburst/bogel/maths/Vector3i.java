package com.blackoutburst.bogel.maths;

public class Vector3i {

	public int x;
	public int y;
	public int z;
	
	public Vector3i() {
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	public Vector3i(int size) {
		this.x = size;
		this.y = size;
		this.z = size;
	}
	
	public Vector3i(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void set(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
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
	
	public Vector3i normalize() {
		int mag = (int) Math.sqrt(x * x + y * y + z * z);
		x /= mag;
		y /= mag;
		z /= mag;
		
		return (this);
	}
	
	public Vector3i mul(int v) {
		x *= v;
		y *= v;
		z *= v;
		
		return (this);
	}
	
	public int length() {
		return ((int) Math.sqrt(x * x + y * y + z * z));
	}
}
