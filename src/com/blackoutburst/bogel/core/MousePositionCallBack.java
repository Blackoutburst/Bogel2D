package com.blackoutburst.bogel.core;

import org.lwjgl.glfw.GLFWCursorPosCallbackI;

import com.blackoutburst.bogel.display.Display;
import com.blackoutburst.bogel.maths.Vector2f;

public class MousePositionCallBack implements GLFWCursorPosCallbackI {

	
	@Override
	public void invoke(long window, double xpos, double ypos) {
		Mouse.setX((float) xpos);
		Mouse.setY((float) (Display.getHeight() - ypos));
		Mouse.setPosition(new Vector2f((float) xpos, (float) (Display.getHeight() - ypos)));
	}

}
