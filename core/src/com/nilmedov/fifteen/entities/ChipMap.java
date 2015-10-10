package com.nilmedov.fifteen.entities;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Nazar on 10.10.2015.
 */
public class ChipMap {
	private Rectangle[][] cells;

	public ChipMap(int columns, int rows) {
		float length = Chip.getLength();
		this.cells = new Rectangle[columns][rows];

		for(int col = 0; col < columns; ++col) {
			for(int row = 0; row < rows; ++row) {
				float x = col > 0?this.cells[col - 1][0].getX() + this.cells[col - 1][0].getWidth():0.0F;
				float y = row > 0?this.cells[0][row - 1].getY() + this.cells[0][row - 1].getHeight():0.0F;
				this.cells[col][row] = new Rectangle(x, y, length, length);
			}
		}
	}

	public Rectangle[][] getCells() {
		return cells;
	}
}
