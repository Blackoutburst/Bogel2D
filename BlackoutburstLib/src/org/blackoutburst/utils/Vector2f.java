package org.blackoutburst.utils;

/**
 * Cr�er des vecteur 2D
 * 
 * @author Blackoutburst
 * 
 * @since 1.1
 *
 */

public class Vector2f {
	public float x, y;
	
	
	/**
	 * On cr�er un vecteur de coordonn�es (0,0)
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.1
	 */
	public Vector2f() {
		this(0, 0);
	}
	
	
	/**
	 * On donne a notre vecteur les coordon�e d'un autre vecteur
	 * @param v vecteur a deux dimension qui donne ses coordon�e
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.1
	 */
	
	public Vector2f(Vector2f v) {
		this(v.x, v.y);
	}
	
	
	/**
	 * On cr�er un vecteur de coordonn�es (x,y)
	 * @param x la coordonn�e horizontale du vecteur
	 * @param y la coordonn�e verticale du vecteur
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.1
	 */
	public Vector2f(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	
	/**
	 * D�finit les coordon�e d'un vecteur
	 * @param x la coordonn�e horizontale du vecteur
	 * @param y la coordonn�e verticale du vecteur
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.1
	 */
	public Vector2f set(float x, float y) {
		this.x = x;
		this.y = y;
		
		return this;
	}
	
	/**
	 * On prend les coordon�e d'un vecteur pour calculer les normes de ce dernier
	 * 
	 * @return le vecteur avec la norme de ses coordonn�es
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.1
	 */
	public Vector2f normalize() {
		float mag = (float) Math.sqrt(x * x + y * y);
		x /= mag;
		y /= mag;
		
		return this;
	}
	
	/**
	 * 
	 * On multiplie deux vecteur entre eux
	 * 
	 * @param v un vecteur 2D qui servira de multiplicateur 
	 * @return le vecteur avec des coordonn�e multiplier par le vecteur v
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.1
	 */
	
	public Vector2f mul(float v) {
		x *= v;
		y *= v;
		
		return this;
	}
	
	/**
	 * On r�cup�re la longeur d'un vecteur
	 * 
	 * @author Blackoutburst
	 * @since 1.2
	 * @return la norme (longeur) du vecteur
	 */
	public float length() {
		float len = (float) Math.sqrt(x * x + y * y);
		
		return len;
	}
	
}