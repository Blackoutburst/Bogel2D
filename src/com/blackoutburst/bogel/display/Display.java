package com.blackoutburst.bogel.display;

import static org.lwjgl.glfw.Callbacks.glfwFreeCallbacks;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWImage;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;

import com.blackoutburst.bogel.graphics.Color;
import com.blackoutburst.bogel.maths.Vector2f;
import com.blackoutburst.bogel.maths.Vector2i;

public class Display {
	
	protected long window;
	protected int width = 1280;
	protected int height = 720;
	protected String title = "Bogel2D Window";
	protected Color clearColor = new Color(0.1f, 0.1f, 0.1f, 0.5f);
	protected boolean fullscreen = false;
	
	public Display() {
		GLFWErrorCallback.createPrint(System.err).set();
		
		if (!glfwInit())
			throw new IllegalStateException("Unable to initialize GLFW");
	}
	
	private void setFullScreen() {
		long monitor = GLFW.glfwGetPrimaryMonitor();
		GLFWVidMode videoMode = GLFW.glfwGetVideoMode(monitor);
		Vector2i center = new Vector2i(videoMode.width() / 2 - width / 2, videoMode.height() / 2 - height / 2);

		if (fullscreen) {
			GLFW.glfwSetWindowMonitor(window, monitor, 0, 0, videoMode.width(), videoMode.height(), videoMode.refreshRate());	
		} else {
			GLFW.glfwSetWindowMonitor(window, NULL, center.x, center.y, width, height, videoMode.refreshRate());	
		}
	}
	
	public void create() {
		
		glfwWindowHint(GLFW_SAMPLES, 4);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MAJOR, 3);
		glfwWindowHint(GLFW_CONTEXT_VERSION_MINOR, 2);
		glfwWindowHint(GLFW_OPENGL_FORWARD_COMPAT, GLFW_TRUE);
		glfwWindowHint(GLFW_OPENGL_PROFILE, GLFW_OPENGL_CORE_PROFILE);
		
		
		
		window = glfwCreateWindow(width, height, title, NULL, NULL);
		
		if (window == NULL)
			throw new RuntimeException("Failed to create the GLFW window");
		
		setIcons("assets/icon128.png");
		
		glfwMakeContextCurrent(window);
		glfwShowWindow(window);
		GL.createCapabilities();
		setFullScreen();
	}
	
	public void clear() {
		glClearColor(clearColor.r, clearColor.g, clearColor.b, clearColor.a);
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
	}
	
	public void update() {
		glfwSwapBuffers(window);
		glfwPollEvents();
	}
	
	public Display setFullscreenMode(boolean full) {
		fullscreen = full;
		if (window != NULL)
			setFullScreen();
		return (this);
	}
	
	public Display setClearColor(Color c) {
		clearColor = c;
		return (this);
	}
	
	public void destroy() {
		glfwFreeCallbacks(window);
		glfwDestroyWindow(window);
		glfwTerminate();
		glfwSetErrorCallback(null).free();
	}
	
	public long getWindow() {
		return (window);
	}
	
	public Display setTitle(String title) {
		this.title = title;
		return (this);
	}
	
	public Display setVSync(boolean enabled) {
		glfwSwapInterval(enabled ? GLFW_TRUE : GLFW_FALSE);
		return (this);
	}
	
	public Display setSize(int width, int height) {
		this.width = width;
		this.height = height;
		if (window != NULL)
			GLFW.glfwSetWindowSize(window, this.width, this.height);
		return (this);
	}
	
	public Display setResizable(boolean resizable) {
		glfwWindowHint(GLFW_RESIZABLE, resizable ? GLFW_TRUE : GLFW_FALSE);
		return (this);
	}
	
	public Display setTransparent(boolean transparent) {
		glfwWindowHint(GLFW_TRANSPARENT_FRAMEBUFFER, transparent ? GLFW_TRUE : GLFW_FALSE);
		return (this);
	}
	
	public Display setDecoration(boolean decorated) {
		glfwWindowHint(GLFW_DECORATED , decorated ? GLFW_TRUE : GLFW_FALSE);
		return (this);
	}
	
	public int getWidth() {
		int w = 0;
		
		try (MemoryStack stack = MemoryStack.stackPush()) {
			IntBuffer width = stack.mallocInt(1);
			IntBuffer height = stack.mallocInt(1);
			GLFW.glfwGetWindowSize(window, width, height);
			w = width.get();
		} catch (Exception e) {
			System.err.println("Error while getting display width: "+e.toString());
		}
		return (w);
	}
	
	public int getHeight() {
		int h = 0;
		
		try (MemoryStack stack = MemoryStack.stackPush()) {
			IntBuffer width = stack.mallocInt(1);
			IntBuffer height = stack.mallocInt(1);
			GLFW.glfwGetWindowSize(window, width, height);
			h = height.get();
		} catch (Exception e) {
			System.err.println("Error while getting display height: "+e.toString());
		}
		return (h);
	}
	
	public Vector2i getSize() {
		Vector2i size = new Vector2i();
		
		try (MemoryStack stack = MemoryStack.stackPush()) {
			IntBuffer width = stack.mallocInt(1);
			IntBuffer height = stack.mallocInt(1);
			GLFW.glfwGetWindowSize(window, width, height);
			size.set(width.get(), height.get());
		} catch (Exception e) {
			System.err.println("Error while getting display size: "+e.toString());
		}
		return (size);
	}
	
	public Vector2f getSizeF() {
		Vector2f size = new Vector2f();
		
		try (MemoryStack stack = MemoryStack.stackPush()) {
			IntBuffer width = stack.mallocInt(1);
			IntBuffer height = stack.mallocInt(1);
			GLFW.glfwGetWindowSize(window, width, height);
			size.set(width.get(), height.get());
		} catch (Exception e) {
			System.err.println("Error while getting display size: "+e.toString());
		}
		return (size);
	}
	
	public Display setIcons(String filePath) {
		GLFWImage image = GLFWImage.malloc(); 
		GLFWImage.Buffer imagebf = GLFWImage.malloc(1);
		try {
			image.set(128, 128, loadIcons(filePath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		imagebf.put(0, image);
		GLFW.glfwSetWindowIcon(window, imagebf);
		return (this);
	}
	
	private ByteBuffer loadIcons(String path) throws Exception {
		ByteBuffer image;
		try (MemoryStack stack = MemoryStack.stackPush()) {
			IntBuffer comp = stack.mallocInt(1);
			IntBuffer w = stack.mallocInt(1);
			IntBuffer h = stack.mallocInt(1);

			image = STBImage.stbi_load(path, w, h, comp, 4);
			if (image == null) {
				throw new Exception("Failed to load icons");
			}
		}
		return image;
	}
}	
