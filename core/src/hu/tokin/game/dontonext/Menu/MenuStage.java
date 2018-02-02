package hu.tokin.game.dontonext.Menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;


import hu.tokin.game.dontonext.Credits.CreditsScreen;
import hu.tokin.game.dontonext.Exit.ExitScreen;
import hu.tokin.game.dontonext.Game.GameScreen;
import hu.tokin.game.dontonext.Globals.Assets;
import hu.tokin.game.dontonext.Globals.Globals;

import hu.tokin.game.dontonext.HowToPlay.HowToPlayScreen;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyStage;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokin.game.dontonext.MyBaseClasses.UI.MyTextButton;
import hu.tokin.game.dontonext.MyGdxGame;
import hu.tokin.game.dontonext.Settings.SettingsScreen;


/**
 * Created by M on 11/9/2017.
 */

public class MenuStage extends MyStage {
    ArrayList<float[]> pos=new ArrayList();
    MyGdxGame game;
    int selected=0;
    OneSpriteStaticActor Hajo;


    public MenuStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);
        selected=0;
        System.out.println("asdf");
        game = gam;
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchBackKey(true);
        for(StackTraceElement s: Thread.currentThread().getStackTrace()){
            //System.out.println(s);
        }


        addActor(new MyTextButton("Játék",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10, Globals.WORLD_HEIGHT-this.getHeight()-10);
                float[] x={getX()+getWidth(),getY()};
                pos.add(x);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new GameScreen(game));
                    }
                });
            }
        });

        addActor(new MyTextButton("High Scores",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10, (Globals.WORLD_HEIGHT/5-this.getHeight()/5)*4);
                float[] x={getX()+getWidth(),getY()};
                pos.add(x);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        //game.setScreen(new HighScreen(game));
                    }
                });
            }
        });

        addActor(new MyTextButton("Hogyan Játssz",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10, (Globals.WORLD_HEIGHT/5-this.getHeight()/5)*3);
                float[] x={getX()+getWidth(),getY()};
                pos.add(x);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                       game.setScreen(new HowToPlayScreen(game));
                    }
                });
            }
        });

        addActor(new MyTextButton("Készítők",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10, (Globals.WORLD_HEIGHT/5-this.getHeight()/5)*2);
                float[] x={getX()+getWidth(),getY()};
                pos.add(x);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new CreditsScreen(game));
                    }
                });
            }
        });

        addActor(new MyTextButton("Beállítások",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10, Globals.WORLD_HEIGHT/5-this.getHeight()/5);
                float[] x={getX()+getWidth(),getY()};
                pos.add(x);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new SettingsScreen(game));
                    }
                });
            }
        });

        addActor(new MyTextButton("Kilépés",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10, 10);
                float[] x={getX()+getWidth(),getY()};
                pos.add(x);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new ExitScreen(game));
                    }
                });
            }
        });

    }

    void mozgas(){
        Hajo.addAction(Actions.moveTo(pos.get(selected)[0],pos.get(selected)[1],0.5f));
    }

    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.BACK){
            game.setScreen(new ExitScreen(game));
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
