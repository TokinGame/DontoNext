package hu.tokin.game.dontonext.Loading;

import com.badlogic.gdx.utils.viewport.ExtendViewport;

import hu.tokin.game.dontonext.Globals.Assets;
import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.Menu.MenuScreen;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyScreen;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyStage;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteAnimatedActor;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokin.game.dontonext.MyGdxGame;


/**
 * Created by M on 11/9/2017.
 */

public class LoadingScreen extends MyScreen {

    MyStage stage;

    private float elapsedTime = 0;
    private OneSpriteStaticActor backGround;

    OneSpriteAnimatedActor balls;


    public LoadingScreen(MyGdxGame game) {
        super(game);
        setBackGroundColor(0f, 0f, 0f);
        Globals.music = Globals.getPrefs().getBoolean("music", true);
        stage = new MyStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game){
            @Override
            public void init() {

            }
        };
        stage.addActor(backGround= new OneSpriteStaticActor("GameTextures/asztal.png"));
        backGround.setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
        backGround.setPosition(0,0);
        stage.addActor(balls = new OneSpriteAnimatedActor("loading/loading.txt")
        {
            @Override
            public void init() {
                super.init();
                stop();
                setSize(300, 300);
                setPosition(Globals.WORLD_WIDTH/2f-this.getWidth()/2f, Globals.WORLD_HEIGHT/2f-this.getHeight()/2f);
            }
        });
        stage.addActor(new OneSpriteStaticActor("OtherTextures/PEN.png"){
            @Override
            public void init() {
                super.init();
                setSize(150,150);
                setPosition(Globals.WORLD_WIDTH-getWidth()-100, 100);
            }
        });
        stage.addActor(new OneSpriteStaticActor("OtherTextures/tokin.png"){
            @Override
            public void init() {
                super.init();
                setSize(100, 100);
                setPosition(100, 100);
            }
        });
    }


    @Override
    public void show() {
        Assets.manager.finishLoading();
        Assets.load();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        if (elapsedTime > 2.0 && Assets.manager.update()) {
            if (Assets.manager.update()) {
                Assets.afterLoaded();
                if(Globals.getPrefs().getBoolean("firstRun", true)){
                    Globals.getPrefs().putBoolean("firstRun", false);
                    Globals.getPrefs().flush();
                    //game.setScreen(new FirstStartScreen(game),false);
                    game.setScreen(new MenuScreen(game),true);
                }else{
                    game.setScreen(new MenuScreen(game),true);
                }
            }
        }
        balls.setFramePercent(Assets.manager.getProgress());
        elapsedTime += delta;
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void hide() {

    }

    @Override
    public void init() {
        setBackGroundColor(0f, 0f, 0f);
    }

}
