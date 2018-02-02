package hu.tokin.game.dontonext.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

import hu.tokin.game.dontonext.Exit.ExitScreen;
import hu.tokin.game.dontonext.GameElements.Bodies.Air;
import hu.tokin.game.dontonext.GameElements.Bodies.Hole;
import hu.tokin.game.dontonext.GameElements.Bodies.Plank;
import hu.tokin.game.dontonext.GameElements.Bodies.PoolBall;
import hu.tokin.game.dontonext.GameElements.UI.PlaceableActor;
import hu.tokin.game.dontonext.Globals.Assets;
import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.Menu.MenuScreen;
import hu.tokin.game.dontonext.MyBaseClasses.Box2dWorld.WorldActorGroup;
import hu.tokin.game.dontonext.MyBaseClasses.Box2dWorld.WorldBodyEditorLoader;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyActor;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyStage;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.ShapeType;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by M on 1/11/2018.
 */

public class GameStage extends MyStage {

    private ControlStage controlStage;

    World world;
    Box2DDebugRenderer box2DDebugRenderer;
    WorldBodyEditorLoader loader;

    ArrayList<WorldActorGroup> rem;

    int rdm(int a, int b){return (int)(Math.random()*(b-a+1)+a);}
    float randomF(float a, float b){return (float) (Math.random()*(b-a+1)+a);}



    PoolBall poolBall;


    public GameStage(Viewport viewport, Batch batch, MyGdxGame game) {
        super(viewport, batch, game);
        controlStage = new ControlStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT, new OrthographicCamera(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT)),new SpriteBatch(), game, this);
        setDebugAll(Globals.DEBUG);
        Gdx.input.setCatchBackKey(true);
        world = new World(new Vector2(0, -10f), false);
        box2DDebugRenderer = new Box2DDebugRenderer();
        loader = new WorldBodyEditorLoader(Gdx.files.internal("fizika.json"));
        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                System.out.println("KONTAKCIÓ");
                ((WorldActorGroup)contact.getFixtureA().getBody().getUserData()).contact((WorldActorGroup)contact.getFixtureB().getBody().getUserData());
                ((WorldActorGroup)contact.getFixtureB().getBody().getUserData()).contact((WorldActorGroup)contact.getFixtureA().getBody().getUserData());
            }

            @Override
            public void endContact(Contact contact) {

            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });



        rem = new ArrayList<WorldActorGroup>();

        InputMultiplexer inputMultiplexer = new InputMultiplexer();
        inputMultiplexer.addProcessor(this);
        inputMultiplexer.addProcessor(controlStage);
        Gdx.input.setInputProcessor(inputMultiplexer);

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND_TABLE)){
            @Override
            public void init() {
                super.init();
                setSize(16, 9);
            }
        });

        addActor(new WorldActorGroup(world, ShapeType.Rectangle, BodyDef.BodyType.StaticBody,  1, 0.2f, 5, false){
            @Override
            public void init() {
                super.init();
                setPosition(15.75f, 4.5f);
                setSize(0.5f, 8);
                addToWorld();
            }
        });
        addActor(new WorldActorGroup(world, ShapeType.Rectangle, BodyDef.BodyType.StaticBody,  1, 0.2f, 5, false){
            @Override
            public void init() {
                super.init();
                setPosition(8, 8.75f);
                setSize(15, 0.5f);
                addToWorld();
            }
        });
        addActor(new WorldActorGroup(world, ShapeType.Rectangle, BodyDef.BodyType.StaticBody,  1, 0.2f, 5, false){
            @Override
            public void init() {
                super.init();
                setPosition(8, 0.25f);
                setSize(15, 0.5f);
                addToWorld();
            }
        });
        addActor(new WorldActorGroup(world, ShapeType.Rectangle, BodyDef.BodyType.StaticBody, 1, 0.2f, 5, false){
            @Override
            public void init() {
                super.init();
                setPosition(0.25f, 4.5f);
                setSize(0.5f, 8);
                addToWorld();
            }
        });


        addActor(new Plank(world, loader, 10, 150, 0));
        addActor(poolBall = new PoolBall(world, loader, 800, 500));

        addActor(new Air(world, 700, 200, 45));

        addBackEventStackListener();


        addHoles(2);
    }


    public void addHoles(int which){
        addActor(new Hole(world, loader, 70, 70, which==0 ? true : false));
        addActor(new Hole(world, loader, 640, 50, which==1 ? true : false));
        addActor(new Hole(world, loader, 1280-70, 70, which==2 ? true : false));
        addActor(new Hole(world, loader, 1280-70, 720-70, which==3 ? true : false));
        addActor(new Hole(world, loader, 640, 720-50, which==4 ? true : false));
        addActor(new Hole(world, loader, 70, 720-70, which==5 ? true : false));
    }


    @Override
    public void init() {
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK && keycode == Input.Keys.ESCAPE){
            game.setScreen(new MenuScreen(game));
        }
        return false;
    }


    @Override
    public void dispose() {
        super.dispose();
    }

    @Override
    public void draw() {
        super.draw();
        controlStage.draw();
    }


    public void buildMap(ArrayList<PlaceableActor> blocks){
        for (PlaceableActor plc: blocks) {
            switch (plc.getType()){
                case AIR: addActor(new Air(world, plc.getX(), plc.getY(), (float) Math.toDegrees(plc.getRotation()))); break;
                case PLANK: addActor(new Plank(world, loader, plc.getX(), plc.getY(), (float) Math.toDegrees(plc.getRotation()))); break;
            }
        }
        System.out.println(blocks);
    }

    public void removeBody(WorldActorGroup group){
        rem.add(group);
    }


    @Override
    public void act(float delta) {
        super.act(delta);
        world.step(delta, 10, 10);
        elapsedTime += delta;
        controlStage.act(delta);

        for (WorldActorGroup group: rem) {
            group.removeFromWorld();
            group.removeFromStage();
        }

        if(Globals.DEBUG)box2DDebugRenderer.render(world, getCamera().combined);
    }

}
