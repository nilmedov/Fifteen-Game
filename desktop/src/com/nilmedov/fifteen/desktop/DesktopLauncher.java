package com.nilmedov.fifteen.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nilmedov.fifteen.FifteenGame;
import com.nilmedov.fifteen.screens.GameScreen;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GameScreen.SCREEN_WIDTH;
		config.height = GameScreen.SCREEN_HEIGHT;
		new LwjglApplication(new FifteenGame(), config);
	}
}
