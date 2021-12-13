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

import com.blackoutburst.bogel.graphics.Shape.ShapeType;
import com.blackoutburst.bogel.maths.Vector2f;
import com.blackoutburst.bogel.maths.Vector2i;

/**
 * <h1>Texture</h1>
 * 
 * <p>
 * Create and manager textures
 * </p>
 * 
 * @since 0.1
 * @author Blackoutburst
 */
public class Texture {
	
	protected int id;
	
	protected IntBuffer width;
	protected IntBuffer height;
	
	protected boolean missing;
	
	protected Vector2f position;
	
	protected Shape shape;
	
	/**
	 * <p>
	 * Create a texture from file
	 * </p>
	 * 
	 * @param String filePath
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Texture(String filePath) {
		this.position = new Vector2f();
		ByteBuffer data = null;
		try (MemoryStack stack = MemoryStack.stackPush()) {
			id = glGenTextures();
			glBindTexture(GL_TEXTURE_2D, id);
			
			IntBuffer comp = stack.mallocInt(1);
			this.width = stack.mallocInt(1);
			this.height = stack.mallocInt(1);

			try {
				data = STBImage.stbi_load_from_memory(IOUtils.ioResourceToByteBuffer(filePath, 1024), this.width, this.height, comp, 0);
			} catch (Exception e) {}
			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, this.width.get(0), this.height.get(0), 0, GL_RGBA, GL_UNSIGNED_BYTE, data);
			glGenerateMipmap(GL_TEXTURE_2D);
			comp.clear();
			if (data == null) {
				System.err.println("Couldn't load ["+filePath+"] using default texture instead");
				loadMissing();
			}
		}
		if (data != null) {
			this.shape = new Shape(ShapeType.QUAD, this, 0, 0, this.width.get(0), this.height.get(0), Color.WHITE);
			STBImage.stbi_image_free(data);
			this.missing = false;
		}
	}
	
	/**
	 * <p>
	 * Load the default missing texture<br>
	 * Automatically called if texture generation fail
	 * </p>
	 * 
	 * @since 0.1
	 * @author Blackoutburst
	 */
	private void loadMissing() {
		ByteBuffer data = null;
		try (MemoryStack stack = MemoryStack.stackPush()) {
			id = glGenTextures();
			glBindTexture(GL_TEXTURE_2D, id);
			
			IntBuffer comp = stack.mallocInt(1);
			this.width = stack.mallocInt(1);
			this.height = stack.mallocInt(1);

			try {
				data = STBImage.stbi_load_from_memory(IOUtils.ioResourceToByteBuffer("null.png", 16), this.width, this.height, comp, 0);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, this.width.get(0), this.height.get(0), 0, GL_RGBA, GL_UNSIGNED_BYTE, data);
			glGenerateMipmap(GL_TEXTURE_2D);
			comp.clear();
		}
		this.shape = new Shape(ShapeType.QUAD, this, 0, 0, this.width.get(0), this.height.get(0), Color.WHITE);
		STBImage.stbi_image_free(data);
		this.missing = true;
	}
	
	
	/**
	 * <p>
	 * Get texture width
	 * </p>
	 * 
	 * @return int
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public int getWidth() {
		return (this.width.get(0));
	}
	
	/**
	 * <p>
	 * Get texture height
	 * </p>
	 * 
	 * @return int
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public int getHeight() {
		return (this.height.get(0));
	}
	
	/**
	 * <p>
	 * Get texture size
	 * </p>
	 * 
	 * @return Vector2i
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector2i getSize() {
		return (new Vector2i(this.width.get(0), this.height.get(0)));
	}
	
	/**
	 * <p>
	 * Get texture id
	 * </p>
	 * 
	 * @return int
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public int getTexture() {
		return (this.id);
	}
	
	/**
	 * <p>
	 * Set the Texture size
	 * </p>
	 * 
	 * @param Vector2f size
	 * @return Texture
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Texture setSize(Vector2f size) {
		this.shape.size = size;
		return (this);
	}
	
	/**
	 * <p>
	 * Set the Texture size (x, y)
	 * </p>
	 * 
	 * @param float x
	 * @param float y
	 * @return Texture
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Texture setSize(float x, float y) {
		this.shape.size.x = x;
		this.shape.size.y = y;
		return (this);
	}
	
	/**
	 * <p>
	 * Set the Texture size (size, size)
	 * </p>
	 * 
	 * @param float size
	 * @return Texture
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Texture setSize(float size) {
		this.shape.size.x = size;
		this.shape.size.y = size;
		return (this);
	}

	/**
	 * <p>
	 * Get the Texture position
	 * </p>
	 * 
	 * @return Vector2f position
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Vector2f getPosition() {
		return position;
	}

	/**
	 * <p>
	 * Set the Texture position
	 * </p>
	 * 
	 * @param Vector2f position
	 * @return Texture
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Texture setPosition(Vector2f position) {
		this.shape.position = position;
		return (this);
	}
	
	/**
	 * <p>
	 * Set the Texture position (x, y)
	 * </p>
	 * 
	 * @param float x
	 * @param float y
	 * @return Texture
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Texture setPosition(float x, float y) {
		this.shape.position.x = x;
		this.shape.position.y = y;
		return (this);
	}
	
	/**
	 * <p>
	 * Set the Texture position (pos, pos)
	 * </p>
	 * 
	 * @param float pos
	 * @return Texture
	 * @since 0.1
	 * @author Blackoutburst
	 */
	public Texture setPosition(float pos) {
		this.shape.position.x = pos;
		this.shape.position.y = pos;
		return (this);
	}
	
	public void draw() {
		this.shape.isCircle = false;
		RenderQuad.draw(this.shape);
	}
	
	public void drawCircle() {
		this.shape.isCircle = true;
		RenderQuad.draw(this.shape);
	}
}
