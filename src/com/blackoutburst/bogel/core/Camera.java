package com.blackoutburst.bogel.core;

import com.blackoutburst.bogel.display.Display;
import com.blackoutburst.bogel.maths.Matrix;
import com.blackoutburst.bogel.maths.Vector2f;
import com.blackoutburst.bogel.maths.Vector3f;

public class Camera {
	protected Vector3f position;
	protected static Matrix matrix = new Matrix();
	
	public Camera() {
		position = new Vector3f(0, 0, 1);
		matrix = new Matrix();
	}

	public Vector3f getPosition() {
		return position;
	}

	public void setPosition(Vector3f position) {
		this.position = position;
		update();
	}
	
	public void setPosition(float x, float y) {
		this.position.x = x;
		this.position.y = y;
		update();
	}
	
	public void setPosition(float x, float y, float z) {
		this.position.x = x;
		this.position.y = y;
		this.position.z = z;
		update();
	}

	public static Matrix getMatrix() {
		if (matrix == null)
			matrix = new Matrix();
		return matrix;
	}
	
	private void update() {
		Matrix.setIdentity(matrix);
		Matrix.translate(new Vector2f(-position.x + Display.getWidth() / 2, -position.y + Display.getHeight() / 2), matrix);
		Matrix.scale(new Vector2f(position.z), matrix);
	}
	
}
