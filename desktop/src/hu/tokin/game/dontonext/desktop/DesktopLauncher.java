package hu.tokin.game.dontonext.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = Globals.WORLD_WIDTH;
		config.height = Globals.WORLD_HEIGHT;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
