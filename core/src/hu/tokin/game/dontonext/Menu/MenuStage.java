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

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.MENU_BG)){
            @Override
            public void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
            }
        });


        addActor(new MyTextButton("Játék",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition((Globals.WORLD_WIDTH/5-this.getWidth()/5)*1, 1000);
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
            float elapsedTime = 0;
            float maxWidth = 580, maxHeight = 500;

            @Override
            public void act(float delta) {
                elapsedTime += delta;
                setPosition((((Globals.WORLD_WIDTH - this.getWidth())/5)*1)-200, maxHeight);
                super.act(delta);


                setY((float) (1000-(Math.sin(elapsedTime * 1.2f) * maxHeight / 8 + maxHeight)));
            }
        });



        addActor(new MyTextButton("Hogyan\nJátssz",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition((Globals.WORLD_WIDTH/5-this.getWidth()/5)*2, 950);
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
            float elapsedTime = 0;
            float maxWidth = 580, maxHeight = 525;

            @Override
            public void act(float delta) {
                elapsedTime += delta;
                setPosition((((Globals.WORLD_WIDTH - this.getWidth())/5)*2)-200, maxHeight);
                super.act(delta);


                setY((float) (1000-(Math.sin(elapsedTime * 1.2f) * maxHeight / 8 + maxHeight)));
            }
        });

        addActor(new MyTextButton("Készítők",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(((Globals.WORLD_WIDTH/2-this.getWidth()/2)), 1000);
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
            float elapsedTime = 0;
            float maxWidth = 580, maxHeight = 500;

            @Override
            public void act(float delta) {
                elapsedTime += delta;
                setPosition((((Globals.WORLD_WIDTH/2 - this.getWidth()/2))), maxHeight);
                super.act(delta);


                setY((float) (1000-(Math.sin(elapsedTime * 1.2f) * maxHeight / 8 + maxHeight)));
            }
        });

        addActor(new MyTextButton("Beállítások",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition((Globals.WORLD_WIDTH/5-this.getWidth()/5)*4, 1000);
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
            float elapsedTime = 0;
            float maxWidth = 580, maxHeight = 500;

            @Override
            public void act(float delta) {
                elapsedTime += delta;
                setPosition((((Globals.WORLD_WIDTH - this.getWidth())/5)*4)-50, maxHeight);
                super.act(delta);


                setY((float) (1000-(Math.sin(elapsedTime * 1.2f) * maxHeight / 8 + maxHeight)));
            }
        });

        addActor(new MyTextButton("Kilépés",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition((Globals.WORLD_WIDTH/5-this.getWidth()/5)*5, 1000);
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
            float elapsedTime = 0;
            float maxWidth = 580, maxHeight = 500;

            @Override
            public void act(float delta) {
                elapsedTime += delta;
                setPosition((((Globals.WORLD_WIDTH - this.getWidth())/5)*5)-50, maxHeight);
                super.act(delta);


                setY((float) (1000-(Math.sin(elapsedTime * 1.2f) * maxHeight / 8 + maxHeight)));
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
