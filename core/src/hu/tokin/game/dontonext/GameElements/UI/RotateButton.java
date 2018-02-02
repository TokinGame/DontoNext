package hu.tokin.game.dontonext.GameElements.UI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;


import hu.tokin.game.dontonext.Globals.Assets;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by M on 2/2/2018.
 */

public class RotateButton extends OneSpriteStaticActor{
    private boolean pressed;
    private float angle, radAngle;

    private  PlaceableActor toRotate;

    public RotateButton(float x, float y, PlaceableActor toRotate) {
        super(Assets.manager.get(Assets.BADLOGIC_TEXTURE));
        this.toRotate = toRotate;
        setSize(70,70);
        setPosition(x, y);
        setOrigin(getX()-toRotate.getX(), getY() - toRotate.getY());
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
                remove();
            }
        });
    }

    private void onDrag(float x, float y){
        if(x < 0.0f) x = 0.0f;
        if(y < 0.0f) y = 0.0f;
        radAngle = (float) Math.atan(y/x);
        toRotate.setRotation(radAngle);
        this.setRotation(-radAngle);
    }


}
