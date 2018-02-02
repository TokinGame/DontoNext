package hu.tokin.game.dontonext.Win;

import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokin.game.dontonext.GameOver.GameOverStage;
import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyScreen;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by zoltan on 2018.02.02..
 */

public class WinScreen extends MyScreen {
    private WinStage winStage;
    public WinScreen(MyGdxGame game) {
        super(game);
        winStage = new WinStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        winStage.addBackEventStackListener();

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        winStage.act(delta);
        winStage.draw();
    }
}
