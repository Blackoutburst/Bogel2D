package com.blackoutburst.bogel.display;

import org.lwjgl.glfw.GLFWWindowSizeCallbackI;

import com.blackoutburst.bogel.graphics.RenderManager;

public class WindowCallBack implements GLFWWindowSizeCallbackI {

	@Override
	public void invoke(long window, int width, int height) {
		Display.callBackSetSize(width, height);
		RenderManager.setOrtho(width, height);
	}

}
