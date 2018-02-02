package hu.tokin.game.dontonext.Credits;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyScreen;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by zoltan on 2018.02.02..
 */

public class CreditsScreen2 extends MyScreen {
    private CreditsStage2 creditsStage2;
    public CreditsScreen2(MyGdxGame game) {
        super(game);
        creditsStage2 = new CreditsStage2(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        creditsStage2.addBackEventStackListener();
        Gdx.input.setInputProcessor(creditsStage2);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        creditsStage2.act(delta);
        creditsStage2.draw();
    }
}
