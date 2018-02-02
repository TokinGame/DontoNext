package hu.tokin.game.dontonext.GameElements.Bodies;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokin.game.dontonext.MyBaseClasses.Box2dWorld.WorldActorGroup;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.ShapeType;

/**
 * Created by davim on 2/2/2018.
 */

public class Hole extends WorldActorGroup {
    public Hole(World world, float x, float y) {
        super(world, ShapeType.Circle, BodyDef.BodyType.StaticBody, 0, 0, 0, true);
        setSize(50f/80f, 50f/80f);
        setPosition((float)x/80f, (float)y/80f);
    }
}
