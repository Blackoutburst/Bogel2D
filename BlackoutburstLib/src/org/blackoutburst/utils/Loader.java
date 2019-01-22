package org.blackoutburst.utils;


import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.BufferedImageUtil;
import org.newdawn.slick.util.ResourceLoader;


/**
 * 
 * Charge des objet dans la ram (texture, son, texte, police)
 * 
 * @author Blackoutburst
 * 
 * @since 1.0
 *
 */

public class Loader {
    public static Audio sound;
    public static TrueTypeFont text;
	public static TrueTypeFont textCustom16, textCustom12;
	public static Clip clip;
	public static Music song;
	
	
	/**
	 * On charge une image au format .PNG : <b>Si aucune image n'est trouver on charge la texture par défaut :</b>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: 0 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: 0 0px 0 0"></div><br>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: -6 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: -6 0px 0 0"></div>
	 *
	 * 
	 * @param filepath le chemin ou se trouve l'image (sans mêttre l'extension)
	 * @return la texture trouver
	 * 
	 * @author Blackoutburst
	 * @since 1.0
	 */
    public static Texture loadPNG(String filepath) {
        Texture texture = null;
        
        try {
            texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(filepath+".png"));
        } catch (Exception e) {
        	try {
				texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("files/null.png"));
			} catch (IOException e1) {
			}
        }
        return texture;
    }
    
    
	/**
	 * On charge une image au format .JPG : <b>Si aucune image n'est trouver on charge la texture par défaut :</b>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: 0 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: 0 0px 0 0"></div><br>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: -6 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: -6 0px 0 0"></div>
	 *
	 * 
	 * @param filepath le chemin ou se trouve l'image (sans mêttre l'extension)
	 * @return la texture trouver
	 * 
	 * @author Blackoutburst
	 * @since 1.1
	 */
    public static Texture loadJPG(String filepath) {
        Texture texture = null;
        
        try {
            texture = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream(filepath+".jpg"));
        } catch (Exception e) {
        	try {
				texture = TextureLoader.getTexture("JPG", ResourceLoader.getResourceAsStream("files/null.jpg"));
			} catch (IOException e1) {
			}
        }
        return texture;
    }

    /**
     * Permet de charger des image directement via URL : <b>Si aucune image n'est trouver on charge la texture par défaut :</b>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: 0 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: 0 0px 0 0"></div><br>
	 * <div = style="width:10px;height:10px;background-color:rgb(255,0,255);float:right;margin: -6 10px 0 0"></div>
	 * <div = style="width:10px;height:10px;background-color:rgb(0,0,0);float:right;margin: -6 0px 0 0"></div>
     * @param URL l'URL de l'image que l'on veut charger
     * @return l'image charger
     * @author Blackoutburst
	 * @since 1.1
     */
    public static Image loadImageFromWeb(String URL) {
    	Image image = null;
        try {
        	URL u = new URL(URL);
	        BufferedImage bi = ImageIO.read(u);
	        Texture texture = BufferedImageUtil.getTexture("picture", bi);
	        image = new Image(texture);
        } catch (Exception e) {
        	try {
        		image = new Image("files/null.jpg");
			} catch (SlickException e1) {
			}
        }
        return image;
    }
    
    /**
     * On charge une musique au format .OGG
     * @param filepath le chemin ou se trouve la musique (sans extension)
     * 
     * @author Blackoutburst
     * @since 1.0
     */
    public static void loadSongOGG(String filepath) {
		try {
			song = new Music(filepath+".ogg");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * On charge une musique au format .WAV    
	 * @param filepath le chemin ou se trouve la musique (sans extension)
	 * 
	 * @author Blackoutburst
	 * @since 1.0
	 */
    public void loadSongWAV(String filepath){
    	
    	
    	
    	   try (InputStream in = getClass().getResourceAsStream(filepath+".wav")) {
               InputStream bufferedIn = new BufferedInputStream(in);
               try (AudioInputStream audioIn = AudioSystem.getAudioInputStream(bufferedIn)) {
                   clip = AudioSystem.getClip();
                   clip.open(audioIn);
                   clip.setFramePosition(0);
               }
           } catch (Exception e) {
              e.printStackTrace();
          }
    }
    
    /**
     * On charge un son au format .OGG
     * @param filepath le chemin ou se trouve le son (sans extension)
     * 
     * @author Blackoutburst
     * @since 1.0
     */
    public static void playSoundOGG(String filepath) {
    	try {
			sound = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream(filepath+".ogg"));
			sound.playAsSoundEffect(1.0f, 1.0f, false);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**
     * On charge la police par défault de l'ordinateur
     * @param alias on active l'antialiasing de la police pour la lisser
     * 
     * @author Blackoutburst
     * @since 1.0
     */
    public static void loadDefaultFont(boolean alias) {
    	Font awtFont = new Font("default", Font.BOLD, 16);
    	text = new TrueTypeFont(awtFont, alias);
    }
    
    /**
     *
     * On charge une police customiser
     * @param filepath le chemin de la police (.TTF, conseiller)
     * @param alias on active l'antialiasing de la police pour la lisser (indisponible pour certaine police)
     * 
     * @author Blackoutburst
     * @since 1.0
     */
    public static void loadFont16(String filepath, boolean alias) {
		try {
			InputStream	inputStream	= ResourceLoader.getResourceAsStream(filepath);
		
			Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
			awtFont = awtFont.deriveFont(16F);
			textCustom16 = new TrueTypeFont(awtFont, alias);
		} catch (Exception e) {}
    }
		
		
	    /**
	     *
	     * On charge une police customiser
	     * @param filepath le chemin de la police (.TTF, conseiller)
	     * @param alias on active l'antialiasing de la police pour la lisser (indisponible pour certaine police)
	     * 
	     * @author Blackoutburst
	     * @since 1.0
	     */
	    public static void loadFont12(String filepath, boolean alias) {
			try {
				InputStream	inputStream	= ResourceLoader.getResourceAsStream(filepath);
			
				Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
				awtFont = awtFont.deriveFont(12F);
				textCustom12 = new TrueTypeFont(awtFont, alias);
		} catch (Exception e) {}	
	}
}