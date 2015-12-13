package com.nilmedov.fifteen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.nilmedov.fifteen.controllers.ChipController;
import com.nilmedov.fifteen.entities.Cell;
import com.nilmedov.fifteen.entities.Chip;

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
	private ChipController chipController;
	private Cell retainedCell;

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
				screenY = SCREEN_HEIGHT - screenY;
				Cell cell = chipController.getCellInPosition(screenX, screenY);
				if (cell != null) {
					Chip chip = cell.getChip();
					if (chip != null) {
						retainedCell = cell;
					} else if (retainedCell != null && isNeighboringCell(cell, retainedCell)) {
						cell.setChip(retainedCell.getChip());
						retainedCell.setChip(chip);
						System.out.println("Chips swapped");
					}
				}
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

	private boolean isNeighboringCell(Cell cell1, Cell cell2) {
		if (cell1.getColumn() != 0 && cell1.getColumn() - 1 == cell2.getColumn() && cell1.getRow() == cell2.getRow()) {
			return true;
		}

		if (cell1.getColumn() != 3 && cell1.getColumn() + 1 == cell2.getColumn() && cell1.getRow() == cell2.getRow()) {
			return true;
		}

		if (cell1.getRow() != 0 && cell1.getRow() - 1 == cell2.getRow() && cell1.getColumn() == cell2.getColumn()) {
			return true;
		}

		return cell1.getRow() != 3 && cell1.getRow() + 1 == cell2.getRow() && cell1.getColumn() == cell2.getColumn();
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
