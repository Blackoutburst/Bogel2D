package org.blackoutburst.graphics;
import java.awt.Point;

import org.blackoutburst.utils.Camera;
import org.blackoutburst.utils.Loader;
import org.blackoutburst.utils.Vector2f;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.opengl.Texture;


/**
 * 
 * Créer et gère les rectangle du jeu avec les texture et couleur<br>
 *
 * Utiliser la variable ambiantLight Float[] {R,G,B} pour la gestion de la lumière générale appliquer sur les block 
 * 
 * @author Blackoutburst
 * 
 * @since 1.0
 *
 */

public class Render {
	private static Texture line = Loader.loadPNG("files/line");	
	private static Texture defaultTexture = Loader.loadJPG("");
	
	private static Image defaultImage = Loader.loadImageFromWeb("");

	public static Colors ambiantLight = new Colors();
	
	public static int lightPower = 50;

	
	/**
	 * Utiliser pour créer des rectangle avec une seule texture dans une image.
	 * <b>Si aucune image n'est trouver on charge la texture par défaut :</b>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: 0 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: 0 0px 0 0"></div><br>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: -6 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: -6 0px 0 0"></div>
	 * 
	 * @param texture la texture utiliser sur le rectangle
	 * @param x la position horizontale du rectangle
	 * @param y la position verticale du rectangle
	 * @param width la largeur du rectangle
	 * @param height la hauteur du rectangle
	 * @param color la couleur du rectangle
	 * @param rotation la rotation du rectangle
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.0
	 * 
	 */
	public static void quadS(Texture texture, float x, float y, float width, float height, Colors color, float rotation) {
		if(x + width > -Camera.getX() && x < -Camera.getX() + Display.getWidth() && y + height > -Camera.getY() && y < -Camera.getY() + Display.getHeight()) {
			try {
				texture.bind();
			}catch(Exception e) {
				defaultTexture.bind();
			}
			
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
			
	        GL11.glPushMatrix();
	        GL11.glTranslatef(x +width/2,y +height/2, 0);
	        GL11.glRotatef(-rotation, 0, 0, 1);
	        GL11.glTranslatef(-x - width/2,-y - height/2, 0);
	        GL11.glBegin(GL11.GL_QUADS);
	        GL11.glColor4f(color.red, color.green, color.blue, color.alpha);
	        GL11.glTexCoord2f((0), (0));GL11.glVertex2f(x, y);
	        GL11.glTexCoord2f((1), (0));GL11.glVertex2f(x + width, y);
	        GL11.glTexCoord2f((1), (1));GL11.glVertex2f(x + width, y + height);
	        GL11.glTexCoord2f((0), (1));GL11.glVertex2f(x, y + height);
	        GL11.glEnd();
	        
	        
	        
	        GL11.glPopMatrix();
		}
    }
	/**
	 * 
	 * Utiliser pour créer des rectangle avec plusieur texture dans une image
	 * 
	 * <b>Si aucune image n'est trouver on charge la texture par défaut :</b>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: 0 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: 0 0px 0 0"></div><br>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: -6 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: -6 0px 0 0"></div>
	 * 
	 * @param texture la texture utiliser sur le rectangle
	 * @param x position horizontale du rectangle
	 * @param y la position verticale du rectangle
	 * @param width la largeur du rectangle
	 * @param height la hauteur du rectangle
	 * @param color la couleur du rectangle
	 * @param rows le nombre d'image dans la texture
	 * @param xo la position horizontale de l'image dans la texture
	 * @param yo la position verticale de l'image dans la texture
	 * @param rotation la rotation du rectangle
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.0
	 * 
	 */
	public static void quadM(Texture texture, float x, float y, float width, float height, Colors color, float rows, int xo, int yo, float rotation) {
		if(x + width > -Camera.getX() && x < -Camera.getX() + Display.getWidth() && y + height > -Camera.getY() && y < -Camera.getY() + Display.getHeight()) {
			try {
				texture.bind();
			}catch(Exception e) {
				defaultTexture.bind();
			}
			
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
			
			GL11.glPushMatrix();
	        GL11.glTranslatef(x +width/2,y +height/2, 0);
	        GL11.glRotatef(-rotation, 0, 0, 1);
	        GL11.glTranslatef(-x - width/2,-y - height/2, 0);
	        GL11.glBegin(GL11.GL_QUADS);
	        GL11.glColor4f(color.red, color.green, color.blue, color.alpha);
	        GL11.glTexCoord2f((0+xo)/rows, (0+yo)/rows);GL11.glVertex2f(x, y);
	        GL11.glTexCoord2f((1+xo)/rows, (0+yo)/rows);GL11.glVertex2f(x + width, y);
	        GL11.glTexCoord2f((1+xo)/rows, (1+yo)/rows);GL11.glVertex2f(x + width, y + height);
	        GL11.glTexCoord2f((0+xo)/rows, (1+yo)/rows);GL11.glVertex2f(x, y + height);
	        GL11.glEnd();
	        GL11.glPopMatrix();
		}
    }
	
