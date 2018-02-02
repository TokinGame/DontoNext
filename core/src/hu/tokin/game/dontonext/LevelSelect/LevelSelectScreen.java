package hu.tokin.game.dontonext.LevelSelect;

import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.Menu.MenuStage;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyScreen;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by davim on 2018. 02. 02..
 */

public class LevelSelectScreen extends MyScreen {
    LevelSelectStage levelSelectStage;
    public LevelSelectScreen(MyGdxGame game) {
        super(game);
        levelSelectStage = new LevelSelectStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        levelSelectStage.addBackEventStackListener();

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        levelSelectStage.act(delta);
        levelSelectStage.draw();
    }
}
