package com.nilmedov.fifteen.entities;

import com.badlogic.gdx.math.Rectangle;

/**
 * Created by Nazar on 08.11.2015.
 */
public class Cell extends Rectangle {
	private int column, row;
	private Chip chip;
	private boolean isEmpty;

	public Cell(float x, float y, float width, float height, int column, int row) {
		super(x, y, width, height);
		this.column = column;
		this.row = row;
		isEmpty = true;
	}

	public Cell(float x, float y, float width, float height, int column, int row, Chip chip) {
		super(x, y, width, height);
		this.column = column;
		this.row = row;
		this.chip = chip;
		if (chip != null) {
			this.chip.setPosition(x, y);
			isEmpty = false;
		}
	}

	@Override
	public String toString() {
		return "Cell{" + "\n" +
				"width=" + width + "\n" +
				"height=" + height + "\n" +
				"column=" + column + "\n" +
				"row=" + row + "\n" +
				"\n" + chip.toString();
	}

	public int getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	public Chip getChip() {
		return chip;
	}

	public void setChip(Chip chip) {
		this.chip = chip;
		if (chip == null) {
			isEmpty = true;
		} else {
			this.chip.setPosition(x, y);
		}
	}

	public void removeChip() {
		chip = null;
	}

	public boolean isEmpty() {
		return isEmpty;
	}
}
