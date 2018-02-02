package hu.tokin.game.dontonext.GameElements.Bodies;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokin.game.dontonext.Game.GameStage;
import hu.tokin.game.dontonext.MyBaseClasses.Box2dWorld.WorldActorGroup;
import hu.tokin.game.dontonext.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;

/**
 * Created by davim on 2018. 02. 02..
 */

public class Fan extends WorldActorGroup {
    GameStage gameStage;
    public Fan(GameStage gameStage, World world, WorldBodyEditorLoader loader, float x, float y, float rotation) {
        super(world, loader, "fan", BodyDef.BodyType.StaticBody, 0.1f, 0.2f, 5, false);
        this.gameStage = gameStage;
        addActor(new OneSpriteAnimatedActor("GameTextures/ventilator/venti.txt"){
            @Override
            public void init() {
                super.init();
                setSize((float)150/80, (float)150/80);
            }
        });
        setSize((float)150/80, (float)150/80);
        setPosition((float)x/80, (float)y/80);
        setRotation((float)Math.toRadians(rotation));
        addToWorld();

        gameStage.addActor(new Air(world, loader, getX(), getY(), rotation));
    }
}
