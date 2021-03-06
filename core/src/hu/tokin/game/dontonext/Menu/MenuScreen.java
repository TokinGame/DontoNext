package hu.tokin.game.dontonext.Menu;

import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyScreen;
import hu.tokin.game.dontonext.MyGdxGame;


/**
 * Created by M on 11/9/2017.
 */

public class MenuScreen extends MyScreen {
    private MenuStage menuStage;
    public MenuScreen(MyGdxGame game) {
        super(game);
        menuStage = new MenuStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        menuStage.addBackEventStackListener();

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        menuStage.act(delta);
        menuStage.draw();
    }
}
