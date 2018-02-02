package hu.tokin.game.dontonext.GameElements.Bodies;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.tokin.game.dontonext.Globals.Assets;
import hu.tokin.game.dontonext.MyBaseClasses.Box2dWorld.WorldActorGroup;
import hu.tokin.game.dontonext.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.ShapeType;

/**
 * Created by davim on 2018. 02. 02..
 */

public class Plank extends WorldActorGroup {

    private boolean pressed = false;

    public Plank(World world, WorldBodyEditorLoader loader, final float x, final float y, final float angle) {
        super(world, loader, "masik.png", BodyDef.BodyType.StaticBody, 0, 0.2f, 5, false);
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.CUE_2)){
            @Override
            public void init() {
                super.init();
                setSize((float)300/80f, (float)20/80f);
            }
        });
        setSize((float)300/80f, (float)20/80f);
        setPosition(x/80f, y/80f);
        setRotation((float)Math.toRadians(angle));
        addToWorld();
    }
}
