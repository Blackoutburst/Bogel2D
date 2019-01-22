package org.blackoutburst.utils;

/**
 * Créer des vecteur 2D
 * 
 * @author Blackoutburst
 * 
 * @since 1.1
 *
 */

public class Vector2f {
	public float x, y;
	
	
	/**
	 * On créer un vecteur de coordonnées (0,0)
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.1
	 */
	public Vector2f() {
		this(0, 0);
	}
	
	
	/**
	 * On donne a notre vecteur les coordonée d'un autre vecteur
	 * @param v vecteur a deux dimension qui donne ses coordonée
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.1
	 */
	
	public Vector2f(Vector2f v) {
		this(v.x, v.y);
	}
	
	
	/**
	 * On créer un vecteur de coordonnées (x,y)
	 * @param x la coordonnée horizontale du vecteur
	 * @param y la coordonnée verticale du vecteur
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
	 * Définit les coordonée d'un vecteur
	 * @param x la coordonnée horizontale du vecteur
	 * @param y la coordonnée verticale du vecteur
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
	 * On prend les coordonée d'un vecteur pour calculer les normes de ce dernier
	 * 
	 * @return le vecteur avec la norme de ses coordonnées
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
	 * @return le vecteur avec des coordonnée multiplier par le vecteur v
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
	 * On récupère la longeur d'un vecteur
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