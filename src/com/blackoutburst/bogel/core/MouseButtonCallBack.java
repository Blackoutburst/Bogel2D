package com.blackoutburst.bogel.core;

import org.lwjgl.glfw.GLFWMouseButtonCallbackI;

public class MouseButtonCallBack implements GLFWMouseButtonCallbackI {

	@Override
	public void invoke(long window, int button, int action, int mods) {
		switch(button) {
			case 0: 
				Mouse.getLeftButton().setPressed(action == 1 ? true : false);
				Mouse.getLeftButton().setDown(action == 1 ? true : false);
				Mouse.getLeftButton().setReleased(action == 0 ? true : false);
			break;
			case 1: 
				Mouse.getRightButton().setPressed(action == 1 ? true : false);
				Mouse.getRightButton().setDown(action == 1 ? true : false);
				Mouse.getRightButton().setReleased(action == 0 ? true : false);
			break;
			case 2: 
				Mouse.getMiddleButton().setPressed(action == 1 ? true : false);
				Mouse.getMiddleButton().setDown(action == 1 ? true : false);
				Mouse.getMiddleButton().setReleased(action == 0 ? true : false);
			break;
		}
	}

	

}
