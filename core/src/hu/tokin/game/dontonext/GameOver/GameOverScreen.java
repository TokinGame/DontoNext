package hu.tokin.game.dontonext.GameOver;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.Menu.MenuStage;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyScreen;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by zoltan on 2018.02.02..
 */

public class GameOverScreen extends MyScreen {
    private GameOverStage gameOverStage;
    public GameOverScreen(MyGdxGame game) {
        super(game);
        gameOverStage = new GameOverStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        gameOverStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(gameOverStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        gameOverStage.act(delta);
        gameOverStage.draw();
    }
}
