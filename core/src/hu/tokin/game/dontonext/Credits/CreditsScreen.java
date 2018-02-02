package hu.tokin.game.dontonext.Credits;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyScreen;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by zoltan on 2018.02.02..
 */

public class CreditsScreen extends MyScreen {
    private CreditsStage creditsStage;
    public CreditsScreen(MyGdxGame game) {
        super(game);
        creditsStage = new CreditsStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        creditsStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(creditsStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        creditsStage.act(delta);
        creditsStage.draw();
    }
}