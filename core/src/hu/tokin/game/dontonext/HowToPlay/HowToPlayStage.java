package hu.tokin.game.dontonext.HowToPlay;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokin.game.dontonext.Globals.Assets;
import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.Menu.MenuScreen;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyStage;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokin.game.dontonext.MyBaseClasses.UI.MyLabel;
import hu.tokin.game.dontonext.MyBaseClasses.UI.MyTextButton;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by zoltan on 2018.02.02..
 */

public class HowToPlayStage extends MyStage {

    MyGdxGame game;

    public HowToPlayStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);

        game = gam;
        Gdx.input.setCatchBackKey(true);

        /*addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND_NOCON)){
            @Override
            public void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
                setPosition(0,0);
            }
        });
        */

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.MENU_BG)){
            @Override
            public void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
            }
        });

        addActor(new MyLabel("A helyi kocsmában lévő billárd asztalt egy balhé közben szétverték a dákóval, nekiállt lejteni, és egy-két oldala hiányzik.\\nÁm a kocsma népét ez sem akadályozza meg kedvenc sportjuk űzésében.\\nA raktárban talált ventillátorok segítségével akarják belöködni a golyókat, mivel a dákót is eltörték.\\n Ám mivel ők elég illuminált állapotban vannak, eme feladat rádhárult.\\nSegíts eljuttatni a golyót a pirossal jelölt lyukba, ventillátorok és törött dákók segítségével.", game.getLabelStyle_White_DarkBG()){
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-getWidth()/2, 200);
                setAlignment(2);

            }
        });

        addActor(new MyTextButton("Intro",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition((Globals.WORLD_WIDTH-getWidth())-10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        //game.setScreen(new FirstStartScreen(game));
                    }
                });
            }
        });

        addActor(new MyTextButton("Vissza",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new MenuScreen(game));
                    }
                });
            }
        });




    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
            game.setScreenBackByStackPop();
        }
        return false;
    }

    @Override
    public void init() {

    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }

}