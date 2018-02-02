package hu.tokin.game.dontonext.Game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokin.game.dontonext.GameElements.UI.BlockSelector;
import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyStage;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokin.game.dontonext.MyBaseClasses.UI.MyLabel;
import hu.tokin.game.dontonext.MyBaseClasses.UI.MyTextButton;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by davim on 2018. 01. 11..
 */

public class ControlStage extends MyStage {
    private GameStage gameStage;

    public ControlStage(Viewport viewport, Batch batch, MyGdxGame game, GameStage gameStage) {
        super(viewport, batch, game);
        this.gameStage = gameStage;
        /*for(StackTraceElement s: Thread.currentThread().getStackTrace()){
            System.out.println(s);
        }*/
        addActor(new BlockSelector(gameStage));
    }

    @Override
    public void init() {

    }


    @Override
    public void act(float delta) {
        super.act(delta);

    }


}