	/**
	 * Permet d'afficher les images charger via URL
	 * 
	 * <b>Si aucune image n'est trouver on charge la texture par défaut :</b>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: 0 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: 0 0px 0 0"></div><br>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: -6 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: -6 0px 0 0"></div>
	 * 
	 * @param image l'image choisit
	 * @param x la position horizontale de l'image
	 * @param y la position vertical de l'image
	 * @param width la largeur de l'image
	 * @param height la hauteur de l'image
	 * @param color la couleur de l'image
	 * 
	 * @author Blackoutburst
	 * @since 1.1
	 */
	public static void renderImage(Image image ,float x, float y, float width, float height, Color color) {
		if(x + width > -Camera.getX() && x < -Camera.getX() + Display.getWidth() && y + height > -Camera.getY() && y < -Camera.getY() + Display.getHeight()) {
			try {
				image.setFilter(Image.FILTER_NEAREST);
				image.draw(x, y, width, height, color);
			}catch(Exception e) {
				defaultImage.setFilter(Image.FILTER_NEAREST);
				defaultImage.draw(x, y, width, height, color);
			}
		}
	}
	
	/**
	 * Créer des ligne entre deux coordonées de point donner
	 * 
	 * @param x1 la position horizontale du premier point
	 * @param y1 la position verticale du premier point
	 * @param x2 la position horizontale du second point
	 * @param y2 la position verticale du second point
	 * @param color la couleur de la ligne
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.0
	 * 
	 */
	public static void line(float x1, float y1, float x2, float y2, Colors color) {
		line.bind();
		GL11.glBegin(GL11.GL_LINES);
		GL11.glColor3f(color.red, color.green, color.blue);
		GL11.glVertex2f(x1, y1);
		GL11.glVertex2f(x2, y2);
		GL11.glEnd();
	}
	
	/**
	 * Créer une ligne entre deux point
	 * 
	 * @param point1 le premier point
	 * @param point2 le second point
	 * @param color la couleur de la ligne
	 * 
	 * @see Point java.awt.Point
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.1
	 * 
	 */
	public static void pointLine(Point point1, Point point2, Colors color) {
		line.bind();
		GL11.glBegin(GL11.GL_LINES);
		GL11.glColor3f(color.red, color.green, color.blue);
		GL11.glVertex2f(point1.x, point1.y);
		GL11.glVertex2f(point2.x, point2.y);
		GL11.glEnd();
	}
	
	/**
	 * On affiche du texte aligner sur la gauche
	 * 
	 * @param x la position horizontale du texte
	 * @param y la position verticale du texte
	 * @param whatchars le texte a écrire
	 * @param color la couleur du texte
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.1
	 */
	public static void drawTextLeft(float x, float y, String whatchars, Color color) {
		if(x + Loader.text.getWidth(whatchars) > -Camera.getX() && x < -Camera.getX() + Display.getWidth() && y + Loader.text.getHeight() > -Camera.getY() && y < -Camera.getY() + Display.getHeight()) {
			Loader.text.drawString(x, y, whatchars, color);
		}
	}
	
