package com.blackoutburst.bogel.graphics;

import static org.lwjgl.opengl.GL11.GL_RGBA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.GL_UNSIGNED_BYTE;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glGenTextures;
import static org.lwjgl.opengl.GL11.glTexImage2D;
import static org.lwjgl.opengl.GL30.glGenerateMipmap;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryStack;

public class Texture {
	protected int id;
	protected IntBuffer width;
	protected IntBuffer height;
	protected boolean missing;
	
	public Texture(String filePath) {
		ByteBuffer data = null;
		try (MemoryStack stack = MemoryStack.stackPush()) {
			id = glGenTextures();
			glBindTexture(GL_TEXTURE_2D, id);
			
			IntBuffer comp = stack.mallocInt(1);
			this.width = stack.mallocInt(1);
			this.height = stack.mallocInt(1);

			try {
				data = STBImage.stbi_load_from_memory(IOUtils.ioResourceToByteBuffer(filePath, 1024), this.width, this.height, comp, 0);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, this.width.get(), this.height.get(), 0, GL_RGBA, GL_UNSIGNED_BYTE, data);
			glGenerateMipmap(GL_TEXTURE_2D);
			
			if (data == null) {
				System.err.println("Couldn't load ["+filePath+"] using default texture instead");
				loadMissing();
			}
		}
		if (data != null) {
			STBImage.stbi_image_free(data);
			this.missing = false;
		}
	}
	
	private void loadMissing() {
		ByteBuffer data = null;
		try (MemoryStack stack = MemoryStack.stackPush()) {
			id = glGenTextures();
			glBindTexture(GL_TEXTURE_2D, id);
			
			IntBuffer comp = stack.mallocInt(1);
			this.width = stack.mallocInt(1);
			this.height = stack.mallocInt(1);

			try {
				data = STBImage.stbi_load_from_memory(IOUtils.ioResourceToByteBuffer("null.png", 1024), this.width, this.height, comp, 0);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, this.width.get(), this.height.get(), 0, GL_RGBA, GL_UNSIGNED_BYTE, data);
			glGenerateMipmap(GL_TEXTURE_2D);
		}
		STBImage.stbi_image_free(data);
		this.missing = true;
	}
	
	public int getWidth() {
		return (this.width.get());
	}
	
	public int getHeight() {
		return (this.height.get());
	}
	
	public int getTexture() {
		return (this.id);
	}
}
