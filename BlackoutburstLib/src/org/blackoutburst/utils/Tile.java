package org.blackoutburst.utils;

import org.blackoutburst.graphics.Colors;
import org.newdawn.slick.opengl.Texture;

public class Tile extends Tiles {

	public Tile(Texture texture, int x, int y, int width, int height, boolean solid, Colors color, int rotation) {
		super(texture, x, y, width, height, solid, color, rotation);
	}

}
