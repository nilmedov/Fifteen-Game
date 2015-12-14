package com.nilmedov.fifteen.controllers;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.nilmedov.fifteen.entities.Cell;
import com.nilmedov.fifteen.entities.Chip;
import com.nilmedov.fifteen.entities.ChipMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Nazar on 04.10.2015.
 */
public class ChipController {
	private static final String TAG = ChipController.class.getSimpleName();
	private List<Chip> chips;
	private ChipMap chipMap;

	public ChipController() {
		chips = new ArrayList<Chip>();
		for (int i = 1; i < 16; i++) {
			chips.add(new Chip(i));
		}

		Collections.shuffle(chips);

//		chips.add(new Chip(13));
//		chips.add(new Chip(9));
//		chips.add(new Chip(5));
//		chips.add(new Chip(1));
//		chips.add(new Chip(15));
//		chips.add(new Chip(10));
//		chips.add(new Chip(6));
//		chips.add(new Chip(2));
//		chips.add(new Chip(14));
//		chips.add(new Chip(11));
//		chips.add(new Chip(7));
//		chips.add(new Chip(3));
//		chips.add(new Chip(12));
//		chips.add(new Chip(8));
//		chips.add(new Chip(4));

		chipMap = new ChipMap(chips, 4, 4);
	}

	public void draw(Batch batch) {
		for (Chip chip : chips) {
			chip.draw(batch);
		}
	}

	public boolean isRightSequence() {
		for (Cell[] cellRow : chipMap.getCells()) {
			for (Cell cell : cellRow) {
				if (cell.getChip() != null) {
					switch (cell.getChip().getNumber()) {
						case 1:
							if (cell.getColumn() != 0 || cell.getRow() != 3) {
								return false;
							}
							break;
						case 2:
							if (cell.getColumn() != 1 || cell.getRow() != 3) {
								return false;
							}
							break;
						case 3:
							if (cell.getColumn() != 2 || cell.getRow() != 3) {
								return false;
							}
							break;
						case 4:
							if (cell.getColumn() != 3 || cell.getRow() != 3) {
								return false;
							}
							break;
						case 5:
							if (cell.getColumn() != 0 || cell.getRow() != 2) {
								return false;
							}
							break;
						case 6:
							if (cell.getColumn() != 1 || cell.getRow() != 2) {
								return false;
							}
							break;
						case 7:
							if (cell.getColumn() != 2 || cell.getRow() != 2) {
								return false;
							}
							break;
						case 8:
							if (cell.getColumn() != 3 || cell.getRow() != 2) {
								return false;
							}
							break;
						case 9:
							if (cell.getColumn() != 0 || cell.getRow() != 1) {
								return false;
							}
							break;
						case 10:
							if (cell.getColumn() != 1 || cell.getRow() != 1) {
								return false;
							}
							break;
						case 11:
							if (cell.getColumn() != 2 || cell.getRow() != 1) {
								return false;
							}
							break;
						case 12:
							if (cell.getColumn() != 3 || cell.getRow() != 1) {
								return false;
							}
							break;
						case 13:
							if (cell.getColumn() != 0 || cell.getRow() != 0) {
								return false;
							}
							break;
						case 14:
							if ((cell.getColumn() != 1 || cell.getRow() != 0) && (cell.getColumn() != 2 || cell.getRow() != 0)) {
								return false;
							}
							break;
						case 15:
							if ((cell.getColumn() != 1 || cell.getRow() != 0) && (cell.getColumn() != 2 || cell.getRow() != 0)) {
								return false;
							}
							break;
					}
				}
			}
		}
		return true;
	}

	public Cell getCellInPosition(float x, float y) {
		for (Cell[] cellRow : chipMap.getCells()) {
			for (Cell cell : cellRow) {
				if (cell.contains(x, y)) {
					return cell;
				}
			}
		}
		return null;
	}
}
