package hu.tokin.game.dontonext.Game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokin.game.dontonext.GameElements.UI.BlockSelector;
import hu.tokin.game.dontonext.GameElements.UI.PlaceableActor;
import hu.tokin.game.dontonext.Globals.Assets;
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

    OneSpriteStaticActor actor;

    private boolean pressed;

    private float difX = 0, difY = 0;


    public ControlStage(Viewport viewport, Batch batch, MyGdxGame game, GameStage gameStage) {
        super(viewport, batch, game);
        this.gameStage = gameStage;
        setUpDrag();

        addActor(new BlockSelector());

        addActor(new PlaceableActor(PlaceableActor.Type.PLANK));
        addActor(new PlaceableActor(PlaceableActor.Type.FAN));
    }

    private void setUpDrag(){
        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                for (Actor placable: getActors()) {
                    if(placable instanceof PlaceableActor){
                        if(((PlaceableActor) placable).isPressed()){
                            difX = x - placable.getX();
                            difY = y - placable.getY();
                        }
                    }
                }
                return true;
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                //System.out.println("AngleActor: " + x + " ------ " + y);
                for (Actor placable: getActors()) {
                    if(placable instanceof PlaceableActor){
                        if(((PlaceableActor) placable).isPressed()) {
                            placable.setPosition(x - difX, y - difY);
                        }
                    }
                }
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });
    }

    @Override
    public void init() {
    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }


}
