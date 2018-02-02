package hu.tokin.game.dontonext.Settings;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyScreen;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by zoltan on 2018.02.02..
 */

public class SettingsScreen extends MyScreen {
    private SettingsStage settingsStage;
    public SettingsScreen(MyGdxGame game) {
        super(game);
        settingsStage = new SettingsStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        settingsStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(settingsStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        settingsStage.act(delta);
        settingsStage.draw();
    }
}
