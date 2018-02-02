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
        super(world, ShapeType.Circle, BodyDef.BodyType.DynamicBody, 0.1f, 0.2f, 25, false);
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BADLOGIC_TEXTURE)){
            @Override
            public void init() {
                super.init();
                setSize(50, 50);
            }
        });
        setPosition(x, y);
        setSize(50, 50);
        addToWorld();
    }
}
