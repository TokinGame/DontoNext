package hu.tokin.game.dontonext.GameElements.UI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.tokin.game.dontonext.Game.ControlStage;
import hu.tokin.game.dontonext.Globals.Assets;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by M on 2/2/2018.
 */

public class PlaceableActor extends OneSpriteStaticActor {

    private boolean pressed;
    private Type type;
    private final ControlStage controlStage;


    public boolean isPressed() {
        return pressed;
    }

    public PlaceableActor(Type type, ControlStage controlStage) {
        super(Assets.manager.get(type == Type.PLANK ? Assets.CUE_2 : Assets.FAN_STATIONARY));
        this.type = type;
        this.controlStage = controlStage;
        this.setSize(type == Type.PLANK ? 300 : 150, type == Type.PLANK ? 20 : 150);
        addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                pressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                pressed = false;
                super.touchUp(event, x, y, pointer, button);
            }
        });
    }


    @Override
    public void act(float delta) {
        super.act(delta);
    }


    public Type getType() {
        return type;
    }


    public enum Type{
        AIR,
        PLANK
    }


}
