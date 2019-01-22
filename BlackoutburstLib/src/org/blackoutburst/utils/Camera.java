package org.blackoutburst.utils;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

/**
 * 
 * Gère la position de la Caméra
 * 
 * @author Blackoutburst
 * @since 1.0
 *
 */

public class Camera {

	public static float x,y;
	private static float DX,DY;
	
	
	/**
	 * Permet de bouger la camera quand on maintient un bouton de la sourie avec
	 * inertie
	 * 
	 * @param button on choisit quel bouton permet de bouger la Camera
	 * 
	 * @see Mouse org.lwjgl.input.Mouse
	 * 
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public static void moveWhenButtonDown(int button) {

		if(Mouse.isButtonDown(button)) {
			DX = Mouse.getDX();
			DY= Mouse.getDY();
			x += DX;
			y += -DY;
		}
		else {
			x += DX;
			DX = DX/1.1f;
			y += -DY;
			DY = DY/1.1f;
			if(DX < 1 && DX > -1) {
				DX = 0;
			}
			if(DY < 1 && DY > -1) {
				DY = 0;
			}
		}
	}
	
	
	/**
	 * Appeller cette fonction apres les mise a jours de la fenêtre
	 * 
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public static void update () {
		GL11.glTranslatef(x, y, 0); 
	}
	
	/**
	 * @return la position horizontale de la Camera
	 * 
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public static float getX() {
		return x;
	}
	
	/**
	 * Définit la position horizontale de la Camera
	 * 
	 * @param x la position horizontale de la Camera
	 * 
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public static void setX(float x) {
		Camera.x = x;
	}
	
	/**
	 * @return la position verticale de la Camera
	 * 
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public static float getY() {
		return y;
	}
	
	

	/**
	 * Définit la position verticale de la Camera
	 * 
	 * @param y la position verticale de la Camera
	 * 
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public static void setY(float y) {
		Camera.y = y;
	}
	
	
}
