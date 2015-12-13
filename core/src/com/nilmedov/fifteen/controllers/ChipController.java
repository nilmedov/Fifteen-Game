package com.nilmedov.fifteen.controllers;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.nilmedov.fifteen.entities.Cell;
import com.nilmedov.fifteen.entities.Chip;
import com.nilmedov.fifteen.entities.ChipMap;

import java.util.ArrayList;
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

		chipMap = new ChipMap(chips, 4, 4);
	}

	public void update(float delta) {

	}

	public void draw(Batch batch) {
		for (Chip chip : chips) {
			chip.draw(batch);
		}
	}

	public List<Chip> getChips() {
		return chips;
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
