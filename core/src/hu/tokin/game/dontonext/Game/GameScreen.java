package hu.tokin.game.dontonext.Game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyScreen;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by M on 1/11/2018.
 */

public class GameScreen extends MyScreen {

    private GameStage gameStage;

    public GameScreen(MyGdxGame game) {
        super(game);
        gameStage = new GameStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT, new OrthographicCamera(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT)),spriteBatch, game);
        gameStage.addBackEventStackListener();
    }


    @Override
    public void render(float delta) {
        super.render(delta);
        gameStage.act(delta);
        gameStage.draw();
    }

    @Override
    public void init() {

    }


    @Override
    public void dispose() {
        super.dispose();
        gameStage.dispose();
    }
}
