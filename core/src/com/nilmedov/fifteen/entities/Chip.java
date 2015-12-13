package com.nilmedov.fifteen.entities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.nilmedov.fifteen.utils.AssetHelper;

/**
 * Created by Nazar on 04.10.2015.
 */
public class Chip extends Sprite {
	private int number;
	public Chip(int number) {
		super(AssetHelper.getInstance().getClipTexture(number));
		this.number = number;
		setPosition(0, 0);
	}

	public Chip(int number, float x, float y) {
		super(AssetHelper.getInstance().getClipTexture(number));
		this.number = number;
		setPosition(x, y);
	}

	@Override
	public String toString() {
		return "Chip{" + "\n" +
				"number=" + number + "\n" +
				"x=" + getX() + "\n" +
				"y=" + getY() + "\n" +
				'}';
	}

	public static float getLength() {
		return AssetHelper.getInstance().getClipTexture(1).getHeight();
	}

	@Override
	public void draw(Batch batch) {
		super.draw(batch);
	}
}
