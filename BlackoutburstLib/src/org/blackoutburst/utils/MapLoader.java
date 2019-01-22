package org.blackoutburst.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.List;

import org.blackoutburst.graphics.Colors;
import org.blackoutburst.graphics.Light;
import org.blackoutburst.graphics.LightManager;

import org.lwjgl.util.vector.Vector2f;

/**
 * Charge les map
 * @author Blackoutburst
 * @since 1.1
 */
public class MapLoader {

	/**
	 * Charge une map a partir d'un fichier map généré par B.M.E (version minimum 1.2)
	 * et retourne une liste contenant tout les tiles de la map
	 * 
	 * @param filePath le répertoire du fichier de la map (sans extension)
	 * @param texturefolder le chemin ou son situer les texture
	 * @return Une liste de tiles contenant toute la map
	 * @author Blackoutburst
	 * @since 1.1
	 */
	
	public static List<Tiles> loadTiles(String filePath, String textureFolder) {
		List<Tiles> tiles = new ArrayList<Tiles>();
		InputStream in = MapLoader.class.getResourceAsStream(filePath+".dat");
		
		try {
			LineNumberReader lnr = new LineNumberReader(new InputStreamReader(in));
			int lines = 0;
            while (lnr.readLine() != null){
            	lines++;
            }
            lnr.close();
		
            in = MapLoader.class.getResourceAsStream(filePath+".dat"); 
            
			try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
				br.readLine();
			    for(int i = 0; i < lines; i ++){
						String str = br.readLine();
						String[] val = str.split(" ");
						if(str.startsWith("B")) {
							tiles.add(new Tile(Loader.loadPNG(textureFolder+"/"+String.valueOf(val[7])),Integer.valueOf(val[1]), Integer.valueOf(val[2]), Integer.valueOf(val[3]), Integer.valueOf(val[4]), Boolean.valueOf(val[5]), Colors.WHITE, Integer.valueOf(val[6])));
						}
					}
			    br.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		return tiles;
	}
	
	/**
	 * Charge les lumière d'un fichier map .dat créer avec B.M.E (version minimum 1.2) vers la liste de lumière de LightManager
	 * @param filePath le chemin ou se trouve la map
	 * @author Blackoutburst
	 * @since 1.2
	 * @see LightManager
	 */
	public static void loadLight(String filePath) {
		InputStream in = MapLoader.class.getResourceAsStream(filePath+".dat");
		
		try {
			LineNumberReader lnr = new LineNumberReader(new InputStreamReader(in));
			int lines = 0;
            while (lnr.readLine() != null){
            	lines++;
            }
            lnr.close();
		
            in = MapLoader.class.getResourceAsStream(filePath+".dat"); 
            
			try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
			    for(int i = 0; i < lines; i ++){
						String str = br.readLine();
						String[] val = str.split(" ");
						if(str.startsWith("L")) {
							LightManager.lights.add(new Light(new Vector2f(Float.valueOf(val[1]), Float.valueOf(val[2])), Float.valueOf(val[3]), Float.valueOf(val[4]), Float.valueOf(val[5]), Float.valueOf(val[6])));
						}
					}
			    br.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

	
}
