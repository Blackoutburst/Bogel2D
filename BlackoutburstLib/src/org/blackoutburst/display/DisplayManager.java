package org.blackoutburst.display;

import java.nio.ByteBuffer;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;
import org.lwjgl.util.glu.GLU;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 * 
 * Permet de cr�er et mettre a jours la fen�tre principale du jeu
 * 
 * @author Blackoutburst
 * 
 * 
 * @since 1.0
 *
 */

public class DisplayManager {
	private static int w, h;
	private static ByteBuffer icon16 = null;
	private static ByteBuffer icon32 = null;
	
	/**
	 * Fonction de cr�ation de fen�tre indispensable pour la cr�ation des jeux.
	 * A appeller durant l'initionalisation de jeu <b>en premier</b>
	 * 
	 * @param width d�finit la largeur de la fen�tre <i>(uniquement en mode fen�tre)</i>
	 * @param height d�finit la hauteur de la fen�tre <i>(uniquement en mode fen�tre)</i>
	 * @param fullscreen d�finit le pleins �crans <i>(d�sactive les argument width & hiehgt)</i>
	 * @param resizable permet de redimensionner la fen�tre <i>(uniquement en mode fen�tre)</i>
	 * @param title donne un nom a la fenetre <i>(par d�faut le nom correspond a "Game")</i>
	 * @param vSync rafraichit le programme autant de fois que le rafraichissement de l'�crans <i>(Hz)</i>
	 * @param grabMouse bloque la sourie dans la fen�tre et la rend invisible
	 * @param iconPath16 le chemin ou se situe l'incone en 16x16 px pour le placer en haut sur la fen�tre
	 * @param iconPath32 le chemin ou se situe l'icone en 32x32 px pour le placer dans la barre des taches
	 * 
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.0
	 * 
	 */
	public static void create(int width, int height, boolean fullscreen, boolean resizable, String title, boolean vSync, boolean grabMouse, String iconPath16, String iconPath32) {
		try {
				try {
					Display.create(new PixelFormat(0, 24,  8, 0));
				}catch(Exception e) {
					Display.create();
				}
			try {
				
				icon16 = ByteBuffer.wrap(TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(iconPath16+".png")).getTextureData());
				icon32 = ByteBuffer.wrap(TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(iconPath32+".png")).getTextureData());
				Display.setIcon(new ByteBuffer[]{icon16, icon32});
			} catch (Exception e) {
				System.err.println("Icon not founds !");
			}		
		
			Display.setFullscreen(fullscreen);
			
			if(!fullscreen) {
				Display.setDisplayMode(new DisplayMode(width, height));
			}
			
			Display.setResizable(resizable);
			Display.setTitle(title);
			Display.setVSyncEnabled(vSync);
			Mouse.setGrabbed(grabMouse);
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Mise a jours de la fen�tre. 
	 * Appeller cette fonction a chaque d�but de mise a jours <b>en premier</b>.
	 *
	 * @author Blackoutburst
	 * 
	 * @since 1.0
	 * 
	 */
	public static void update() {
		w = Display.getWidth();
		h = Display.getHeight();
		
		GL11.glViewport(0, 0, w, h);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GLU.gluOrtho2D(0, w, h, 0);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glLoadIdentity();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glEnable(GL11.GL_BLEND);
		Display.update();
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		GL11.glClearColor(0.1f, 0.1f, 0.1f, 1);

		if(Display.isCloseRequested()) {
			Display.destroy();
			System.exit(0);
		}
	}
}
