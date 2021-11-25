package com.blackoutburst.bogel.core;

import org.lwjgl.glfw.GLFWScrollCallbackI;

public class MouseScrollCallBack implements GLFWScrollCallbackI {

	@Override
	public void invoke(long window, double xoffset, double yoffset) {
		Mouse.setScroll((float) (Mouse.getScroll() + yoffset));
	}


}
