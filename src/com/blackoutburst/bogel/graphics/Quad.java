package com.blackoutburst.bogel.graphics;

import com.blackoutburst.bogel.maths.Vector2f;

public class Quad {
	protected Vector2f position;
	protected Vector2f size;
	protected Color color;
	
	public Quad() {
		position = new Vector2f();
		size = new Vector2f();
		color = Color.WHITE;
	}
	
	public Quad(Vector2f position, Vector2f size) {
		this.position = position;
		this.size = size;
		color = Color.WHITE;
	}
	
	public Quad(Vector2f position, Vector2f size, Color color) {
		this.position = position;
		this.size = size;
		this.color = color;
	}

	public Vector2f getPosition() {
		return position;
	}

	public Quad setPosition(Vector2f position) {
		this.position = position;
		return (this);
	}
	
	public Quad setPosition(float x, float y) {
		this.position.x = x;
		this.position.y = y;
		return (this);
	}
	
	public Quad setPosition(float pos) {
		this.position.x = pos;
		this.position.y = pos;
		return (this);
	}

	public Vector2f getSize() {
		return size;
	}

	public Quad setSize(Vector2f size) {
		this.size = size;
		return (this);
	}
	
	public Quad setSize(float x, float y) {
		this.size.x = x;
		this.size.y = y;
		return (this);
	}
	
	public Quad setSize(float size) {
		this.size.x = size;
		this.size.y = size;
		return (this);
	}

	public Color getColor() {
		return color;
	}

	public Quad setColor(Color color) {
		this.color = color;
		return (this);
	}
	
	public Quad setColor(float r, float g, float b) {
		this.color.r = r;
		this.color.g = g;
		this.color.b = b;
		return (this);
	}
	
	public Quad setColor(float r, float g, float b, float a) {
		this.color.r = r;
		this.color.g = g;
		this.color.b = b;
		this.color.a = a;
		return (this);
	}
	
}
