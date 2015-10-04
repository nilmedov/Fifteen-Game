package com.nilmedov.fifteen.controllers;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.nilmedov.fifteen.entities.Chip;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nazar on 04.10.2015.
 */
public class GameController {
	private List<Chip> chips;

	public GameController() {
		chips = new ArrayList<Chip>();
		chips.add(new Chip(1, 0, 0));
		chips.add(new Chip(2, 120,0));
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

	public Chip getChipInPostion(float x, float y) {
		for (Chip chip : chips) {
			if (chip.getBoundingRectangle().contains(x, y)) {
				return chip;
			}
		}
		return null;
	}
}
