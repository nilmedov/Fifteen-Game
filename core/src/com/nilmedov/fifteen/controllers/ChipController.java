package com.nilmedov.fifteen.controllers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.nilmedov.fifteen.entities.Chip;
import com.nilmedov.fifteen.entities.ChipMap;
import com.nilmedov.fifteen.entities.Collision;

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
		chips.add(new Chip(1, 0, 0));
		chips.add(new Chip(2, 120, 0));

		chipMap = new ChipMap(chips, 4, 4);
		chipMap.setChipAtCell(chips.get(0), 0, 0);
		chipMap.setChipAtCell(chips.get(1), 3, 3);

//		for(int i = 0; i < 4; ++i) {
//			for (int j = 0; j < 4; ++j) {
//				if (i != 0 && j != 0) {
//					float var10000;
//					if (i > 0) {
//						var10000 = this.chips[i - 1][0].getX() + this.chips[i - 1][0].getBoundingRectangle().getWidth();
//					} else {
//						var10000 = 0.0F;
//					}
//
//					if (j > 0) {
//						var10000 = this.chips[0][j - 1].getY() + this.chips[0][j - 1].getBoundingRectangle().getHeight();
//					} else {
//						var10000 = 0.0F;
//					}
//				}
//			}
//		}
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

	public Collision getCollision(Chip chip) {
		Collision collision = new Collision();

		for (Chip currentChip : chips) {
			if (!chip.equals(currentChip)) {
				Rectangle intersection = new Rectangle();
				Intersector.intersectRectangles(chip.getBoundingRectangle(), currentChip.getBoundingRectangle(), intersection);
				if (intersection.getHeight() > 0 && intersection.getWidth() > 0) {
					if (intersection.x > chip.getBoundingRectangle().x) {
						Gdx.app.log(TAG, "collision: right");
						collision.setRight(true);
					}

					if (intersection.y > chip.getBoundingRectangle().y) {
						Gdx.app.log(TAG, "collision: top");
						collision.setTop(true);
					}

					if (intersection.x + intersection.width < chip.getBoundingRectangle().x + chip.getBoundingRectangle().width) {
						Gdx.app.log(TAG, "collision: left");
						collision.setLeft(true);
					}

					if (intersection.y + intersection.height < chip.getBoundingRectangle().y + chip.getBoundingRectangle().height) {
						Gdx.app.log(TAG, "collision: bottom");
						collision.setBottom(true);
					}
				}
			}
		}
		return collision;
	}

	public Collision getChipMapBoundsCollision(Chip chip) {
		Collision collision = new Collision();

		Rectangle bound = chipMap.getBound();
		Rectangle intersection = new Rectangle();
		Intersector.intersectRectangles(chipMap.getBound(), chip.getBoundingRectangle(), intersection);

//		Gdx.app.log(TAG, "intersection: " + intersection.toString());

		if (intersection.x + chip.getWidth() > bound.getWidth()) {
			Gdx.app.log(TAG, "Bound collision: right");
			collision.setRight(true);
		}

		if (intersection.y + chip.getHeight() > bound.getHeight()) {
			Gdx.app.log(TAG, "Bound collision: top");
			collision.setTop(true);
		}

		if (intersection.x == 0) {
			Gdx.app.log(TAG, "Bound collision: left");
			collision.setLeft(true);
		}

		if (intersection.y == 0) {
			Gdx.app.log(TAG, "Bound collision: bottom");
			collision.setBottom(true);
		}
		return collision;
	}
}
