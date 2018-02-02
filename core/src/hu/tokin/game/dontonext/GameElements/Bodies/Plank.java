package hu.tokin.game.dontonext.GameElements.Bodies;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokin.game.dontonext.Globals.Assets;
import hu.tokin.game.dontonext.MyBaseClasses.Box2dWorld.WorldActorGroup;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.ShapeType;

/**
 * Created by davim on 2018. 02. 02..
 */

public class Plank extends WorldActorGroup {
    public Plank(World world, final float x,final float y,final float angle) {
        super(world, ShapeType.Rectangle, BodyDef.BodyType.StaticBody, 0, 0.2f, 5, false);
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BADLOGIC_TEXTURE)){
            @Override
            public void init() {
                super.init();
                setSize(300/80f, 30/80f);
            }
        });
        setSize(300/80f, 30/80f);
        setPosition(x/80f, y/80f);
        setRotation(angle);
    }
}
