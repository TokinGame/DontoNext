package hu.tokin.game.dontonext.GameElements.Bodies;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
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

    OneSpriteAnimatedActor actor;

    public PoolBall(World world, WorldBodyEditorLoader loader, final float x, final float y) {
        super(world, loader, "golyo", BodyDef.BodyType.DynamicBody, 0.1f, 0.2f, 25, false);
        addActor(actor = new OneSpriteAnimatedActor("GameTextures/golyo/golyo.txt"){
            @Override
            public void init() {
                super.init();
                setSize((float)40/80, (float)40/80);
                stop();
            }
        });

        setPosition((float)x/80f, (float)y/80f);
        setSize((float)40/80, (float)40/80);
        addToWorld();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(getBody().getLinearVelocity().y > 0.1f){
            actor.FrameMinus();
            System.out.println("fel");
        }else if(getBody().getLinearVelocity().y < -0.1f){
            actor.FramePlus();
            System.out.println("le");
        }
    }

    @Override
    public void contact(WorldActorGroup another) {
        super.contact(another);
        if(another instanceof Air){
            float airRotation = another.getRotation();
            System.out.println("huehuehuehue rootttttoot "+ airRotation);
            Vector2 vector2 = new Vector2(1000, 0);
            Vector2 rotateVector2 = vector2.setAngleRad(airRotation);
            this.getBody().applyForceToCenter(rotateVector2, false);
            this.getBody().setLinearVelocity(this.getBody().getLinearVelocity().x, this.getBody().getLinearVelocity().y);
        }
    }
}
