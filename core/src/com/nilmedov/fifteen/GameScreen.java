package com.nilmedov.fifteen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by Nazar on 04.10.2015.
 */
public class GameScreen implements Screen {
	public static final int SCREEN_WIDTH = 480;
	public static final int SCREEN_HEIGHT = 800;
//	private OrthographicCamera camera;
//	private FitViewport viewport;
	private SpriteBatch batch;
	private Sprite img;
	private float diffX, diffY;
	private boolean isObjectTouched;

	public GameScreen() {
//		camera = new OrthographicCamera();
//		camera.position.set(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, 0);
//		viewport = new FitViewport(SCREEN_WIDTH, SCREEN_HEIGHT, camera);
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		img = new Sprite(new Texture("badlogic.jpg"));
		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				int convertedY = SCREEN_HEIGHT - screenY;

				if (img.getBoundingRectangle().contains(screenX, convertedY)) {
					isObjectTouched = true;
					diffX = screenX - img.getX();
					diffY = convertedY - img.getY();
				}
				System.out.println("touchDown: " + "x: " + screenX + " y: " + convertedY);
				return true;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer, int button) {
				isObjectTouched = false;
				return true;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				int convertedY = SCREEN_HEIGHT - screenY;

				if (isObjectTouched) {
					img.setPosition(screenX - diffX, convertedY - diffY);
				}
				System.out.println("touchDragged: " + "x: " + screenX + " y: " + convertedY);
				return true;
			}
		});
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		camera.update();
//		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		img.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
//		viewport.update(width, height);
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
