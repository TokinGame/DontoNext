package hu.tokin.game.dontonext.GameElements.Bodies;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import hu.tokin.game.dontonext.Game.GameScreen;
import hu.tokin.game.dontonext.GameOver.GameOverScreen;
import hu.tokin.game.dontonext.Globals.Assets;
import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.MyBaseClasses.Box2dWorld.WorldActorGroup;
import hu.tokin.game.dontonext.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.ShapeType;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by davim on 2/2/2018.
 */

public class Hole extends WorldActorGroup {
    boolean isFinish;
    MyGdxGame game;
    public Hole(MyGdxGame game, World world, WorldBodyEditorLoader loader, float x, float y, boolean finish) {
        super(world, loader, "golyo", BodyDef.BodyType.StaticBody, 0, 0, 0, true);
        this.game = game;
        isFinish = finish;
        setSize(1, 1);
        setPosition((float)x/80f, (float)y/80f);
        if(isFinish){
            addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.CIRCLE)){
                @Override
                public void init() {
                    super.init();
                    setSize(1, 1);
                }
            });
        }
        addToWorld();
    }

    @Override
    public void contact(WorldActorGroup another) {
        super.contact(another);
        if(another instanceof PoolBall){
            if(isFinish) {
                System.out.println("Good hole");
                Globals.level++;
                Globals.unlocked[Globals.level] = true;
                game.setScreen(new GameScreen(game));
            }
            else {
                System.out.println("Bad hole");
                game.setScreen(new GameOverScreen(game));
            }
        }
    }
}
