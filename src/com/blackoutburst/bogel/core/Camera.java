package com.blackoutburst.bogel.core;

import com.blackoutburst.bogel.maths.Matrix;
import com.blackoutburst.bogel.maths.Vector2f;
import com.blackoutburst.bogel.maths.Vector3f;

public class Camera {
	protected static Vector3f position = new Vector3f();
	protected static Matrix matrix = new Matrix();
	
	public Camera() {
		position = new Vector3f(0, 0, 1);
		matrix = new Matrix();
		update();
	}

	public static Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f p) {
		position = p;
		update();
	}
	
	public void setPosition(Vector2f p) {
		position.x = p.x;
		position.y = p.y;
		update();
	}
	
	public void setPosition(float x, float y) {
		position.x = x;
		position.y = y;
		update();
	}
	
	public void setPositionX(float x) {
		position.x = x;
		update();
	}
	
	public void setPositionY(float y) {
		position.y = y;
		update();
	}
	
	public void setPositionZ(float z) {
		position.z = z;
		update();
	}
	
	public void setPosition(float x, float y, float z) {
		position.x = x;
		position.y = y;
		position.z = z;
		update();
	}

	public static Matrix getMatrix() {
		if (matrix == null)
			matrix = new Matrix();
		return matrix;
	}
	
	private void update() {
		if (position.z < 0) position.z = 0;
		Matrix.setIdentity(matrix);
		Matrix.translate(new Vector2f(-position.x, -position.y), matrix);
		Matrix.scale(new Vector2f(position.z), matrix);
	}
	
}
