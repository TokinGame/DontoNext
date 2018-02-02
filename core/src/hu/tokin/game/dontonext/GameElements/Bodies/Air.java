package hu.tokin.game.dontonext.GameElements.Bodies;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokin.game.dontonext.MyBaseClasses.Box2dWorld.WorldActorGroup;
import hu.tokin.game.dontonext.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.ShapeType;

/**
 * Created by davim on 2018. 02. 02..
 */

public class Air extends WorldActorGroup {
    OneSpriteAnimatedActor actor;

    public Air(World world, float x, float y, final float rotation){
        super(world, ShapeType.Rectangle, BodyDef.BodyType.StaticBody, 0, 0, 0, true);
        setSize((float)150/80f, (float)150/80f);
        setPosition((float)x/80f, (float)y/80f);
        setOrigin(0,0);
        addActor(actor = new OneSpriteAnimatedActor("GameTextures/szel/szel.txt"){
            @Override
            public void init() {
                super.init();//
                setSize(400f/80f, 150f/80f);
                setFps(10);
                setPosition(0,0);
            }
        });
        addActor(new OneSpriteAnimatedActor("GameTextures/ventilator/venti.txt"){
            @Override
            public void init() {
                super.init();
                setSize((float)150/80f, (float)150/80f);
                setFps(20);
            }
        });
        actor.setOrigin(0,0);
        setRotation((float)Math.toRadians(rotation));


        addToWorld();
        System.out.println("Air " + getX() + " " + getY());
        System.out.println("Air act " + actor.getX() + " " + actor.getY());
    }

}
