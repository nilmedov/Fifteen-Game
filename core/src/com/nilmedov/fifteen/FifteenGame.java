package com.nilmedov.fifteen;

import com.badlogic.gdx.Game;

public class FifteenGame extends Game {

	@Override
	public void create () {
		setScreen(new com.nilmedov.fifteen.screens.GameScreen(this));
	}
}
