package com.blackoutburst.bogel.core;

public class MouseButton {
	protected int id;
	protected boolean press;
	protected boolean release;
	protected boolean down;
	
	public MouseButton(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public boolean isPressed() {
		return press;
	}
	
	public void setPressed(boolean press) {
		this.press = press;
	}
	
	public boolean isReleased() {
		return release;
	}
	
	public void setReleased(boolean release) {
		this.release = release;
	}
	
	public boolean isDown() {
		return down;
	}
	
	public void setDown(boolean down) {
		this.down = down;
	}
	
	public void reset() {
		this.release = false;
		this.press = false;
	}
}
