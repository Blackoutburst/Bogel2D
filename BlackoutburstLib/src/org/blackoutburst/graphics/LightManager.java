package org.blackoutburst.graphics;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL20.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.blackoutburst.utils.Camera;
import org.blackoutburst.utils.Tiles;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;


/**
 * Classe de Gestion des lumière et du shader lumière
 * @author Blackoutburst
 * @since 1.2
 *
 */

public class LightManager {
	public static List<Light> lights = new ArrayList<Light>();
	private static int fragmentShader;
	private static int shaderProgram;
	public static int Lscale = 5;
	public static float r = 1, g = 1, b = 1;

	
	/**
	 * Charge et initialise le shader <b>obligatiore pour le fonctionnement des lumière</b><br>
	 * Appeler cette fonction lors de l'initialisation de son programme
	 */
	public static void loadShader() {
		shaderProgram = glCreateProgram();
		fragmentShader = glCreateShader(GL_FRAGMENT_SHADER);
		StringBuilder fragmentShaderSource = new StringBuilder();
		InputStream in = LightManager.class.getResourceAsStream("/shader.frag");
		try {
			String line;
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			while ((line = reader.readLine()) != null) {
				fragmentShaderSource.append(line).append("\n");
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		glShaderSource(fragmentShader, fragmentShaderSource);
		glCompileShader(fragmentShader);
		if (glGetShaderi(fragmentShader, GL_COMPILE_STATUS) == GL_FALSE) {
			System.err.println("Fragment shader not compiled!");
		}

		glAttachShader(shaderProgram, fragmentShader);
		glLinkProgram(shaderProgram);
		glValidateProgram(shaderProgram);


		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, Display.getWidth(), Display.getHeight(), 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);

		glEnable(GL_STENCIL_TEST);

	}
	
	/**
	 * Affiche les lumière et les ombres des bloc solide
	 * @param tiles la liste des tiles de la map 
	 */
	public static void render(List<Tiles> tiles) {
	for (Light light : lights) {
			if(light.location.getX() > -Camera.getX() && light.location.getX() < -Camera.getY() + Display.getWidth() && light.location.getY() > -Camera.getY() && light.location.getY() < -Camera.getY() + Display.getHeight()) {
				glColorMask(false, false, false, false);
				glStencilFunc(GL_ALWAYS, 1, 1);
				glStencilOp(GL_KEEP, GL_KEEP, GL_REPLACE);
		
				for (Tiles block : tiles) {
					if(block.isSolid()) {
						Vector2f[] vertices = block.getVertices();
						for (int i = 0; i < vertices.length; i++) {
							Vector2f currentVertex = vertices[i];
							Vector2f nextVertex = vertices[(i + 1) % vertices.length];
							Vector2f edge = Vector2f.sub(nextVertex, currentVertex, null);
							Vector2f normal = new Vector2f(edge.getY(), -edge.getX());
							Vector2f lightToCurrent = Vector2f.sub(currentVertex, light.location, null);
							if (Vector2f.dot(normal, lightToCurrent) > 0) {
								Vector2f point1 = Vector2f.add(currentVertex, (Vector2f) Vector2f.sub(currentVertex, light.location, null).scale(800), null);
								Vector2f point2 = Vector2f.add(nextVertex, (Vector2f) Vector2f.sub(nextVertex, light.location, null).scale(800), null);
								glBegin(GL_QUADS); {
									glVertex2f(currentVertex.getX(), currentVertex.getY());
									glVertex2f(point1.getX(), point1.getY());
									glVertex2f(point2.getX(), point2.getY());
									glVertex2f(nextVertex.getX(), nextVertex.getY());
								} glEnd();
							}
						}
					}
				}
		
					
				glStencilOp(GL_KEEP, GL_KEEP, GL_KEEP);
				glStencilFunc(GL_EQUAL, 0, 1);
				glColorMask(true, true, true, true);
		
				glUseProgram(shaderProgram);
				glUniform2f(glGetUniformLocation(shaderProgram, "lightLocation"), light.location.getX()+Camera.getX(), Display.getHeight() - light.location.getY()-Camera.getY());
				glUniform3f(glGetUniformLocation(shaderProgram, "lightColor"), light.red*light.scale, light.green*light.scale, light.blue*light.scale);
				glBlendFunc(GL_ONE, GL_ONE);
		
				glBegin(GL_QUADS); {
					glVertex2f(-Camera.getX(), -Camera.getY());
					glVertex2f(-Camera.getX(), -Camera.getY()+Display.getHeight());
					glVertex2f(-Camera.getX() +Display.getWidth(), -Camera.getY()+Display.getHeight());
					glVertex2f(-Camera.getX() +Display.getWidth(), -Camera.getY());
				} glEnd();
		
				glUseProgram(0);
				glClear(GL_STENCIL_BUFFER_BIT);
				glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
			}
		}
	}
	
	/**
	 * Affiche une simple lumière qui n'agit ni sur les ombres ni sur les blocs
	 * @param location la position de la lumière
	 * @param red le rouge de la lumière
	 * @param green le vert de la lumière
	 * @param blue le bleu de la lumière
	 * @param scale la taille de la lumière
	 * 
	 * @author Blackoutburst
	 * @since 1.2.1
	 * 
	 */
	public static void renderSingleLight(float x, float y, float red, float green, float blue, float scale) {
		
		if(x > -Camera.getX() && x < -Camera.getX() + Display.getWidth() && y > -Camera.getY() && y < -Camera.getY() + Display.getHeight()) {
			glUseProgram(shaderProgram);
			glUniform2f(glGetUniformLocation(shaderProgram, "lightLocation"), x+Camera.getX(), Display.getHeight() - y-Camera.getY());
			glUniform3f(glGetUniformLocation(shaderProgram, "lightColor"), red*scale, green*scale, blue*scale);
			glBlendFunc(GL_ONE, GL_ONE);
	
			glBegin(GL_QUADS); {
				glVertex2f(-Camera.getX(), -Camera.getY());
				glVertex2f(-Camera.getX(), -Camera.getY()+Display.getHeight());
				glVertex2f(-Camera.getX() +Display.getWidth(), -Camera.getY()+Display.getHeight());
				glVertex2f(-Camera.getX() +Display.getWidth(), -Camera.getY());
			} glEnd();
	
			glUseProgram(0);
			glClear(GL_STENCIL_BUFFER_BIT);
			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		}
	}
	
}