	/**
	 * On affiche du texte aligner au centre
	 * 
	 * @param x la position horizontale du texte
	 * @param y la position verticale du texte
	 * @param whatchars le texte a écrire
	 * @param color la couleur du texte
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.1
	 */
	public static void drawTextCenter(float x, float y, String whatchars, Color color) {
		x = x-Loader.text.getWidth(whatchars)/2;
		if(x + Loader.text.getWidth(whatchars) > -Camera.getX() && x < -Camera.getX() + Display.getWidth() && y + Loader.text.getHeight() > -Camera.getY() && y < -Camera.getY() + Display.getHeight()) {
			Loader.text.drawString(x, y, whatchars, color);
		}
	}
	
	/**
	 * On affiche du texte aligner sur la droite
	 * 
	 * @param x la position horizontale du texte
	 * @param y la position verticale du texte
	 * @param whatchars le texte a écrire
	 * @param color la couleur du texte
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.1
	 */
	public static void drawTextRight(float x, float y, String whatchars, Color color) {
		x = x-Loader.text.getWidth(whatchars);
		if(x + Loader.text.getWidth(whatchars) > -Camera.getX() && x < -Camera.getX() + Display.getWidth() && y + Loader.text.getHeight() > -Camera.getY() && y < -Camera.getY() + Display.getHeight()) {
			Loader.text.drawString(x, y, whatchars, color);
		}
	}
	
	/**
	 * On affiche du texte customiser aligner sur la gauche
	 * 
	 * @param x la position horizontale du texte
	 * @param y la position verticale du texte
	 * @param whatchars le texte a écrire
	 * @param color la couleur du texte
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.1
	 */
	public static void drawCustomTextLeft(TrueTypeFont text, float x, float y, String whatchars, Color color) {
		if(x + text.getWidth(whatchars) > -Camera.getX() && x < -Camera.getX() + Display.getWidth() && y + text.getHeight() > -Camera.getY() && y < -Camera.getY() + Display.getHeight()) {
			text.drawString(x, y, whatchars, color);
		}
	}
	
	/**
	 * On affiche du texte customiser aligner au centre
	 * 
	 * @param x la position horizontale du texte
	 * @param y la position verticale du texte
	 * @param whatchars le texte a écrire
	 * @param color la couleur du texte
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.1
	 */
	public static void drawCustomTextCenter(TrueTypeFont text, float x, float y, String whatchars, Color color) {
		x = x-text.getWidth(whatchars)/2;
		if(x + text.getWidth(whatchars) > -Camera.getX() && x < -Camera.getX() + Display.getWidth() && y + text.getHeight() > -Camera.getY() && y < -Camera.getY() + Display.getHeight()) {
			text.drawString(x, y-text.getHeight()/2, whatchars, color);
		}
	}
	
	/**
	 * On affiche du texte customiser aligner sur la droite
	 * 
	 * @param x la position horizontale du texte
	 * @param y la position verticale du texte
	 * @param whatchars le texte a écrire
	 * @param color la couleur du texte
	 * 
	 * @author Blackoutburst
	 * 
	 * @since 1.1
	 */
	public static void drawCustomTextRight(TrueTypeFont text, float x, float y, String whatchars, Color color) {
		x = x-text.getWidth(whatchars);
		if(x + text.getWidth(whatchars) > -Camera.getX() && x < -Camera.getX() + Display.getWidth() && y + text.getHeight() > -Camera.getY() && y < -Camera.getY() + Display.getHeight()) {
			text.drawString(x, y, whatchars, color);
		}
	}
	
