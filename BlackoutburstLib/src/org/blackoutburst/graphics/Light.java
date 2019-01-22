package org.blackoutburst.graphics;
import org.lwjgl.util.vector.Vector2f;

/**
 * La classe des lumière 
 * @author Blackoutburst
 * @since 1.2
 *
 */

public class Light {
	
	public Vector2f location;
	public float red;
	public float green;
	public float blue;
	public float scale;

	public Light(Vector2f location, float red, float green, float blue, float scale) {
		this.location = location;
		this.red = red;
		this.green = green;
		this.blue = blue;
		this.scale = scale;
	}

	
	/**
	 * On prend la position de la lumière
	 * @return la position de la lumière
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public Vector2f getLocation() {
		return location;
	}

	/**
	 * On prend le rouge de la lumière
	 * @return le rouge de la lumière
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public float getRed() {
		return red;
	}

	/**
	 * On définit le rouge de la lumière
	 * @param red la valeur du rouge
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public void setRed(float red) {
		this.red = red;
	}

	/**
	 * On prend le vert de la lumière
	 * @return le vert de la lumière
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public float getGreen() {
		return green;
	}

	/**
	 * On définit le vert de la lumière
	 * @param green la valeur du vert
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public void setGreen(float green) {
		this.green = green;
	}

	/**
	 * On prend le bleu de la lumière
	 * @return le bleu de la lumière
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public float getBlue() {
		return blue;
	}

	/**
	 * On définit le bleu de la lumière
	 * @param blue la valeur du bleu
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public void setBlue(float blue) {
		this.blue = blue;
	}

	/**
	 * On prend la taille de la lumière
	 * @return la taille de la lumière
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public float getScale() {
		return scale;
	}

	/**
	 * On définit la taille de la lumière
	 * @param scale la taille de la lumière
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public void setScale(float scale) {
		this.scale = scale;
	}

	/**
	 * On définit la position de la lumière
	 * @author Blackoutburst
	 * @param location un vecteur position (x,y)
	 * @since 1.2
	 */
	public void setLocation(Vector2f location) {
		this.location = location;
	}
	
	
	
}