package hu.tokin.game.dontonext.GameElements.Bodies;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokin.game.dontonext.Globals.Assets;
import hu.tokin.game.dontonext.MyBaseClasses.Box2dWorld.WorldActorGroup;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.ShapeType;

/**
 * Created by M on 2/2/2018.
 */

public class PoolBall extends WorldActorGroup {
    public PoolBall(World world, final float x, final float y) {
        super(world, ShapeType.Circle, BodyDef.BodyType.KinematicBody, 0, 0.2f, 5, false);
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BADLOGIC_TEXTURE)){
            @Override
            public void init() {
                super.init();
                setSize(50/80f, 50/80f);
            }
        });
        setPosition(x/80f, y/80f);
        setSize(50/80f, 50/80f);
    }
}
