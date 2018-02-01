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


    public LoadingScreen(MyGdxGame game) {
        super(game);
        setBackGroundColor(0f, 0f, 0f);
        stage = new MyStage(new ExtendViewport(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT), spriteBatch, game){
            @Override
            public void init() {

            }
        };
        //stage.addActor(backGround= new OneSpriteStaticActor("loadingbg.png"));
//        backGround.setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
  //      backGround.setPosition(0,0);
        /*stage.addActor(new OneSpriteAnimatedActor("loading/loading.txt")
        {
            @Override
            public void init() {
                super.init();
                setFps(30);
                setSize(400, 400);
                setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, Globals.WORLD_HEIGHT/2-this.getHeight()/2);
            }
        });*/
    }


    @Override
    public void show() {
        Assets.manager.finishLoading();
        Assets.load();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        if (/*elapsedTime > 2.0 &&*/ Assets.manager.update()) {
            if (Assets.manager.update()) {
                Assets.afterLoaded();
                if(Globals.getPrefs().getBoolean("firstRun", true)){
                    Globals.getPrefs().putBoolean("firstRun", false);
                    Globals.getPrefs().flush();
                    //game.setScreen(new FirstStartScreen(game),false);
                    game.setScreen(new MenuScreen(game),false);
                }else{
                    game.setScreen(new MenuScreen(game),false);
                }
            }
        }
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
