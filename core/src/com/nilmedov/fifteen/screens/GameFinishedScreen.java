package com.nilmedov.fifteen.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nilmedov.fifteen.utils.AssetHelper;

/**
 * Created by Nazar on 13.12.2015.
 */
public class GameFinishedScreen implements Screen {
	private Game game;
	private BitmapFont font;
	private Batch batch;
	private Texture background;

	public GameFinishedScreen(Game game) {
		this.game = game;
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		background = AssetHelper.getInstance().getBackgroundTexture();
		font = AssetHelper.getInstance().getFont();
		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				game.setScreen(new GameScreen(game));
				return true;
			}
		});
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.disableBlending();
		batch.draw(background, 0, 0);
		batch.enableBlending();
		font.draw(batch, "Congratulations, you won!", 30, GameScreen.SCREEN_HEIGHT / 2);
		font.draw(batch, "Tap to retry", GameScreen.SCREEN_WIDTH / 2 - 50, GameScreen.SCREEN_HEIGHT / 2 - 50);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {
		batch.dispose();
	}
}
