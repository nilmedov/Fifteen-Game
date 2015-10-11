package com.nilmedov.fifteen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nilmedov.fifteen.controllers.ChipController;
import com.nilmedov.fifteen.entities.Chip;
import com.nilmedov.fifteen.entities.Collision;

/**
 * Created by Nazar on 04.10.2015.
 */
public class GameScreen implements Screen {
	private static final String TAG = GameScreen.class.getSimpleName();
	public static final int SCREEN_WIDTH = 480;
	public static final int SCREEN_HEIGHT = 800;
	//	private OrthographicCamera camera;
//	private FitViewport viewport;
	private SpriteBatch batch;
	private float prevX, prevY;
	private float diffX, diffY;
	private boolean isObjectTouched;
	private ChipController chipController;
	private Chip holdedChip;

	public GameScreen() {
//		camera = new OrthographicCamera();
//		camera.position.set(SCREEN_WIDTH / 2, SCREEN_HEIGHT / 2, 0);
//		viewport = new FitViewport(SCREEN_WIDTH, SCREEN_HEIGHT, camera);
	}

	@Override
	public void show() {
		batch = new SpriteBatch();
		chipController = new ChipController();
		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				int convertedY = SCREEN_HEIGHT - screenY;
				holdedChip = chipController.getChipInPostion(screenX, convertedY);
				if (holdedChip != null) {
					isObjectTouched = true;
					prevX = holdedChip.getX();
					prevY = holdedChip.getY();
					diffX = screenX - holdedChip.getX();
					diffY = convertedY - holdedChip.getY();
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

					chipController.getChipMapBoundsCollision(holdedChip);

					Collision collision = chipController.getCollision(holdedChip);
					if (prevX > screenX) {
						if (!collision.isLeft()) {
							holdedChip.setX(screenX - diffX);
						}
					} else if (prevX < screenX && !collision.isRight()) {
						holdedChip.setX(screenX - diffX);
					}

					if (prevY > convertedY) {
						if (!collision.isBottom()) {
							holdedChip.setY(convertedY - diffY);
						}
					} else if (prevY < convertedY && !collision.isBottom()) {
						holdedChip.setY(convertedY - diffY);
					}

					prevX = screenX;
					prevY = convertedY;
				}
//				System.out.println("touchDragged: " + "x: " + screenX + " y: " + convertedY);
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
		chipController.draw(batch);
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