	/**
	 *  Créer un carré avec une seule texture affecter par la lumière de manière lisse et propre
	 *  
	 * <b>Si aucune image n'est trouver on charge la texture par défaut :</b>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: 0 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: 0 0px 0 0"></div><br>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: -6 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: -6 0px 0 0"></div>
	 *  
	 * @param texture la texture utiliser sur le rectangle
	 * @param x la position horizontale
	 * @param y la position verticale
	 * @param width la largeur
	 * @param height la hauteur
	 * @param rotation la rotation
	 * 
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public static void quadSHighLight(Texture texture, float x, float y, float width, float height, float rotation) {
		if(x + width > -Camera.getX() && x < -Camera.getX() + Display.getWidth() && y + height > -Camera.getY() && y < -Camera.getY() + Display.getHeight()) {
				
			try {
				texture.bind();
			}catch(Exception e) {
				defaultTexture.bind();
			}
			
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
			
			float r = 0, g = 0, b = 0;
			float rp = 0, gp = 0, bp = 0;
			Vector2f vector;
	        GL11.glPushMatrix();
	        GL11.glTranslatef(x +width/2,y +height/2, 0);			
	        GL11.glRotatef(rotation, 0, 0, 1);
	        GL11.glTranslatef(-x - width/2,-y - height/2, 0);
	        GL11.glBegin(GL11.GL_QUADS);
	        GL11.glColor4f(ambiantLight.red, ambiantLight.green, ambiantLight.blue,  1);
	        for(Light l : LightManager.lights) {
		        vector = new Vector2f(x - l.location.getX(), y - (l.location.getY()));
		        rp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.red;
		        gp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.green;
		        bp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.blue;
		        if(rp<0){rp=0;}
		        if(gp<0){gp=0;}
		        if(bp<0){bp=0;}
		        r += rp;
		        g += gp;
		        b += bp;
		        
	        }
	        
		    r += ambiantLight.red;
		    g += ambiantLight.green;
		    b += ambiantLight.blue;
		        
		    GL11.glColor4f(r, g, b,  1);
	        rp = 0;
	        gp = 0;
	        bp = 0;
	        r = 0;
	        g = 0;
	        b = 0;
	        GL11.glTexCoord2f((0), (0));GL11.glVertex2f(x, y);
	        GL11.glColor4f(ambiantLight.red, ambiantLight.green, ambiantLight.blue,  1);
	        for(Light l : LightManager.lights) {
	            vector = new Vector2f(x+width - l.location.getX(), y - (l.location.getY()));
	            rp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.red;
		        gp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.green;
		        bp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.blue;
		        if(rp<0){rp=0;}
		        if(gp<0){gp=0;}
		        if(bp<0){bp=0;}
		        r += rp;
		        g += gp;
		        b += bp;
		        
	        }  
	        
	        
	        r += ambiantLight.red;
	        g += ambiantLight.green;
	        b += ambiantLight.blue;
	        
		    GL11.glColor4f(r, g, b,  1);
	        rp = 0;
	        gp = 0;
	        bp = 0;
	        r = 0;
	        g = 0;
	        b = 0;
	        GL11.glTexCoord2f((1), (0));GL11.glVertex2f(x + width, y);
	        GL11.glColor4f(ambiantLight.red, ambiantLight.green, ambiantLight.blue,  1);
	        for(Light l : LightManager.lights) {
	            vector = new Vector2f(x+width - l.location.getX(), y+height - (l.location.getY()));
	            rp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.red;
		        gp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.green;
		        bp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.blue;
		        if(rp<0){rp=0;}
		        if(gp<0){gp=0;}
		        if(bp<0){bp=0;}
		        r += rp;
		        g += gp;
		        b += bp;
	        }
	        
	        r += ambiantLight.red;
	        g += ambiantLight.green;
	        b += ambiantLight.blue;
	        
		    GL11.glColor4f(r, g, b,  1);
	        rp = 0;
	        gp = 0;
	        bp = 0;
	        r = 0;
	        g = 0;
	        b = 0;
	        GL11.glTexCoord2f((1), (1));GL11.glVertex2f(x + width, y + height);
	        for(Light l : LightManager.lights) {
	            vector = new Vector2f(x - l.location.getX(), y+height - (l.location.getY()));
	            rp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.red;
		        gp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.green;
		        bp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.blue;
		        if(rp<0){rp=0;}
		        if(gp<0){gp=0;}
		        if(bp<0){bp=0;}
		        r += rp;
		        g += gp;
		        b += bp;
	        }
	        
	        
	        r += ambiantLight.red;
	        g += ambiantLight.green;
	        b += ambiantLight.blue;
		        
		    GL11.glColor4f(r, g, b,  1);
	        GL11.glTexCoord2f((0), (1));GL11.glVertex2f(x, y + height);
	        GL11.glEnd();
	        GL11.glPopMatrix();
	    }
	}


	/**
	 * Créer un carré avec une seule texture affecter par la lumière tout le bloc est affecter d'un coup et créer une limère non lisse
	 * 
	 * <b>Si aucune image n'est trouver on charge la texture par défaut :</b>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: 0 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: 0 0px 0 0"></div><br>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: -6 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: -6 0px 0 0"></div>
	 * 
	 * @param texture la texture utiliser sur le rectangle
	 * @param x la position horizontale
	 * @param y la position verticale
	 * @param width la largeur
	 * @param height la hauteur
	 * @param rotation la rotation
	 * 
	 * @author Blackoutburst
	 * @since 1.2
	 */
		
