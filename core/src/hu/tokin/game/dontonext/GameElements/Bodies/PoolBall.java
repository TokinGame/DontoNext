package hu.tokin.game.dontonext.GameElements.Bodies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokin.game.dontonext.Globals.Assets;
import hu.tokin.game.dontonext.MyBaseClasses.Box2dWorld.WorldActorGroup;
import hu.tokin.game.dontonext.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.ShapeType;

/**
 * Created by M on 2/2/2018.
 */

public class PoolBall extends WorldActorGroup {

    public PoolBall(World world, WorldBodyEditorLoader loader, final float x, final float y) {
        super(world, loader, "golyo", BodyDef.BodyType.DynamicBody, 0.1f, 0.2f, 25, false);
        addActor(new OneSpriteAnimatedActor("GameTextures/golyo/golyo.txt"){
            @Override
            public void init() {
                super.init();
                setSize((float)40/80, (float)40/80);
                setFps(20);
            }
        });
        setPosition((float)x/80f, (float)y/80f);
        setSize((float)40/80, (float)40/80);
        addToWorld();
    }
}
