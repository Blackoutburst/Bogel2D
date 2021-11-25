package com.blackoutburst.bogel.graphics;

public class Color {
	
	public static final Color WHITE = new Color(1.0f);
	public static final Color BLACK = new Color(0.0f);
	public static final Color GRAY = new Color(0.5f);
	public static final Color LIGHT_GRAY = new Color(0.75f);
	public static final Color DARK_GRAY = new Color(0.25f);
	public static final Color RED = new Color(1.0f, 0.0f, 0.0f);
	public static final Color GREEN = new Color(0.0f, 1.0f, 0.0f);
	public static final Color BLUE = new Color(0.0f, 0.0f, 1.0f);
	public static final Color YELLOW = new Color(1.0f, 1.0f, 0.0f);
	public static final Color MAGENTA = new Color(1.0f, 0.0f, 1.0f);
	public static final Color CYAN = new Color(0.0f, 1.0f, 1.0f);
	public static final Color ORANGE = new Color(1.0f, 0.5f, 0.0f);
	public static final Color LIGHT_BLUE = new Color(0.0f, 0.5f, 1.0f);
	public static final Color TRANSPARENT = new Color(0.0f, 0.0f, 0.0f, 0.0f);
	
	public float r;
	public float g;
	public float b;
	public float a;

	public Color() {
		this.r = 0.0f;
		this.g = 0.0f;
		this.b = 0.0f;
		this.a = 1.0f;
	}
	
	public Color(float c) {
		this.r = c;
		this.g = c;
		this.b = c;
		this.a = 1.0f;
	}
	
	public Color(float r, float g, float b) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = 1.0f;
	}
	
	public Color(float r, float g, float b, float a) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.a = a;
	}

	public float getR() {
		return r;
	}

	public void setR(float r) {
		this.r = r;
	}

	public float getG() {
		return g;
	}

	public void setG(float g) {
		this.g = g;
	}

	public float getB() {
		return b;
	}

	public void setB(float b) {
		this.b = b;
	}

	public float getA() {
		return a;
	}

	public void setA(float a) {
		this.a = a;
	}
	
	public Color darker() {
		r -= 0.1f;
		g -= 0.1f;
		b -= 0.1f;
		if (r < 0.0f) r = 0.0f;
		if (g < 0.0f) g = 0.0f;
		if (b < 0.0f) b = 0.0f;
		return (this);
	}
	
	public Color lighter() {
		r += 0.1f;
		g += 0.1f;
		b += 0.1f;
		if (r > 1.0f) r = 1.0f;
		if (g > 1.0f) g = 1.0f;
		if (b > 1.0f) b = 1.0f;
		return (this);
	}
	
	public Color add(Color c) {
		r += c.r;
		g += c.g;
		b += c.b;
		
		if (r > 1.0f) r = 1.0f;
		if (g > 1.0f) g = 1.0f;
		if (b > 1.0f) b = 1.0f;
		return(this);
	}
	
	public Color sub(Color c) {
		r -= c.r;
		g -= c.g;
		b -= c.b;
		
		if (r < 0.0f) r = 0.0f;
		if (g < 0.0f) g = 0.0f;
		if (b < 0.0f) b = 0.0f;
		return(this);
	}
	
	public Color mul(Color c) {
		r *= c.r;
		g *= c.g;
		b *= c.b;
		
		if (r < 0.0f) r = 0.0f;
		if (g < 0.0f) g = 0.0f;
		if (b < 0.0f) b = 0.0f;
		if (r > 1.0f) r = 1.0f;
		if (g > 1.0f) g = 1.0f;
		if (b > 1.0f) b = 1.0f;
		return(this);
	}
	
	public Color div(Color c) {
		r /= c.r;
		g /= c.g;
		b /= c.b;
		
		if (r < 0.0f) r = 0.0f;
		if (g < 0.0f) g = 0.0f;
		if (b < 0.0f) b = 0.0f;
		if (r > 1.0f) r = 1.0f;
		if (g > 1.0f) g = 1.0f;
		if (b > 1.0f) b = 1.0f;
		return(this);
	}
}
