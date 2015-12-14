package com.nilmedov.fifteen.entities;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Nazar on 10.10.2015.
 */
public class ChipMap {
	private Cell[][] cells;

	public ChipMap(List<Chip> chips, int columns, int rows) {
		float length = Chip.getLength();
		cells = new Cell[columns][rows];
		Iterator<Chip> iterator = chips.iterator();
		for (int col = 0; col < columns; col++) {
			for (int row = 0; row < rows; row++) {
				float x = col > 0 ? this.cells[col - 1][0].getX() + this.cells[col - 1][0].getWidth() : 0;
				float y = row > 0 ? this.cells[0][row - 1].getY() + this.cells[0][row - 1].getHeight() : 0;

				Cell cell = new Cell(x, y, length, length, col, row, iterator.hasNext() ? iterator.next() : null);
				if (cell.getChip() != null) {
					System.out.println(cell.toString());
				}
				cells[col][row] = cell;
			}
		}
	}

	public Cell[][] getCells() {
		return cells;
	}
}
