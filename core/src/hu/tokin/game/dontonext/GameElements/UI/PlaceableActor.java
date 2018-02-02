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

    private float angle, radAngle;

    public boolean isPressed() {
        return pressed;
    }

    public PlaceableActor(Type type, ControlStage controlStage) {
        super(Assets.manager.get(type == Type.PLANK ? Assets.CUE_2 : Assets.BADLOGIC_TEXTURE));
        this.type = type;
        this.controlStage = controlStage;
        this.setSize(type == Type.PLANK ? 300 : 150, type == Type.PLANK ? 20 : 150);
        addListener(new ClickListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                PlaceableActor.this.controlStage.removeAllRotate();
                pressed = true;
                return true;
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                pressed = false;
                //PlaceableActor.this.controlStage.addActor(new RotateButton(getX()+getWidth()+ 10, getY()+getWidth() + 10, PlaceableActor.this));
                super.touchUp(event, x, y, pointer, button);
            }
        });

        this.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                onDrag(x,y);
                pressed = true;
                return true;
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                //System.out.println("AngleActor: " + x + " ------ " + y);
                onDrag(x,y);
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
                pressed = false;
            }
        });

    }


    private void onDrag(float x, float y){
        if(x < 0.0f) x = 0.0f;
        if(y < 0.0f) y = 0.0f;
        radAngle = (float) Math.atan(y/x);
        this.setRotation(radAngle);
    }

    public Type getType() {
        return type;
    }


    public enum Type{
        AIR,
        PLANK
    }


}
