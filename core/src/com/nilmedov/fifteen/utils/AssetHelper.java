package com.nilmedov.fifteen.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetErrorListener;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by Nazar on 04.10.2015.
 */
public class AssetHelper implements Disposable, AssetErrorListener {
	public static final String TAG = AssetHelper.class.getSimpleName();
	public static final String
			CLIP_TEXTURE = "textures/clip.png",
			FONT = "fonts/impact-40.fnt";

	private AssetManager assetManager;
	private Texture clipTexture;
	private BitmapFont font;

	private static AssetHelper instance;

	private AssetHelper() {
		assetManager = new AssetManager();
		assetManager.setErrorListener(this);
		assetManager.load(CLIP_TEXTURE, Texture.class);
		assetManager.load(FONT, BitmapFont.class);
		assetManager.finishLoading();

		clipTexture = assetManager.get(CLIP_TEXTURE, Texture.class);
		font = assetManager.get(FONT, BitmapFont.class);
	}

	public static AssetHelper getInstance() {
		if (instance == null) {
			instance = new AssetHelper();
		}
		return instance;
	}

	public BitmapFont getFont() {
		return font;
	}

	public Texture getClipTexture() {
		return clipTexture;
	}

	@Override
	public void error(AssetDescriptor asset, Throwable throwable) {
		Gdx.app.error(TAG, "Couldn't load asset '" + asset.fileName + "'", throwable);
	}

	@Override
	public void dispose() {
		assetManager.dispose();
	}
}
