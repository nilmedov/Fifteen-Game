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
	private BitmapFont font;

	public Chip(int number, float x, float y) {
		super(AssetHelper.getInstance().getClipTexture());
		setPosition(x, y);
		this.number = number;
		font = AssetHelper.getInstance().getFont();
	}

	public static float getLength() {
		return AssetHelper.getInstance().getClipTexture().getHeight();
	}

	@Override
	public void draw(Batch batch) {
		font.draw(batch, String.valueOf(number), getX(), getY() + getHeight() + 30);
		super.draw(batch);
	}
}