	public static void quadSLowLight(Texture texture, float x, float y, float width, float height, float rotation) {
		if(x + width > -Camera.getX() && x < -Camera.getX() + Display.getWidth() && y + height > -Camera.getY() && y < -Camera.getY() + Display.getHeight()) {
				
			try {
				texture.bind();
			}catch(Exception e) {
				defaultTexture.bind();
			}
			
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
			
			float r = 0, g = 0, b = 0;
			float rp = 0, gp = 0, bp = 0;
			Vector2f vector;
		    GL11.glPushMatrix();
		    GL11.glTranslatef(x +width/2,y +height/2, 0);
		    GL11.glRotatef(rotation, 0, 0, 1);
		    GL11.glTranslatef(-x - width/2,-y - height/2, 0);
		    GL11.glBegin(GL11.GL_QUADS);
		    GL11.glColor4f(ambiantLight.red, ambiantLight.green, ambiantLight.blue,  1);
		    for(Light l : LightManager.lights) {
		        vector = new Vector2f(x+width/2 - l.location.getX(), y+height/2 - (l.location.getY()));
		        rp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.red;
		        gp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.green;
		        bp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.blue;
		        if(rp<0){rp=0;}
		        if(gp<0){gp=0;}
		        if(bp<0){bp=0;}
		        r += rp;
		        g += gp;
		        b += bp;
		        
		    }
		    
		    r += ambiantLight.red;
		    g += ambiantLight.green;
		    b += ambiantLight.blue;
		        
		    GL11.glColor4f(r, g, b,  1);
		
		    GL11.glTexCoord2f((0), (0));GL11.glVertex2f(x, y);
		    GL11.glTexCoord2f((1), (0));GL11.glVertex2f(x + width, y);
		    GL11.glTexCoord2f((1), (1));GL11.glVertex2f(x + width, y + height);
		    GL11.glTexCoord2f((0), (1));GL11.glVertex2f(x, y + height);
		    GL11.glEnd();
		    GL11.glPopMatrix();
		}
	}
	
	
	
	
	/**
	 *  Créer un carré avec plusieur textures affecter par la lumière de manière lisse et propre
	 *  
	 * <b>Si aucune image n'est trouver on charge la texture par défaut :</b>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: 0 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: 0 0px 0 0"></div><br>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: -6 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: -6 0px 0 0"></div>
	 *  
	 * @param texture la texture utiliser sur le rectangle
	 * @param x la position horizontale
	 * @param y la position verticale
	 * @param width la largeur
	 * @param height la hauteur
	 * @param rows le nombre de textures dans l'image
	 * @param xo la position horizonrtale dans l'image
	 * @param yo la position verticale dans l'image
	 * @param rotation la rotation
	 * 
	 * @author Blackoutburst
	 * @since 1.2
	 */
	public static void quadMHighLight(Texture texture, float x, float y, float width, float height, float rows, int xo, int yo, float rotation) {
		if(x + width > -Camera.getX() && x < -Camera.getX() + Display.getWidth() && y + height > -Camera.getY() && y < -Camera.getY() + Display.getHeight()) {
			try {
				texture.bind();
			}catch(Exception e) {
				defaultTexture.bind();
			}
			
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
			
			float r = 0, g = 0, b = 0;
			float rp = 0, gp = 0, bp = 0;
			Vector2f vector;
	        GL11.glPushMatrix();
	        GL11.glTranslatef(x +width/2,y +height/2, 0);			
	        GL11.glRotatef(rotation, 0, 0, 1);
	        GL11.glTranslatef(-x - width/2,-y - height/2, 0);
	        GL11.glBegin(GL11.GL_QUADS);
	        GL11.glColor4f(ambiantLight.red, ambiantLight.green, ambiantLight.blue,  1);
	        for(Light l : LightManager.lights) {
		        vector = new Vector2f(x - l.location.getX(), y - (l.location.getY()));
		        rp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.red;
		        gp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.green;
		        bp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.blue;
		        if(rp<0){rp=0;}
		        if(gp<0){gp=0;}
		        if(bp<0){bp=0;}
		        r += rp;
		        g += gp;
		        b += bp;
		        
	        }
	        
		    r += ambiantLight.red;
		    g += ambiantLight.green;
		    b += ambiantLight.blue;
		        
		    GL11.glColor4f(r, g, b,  1);
	        rp = 0;
	        gp = 0;
	        bp = 0;
	        r = 0;
	        g = 0;
	        b = 0;
	        GL11.glTexCoord2f((0+xo)/rows, (0+yo)/rows);GL11.glVertex2f(x, y);
	        GL11.glColor4f(ambiantLight.red, ambiantLight.green, ambiantLight.blue,  1);
	        for(Light l : LightManager.lights) {
	            vector = new Vector2f(x+width - l.location.getX(), y - (l.location.getY()));
	            rp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.red;
		        gp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.green;
		        bp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.blue;
		        if(rp<0){rp=0;}
		        if(gp<0){gp=0;}
		        if(bp<0){bp=0;}
		        r += rp;
		        g += gp;
		        b += bp;
		        
	        }  
	        
	        
	        r += ambiantLight.red;
	        g += ambiantLight.green;
	        b += ambiantLight.blue;
	        
		    GL11.glColor4f(r, g, b,  1);
	        rp = 0;
	        gp = 0;
	        bp = 0;
	        r = 0;
	        g = 0;
	        b = 0;
	        GL11.glTexCoord2f((1+xo)/rows, (0+yo)/rows);GL11.glVertex2f(x + width, y);
	        GL11.glColor4f(ambiantLight.red, ambiantLight.green, ambiantLight.blue,  1);
	        for(Light l : LightManager.lights) {
	            vector = new Vector2f(x+width - l.location.getX(), y+height - (l.location.getY()));
	            rp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.red;
		        gp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.green;
		        bp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.blue;
		        if(rp<0){rp=0;}
		        if(gp<0){gp=0;}
		        if(bp<0){bp=0;}
		        r += rp;
		        g += gp;
		        b += bp;
	        }
	        
	        r += ambiantLight.red;
	        g += ambiantLight.green;
	        b += ambiantLight.blue;
	        
		    GL11.glColor4f(r, g, b,  1);
	        rp = 0;
	        gp = 0;
	        bp = 0;
	        r = 0;
	        g = 0;
	        b = 0;
	        GL11.glTexCoord2f((1+xo)/rows, (1+yo)/rows);GL11.glVertex2f(x + width, y + height);
	        for(Light l : LightManager.lights) {
	            vector = new Vector2f(x - l.location.getX(), y+height - (l.location.getY()));
	            rp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.red;
		        gp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.green;
		        bp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.blue;
		        if(rp<0){rp=0;}
		        if(gp<0){gp=0;}
		        if(bp<0){bp=0;}
		        r += rp;
		        g += gp;
		        b += bp;
	        }
	        
	        
	        r += ambiantLight.red;
	        g += ambiantLight.green;
	        b += ambiantLight.blue;
		        
		    GL11.glColor4f(r, g, b,  1);
	        GL11.glTexCoord2f((0+xo)/rows, (1+yo)/rows);GL11.glVertex2f(x, y + height);
	        GL11.glEnd();
	        GL11.glPopMatrix();
	    }
	}


