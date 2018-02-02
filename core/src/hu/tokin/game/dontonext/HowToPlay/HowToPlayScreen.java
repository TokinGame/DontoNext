package hu.tokin.game.dontonext.HowToPlay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyScreen;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by zoltan on 2018.02.02..
 */

public class HowToPlayScreen extends MyScreen {
    private HowToPlayStage howtoplayStage;
    public HowToPlayScreen(MyGdxGame game) {
        super(game);
        howtoplayStage = new HowToPlayStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game);
        howtoplayStage.addBackEventStackListener();
        Gdx.input.setInputProcessor(howtoplayStage);

    }

    @Override
    public void init() {

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        howtoplayStage.act(delta);
        howtoplayStage.draw();
    }
}

