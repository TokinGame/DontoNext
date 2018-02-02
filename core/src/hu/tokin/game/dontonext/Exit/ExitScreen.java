package hu.tokin.game.dontonext.Exit;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyScreen;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by zoltan on 2018.02.02..
 */

public class ExitScreen extends MyScreen {
    private ExitStage exitStage;
    public ExitScreen(MyGdxGame game) {
        super(game);
        exitStage = new ExitStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        exitStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(exitStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        exitStage.act(delta);
        exitStage.draw();
    }
}