	/**
	 * Créer un carré avec plusieur textures affecter par la lumière tout le bloc est affecter d'un coup et créer une limère non lisse
	 * 
	 * <b>Si aucune image n'est trouver on charge la texture par défaut :</b>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: 0 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: 0 0px 0 0"></div><br>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: -6 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: -6 0px 0 0"></div>
	 * 
	 * @param texture la texture utiliser sur le rectangle
	 * @param x la position horizontale
	 * @param y la position verticale
	 * @param width la largeur
	 * @param height la hauteur
	 * @param rows le nombre de texture dans l'image
	 * @param xo la position horizontale dans l'image
	 * @param yo la position verticale dans l'image
	 * @param rotation la rotation
	 * 
	 * @author Blackoutburst
	 * @since 1.2
	 */
		
	public static void quadMLowLight(Texture texture, float x, float y, float width, float height, float rows, int xo, int yo, float rotation) {
		if(x + width > -Camera.getX() && x < -Camera.getX() + Display.getWidth() && y + height > -Camera.getY() && y < -Camera.getY() + Display.getHeight()) {
				
			try {
				texture.bind();
			}catch(Exception e) {
				defaultTexture.bind();
			}
			
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
			GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
			
			float r = 0, g = 0, b = 0;
			float rp = 0, gp = 0, bp = 0;
			Vector2f vector;
		    GL11.glPushMatrix();
		    GL11.glTranslatef(x +width/2,y +height/2, 0);
		    GL11.glRotatef(rotation, 0, 0, 1);
		    GL11.glTranslatef(-x - width/2,-y - height/2, 0);
		    GL11.glBegin(GL11.GL_QUADS);
		    GL11.glColor4f(ambiantLight.red, ambiantLight.green, ambiantLight.blue,  1);
		    for(Light l : LightManager.lights) {
		    	vector = new Vector2f(x+width/2 - l.location.getX(), y+height/2 - (l.location.getY()));
		        rp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.red;
		        gp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.green;
		        bp += (((lightPower * l.scale))  - (vector.length()))/((lightPower * l.scale))*l.blue;
		        if(rp<0){rp=0;}
		        if(gp<0){gp=0;}
		        if(bp<0){bp=0;}
		        r += rp;
		        g += gp;
		        b += bp;
		        
		    }
		    
		        r += ambiantLight.red;
		        g += ambiantLight.green;
		        b += ambiantLight.blue;
		        
		        GL11.glColor4f(r, g, b,  1);
		
		    GL11.glTexCoord2f((0+xo)/rows, (0+yo)/rows);GL11.glVertex2f(x, y);
		    GL11.glTexCoord2f((1+xo)/rows, (0+yo)/rows);GL11.glVertex2f(x + width, y);
		    GL11.glTexCoord2f((1+xo)/rows, (1+yo)/rows);GL11.glVertex2f(x + width, y + height);
		    GL11.glTexCoord2f((0+xo)/rows, (1+yo)/rows);GL11.glVertex2f(x, y + height);
		    GL11.glEnd();
		    GL11.glPopMatrix();
		}
	}
	
}
