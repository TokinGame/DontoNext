package hu.tokin.game.dontonext.GameElements.Bodies;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokin.game.dontonext.MyBaseClasses.Box2dWorld.WorldActorGroup;
import hu.tokin.game.dontonext.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.ShapeType;

/**
 * Created by davim on 2018. 02. 02..
 */

public class Air extends WorldActorGroup {
    public Air(World world, WorldBodyEditorLoader loader, float x, float y, float rotation){
        super(world, loader, "ures", BodyDef.BodyType.StaticBody, 0, 0, 0, true);
        setSize(400f/80f, 150f/80f);
        setPosition(x+150f/80f, y-150f/80f);
        setPosition(x, y);
        setRotation(rotation);
    }

}
