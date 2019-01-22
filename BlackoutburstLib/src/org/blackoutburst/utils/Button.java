package org.blackoutburst.utils;

import org.blackoutburst.graphics.Colors;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

/**
 * La classe des bouton 
 * @author Blackoutburst
 * @since 1.0
 *
 */
public abstract class Button {
	
	private static float xMouse;
	private static float yMouse;
	private static boolean clic;
	
	protected Texture texture;
	protected float x;
	protected float y;
	protected float w;
	protected float h;
	protected Colors color;
	protected float rotation;
	protected boolean clicked;
	protected boolean hover;
	
	
	public Button(Texture texture, float x, float y, float w, float h, Colors color, float rotation, boolean clicked, boolean hover) {
		this.texture = texture;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.color = color;
		this.rotation = rotation;
		this.clicked = clicked;
		this.hover = hover;
	}
	
	
	public abstract void update();
	public abstract void render();
	
	/**
	 * On récupère l'état de la sourie. <b>Appeller cette fonction a chaque mise a jours a la fin</b>
	 * @param button le bouton de la sourie choisit
	 * @author Blackoutburst
	 * @since 1.0
	 * @see Mouse org.lwjgl.input.Mouse
	 */
	public static void getMouse(int button) {
		xMouse = Mouse.getX();
		yMouse = Display.getHeight() - Mouse.getY();
		if(Mouse.isButtonDown(button)){clic=true;}else{clic=false;}
	}
	
	
	/**
	 * On prend la position horizontale du bouton
	 * @return la position horizontale du bouton
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public float getX() {
		return x;
	}
	/**
	 * On définit la position horizontale du bouton
	 * @param x la position horizontale du bouton
	 * @author Blackoutburst
	 * @since 1.0
	 * 
	 */
	public void setX(float x) {
		this.x = x;
	}
	/**
	 * On prend la position verticale du bouton
	 * @return la position verticale du bouton
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public float getY() {
		return y;
	}
	/**
	 * On définit la position verticale du bouton
	 * @param y la position verticale du bouton
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public void setY(float y) {
		this.y = y;
	}
	/**
	 * On prend la largeur du bouton
	 * @return la largeur du bouton
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public float getW() {
		return w;
	}
	/**
	 * On définit la largeur du bouton
	 * @param w la largeur du bouton
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public void setW(float w) {
		this.w = w;
	}
	/**
	 * On prend la hauteur du bouton
	 * @return la hauteur du bouton
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public float getH() {
		return h;
	}
	/**
	 * On définit la hauteur du bouton
	 * @param h la hauteur du bouton
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public void setH(float h) {
		this.h = h;
	}
	/**
	 * On prend la couleur du bouton
	 * @return la couleur du bouton (RGBA)
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public Colors getColor() {
		return color;
	}
	/**
	 * On définit la couleur du bouton
	 * @param color la couleur du bouton (RGBA) 
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public void setColor(Colors color) {
		this.color = color;
	}
	/**
	 * On prend la rotation du bouton
	 * @return la rotation du bouton
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public float getRotation() {
		return rotation;
	}
	/**
	 * On définit la rotation du bouton
	 * @param rotation la rotation du bouton
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public void setRotation(float rotation) {
		this.rotation = rotation;
	}
	/**
	 * On vérifie si le bouton est cliquer
	 * @param button le bouton de la sourie avec lequel on clique le bouton
	 * @return le bouton est cliquer ou non
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public boolean isClicked(int button) {
		if(xMouse >= x && xMouse <= x + w && yMouse >= y && yMouse <= y + h && Mouse.isButtonDown(button) && !clic){
			return !clicked;
		}
		return clicked;
	}
	/**
	 * On définit si le bouton est cliquer
	 * @param clicked si le bouton est cliquer ou non
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public void setClicked(boolean clicked) {
		this.clicked = clicked;
	}
	/**
	 * On vérifie si le bouton est survoler par la sourie
	 * @return le bouton est survoler par la sourie ou non
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public boolean isHover() {
		if(xMouse >= x && xMouse <= x + w && yMouse >= y && yMouse <= y + h){
			return !hover;
		}
		return hover;
	}

	/**
	 * On définit si le bouton est survoler ou non
	 * @param hover le bouton est suvoler ou non
	 * @author Blackoutburst
	 * @since 1.0
	 */
	public void setHover(boolean hover) {
		this.hover = hover;
	}

	
}
