package org.blackoutburst.graphics;
import org.lwjgl.util.vector.Vector2f;

/**
 * La classe des lumi�re 
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
	 * On prend la position de la lumi�re
	 * @return la position de la lumi�re
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public Vector2f getLocation() {
		return location;
	}

	/**
	 * On prend le rouge de la lumi�re
	 * @return le rouge de la lumi�re
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public float getRed() {
		return red;
	}

	/**
	 * On d�finit le rouge de la lumi�re
	 * @param red la valeur du rouge
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public void setRed(float red) {
		this.red = red;
	}

	/**
	 * On prend le vert de la lumi�re
	 * @return le vert de la lumi�re
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public float getGreen() {
		return green;
	}

	/**
	 * On d�finit le vert de la lumi�re
	 * @param green la valeur du vert
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public void setGreen(float green) {
		this.green = green;
	}

	/**
	 * On prend le bleu de la lumi�re
	 * @return le bleu de la lumi�re
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public float getBlue() {
		return blue;
	}

	/**
	 * On d�finit le bleu de la lumi�re
	 * @param blue la valeur du bleu
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public void setBlue(float blue) {
		this.blue = blue;
	}

	/**
	 * On prend la taille de la lumi�re
	 * @return la taille de la lumi�re
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public float getScale() {
		return scale;
	}

	/**
	 * On d�finit la taille de la lumi�re
	 * @param scale la taille de la lumi�re
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public void setScale(float scale) {
		this.scale = scale;
	}

	/**
	 * On d�finit la position de la lumi�re
	 * @author Blackoutburst
	 * @param location un vecteur position (x,y)
	 * @since 1.2
	 */
	public void setLocation(Vector2f location) {
		this.location = location;
	}
	
	
	
}