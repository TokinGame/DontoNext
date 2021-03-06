package hu.tokin.game.dontonext.LevelSelect;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokin.game.dontonext.Credits.CreditsScreen2;
import hu.tokin.game.dontonext.Game.GameScreen;
import hu.tokin.game.dontonext.Globals.Assets;
import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.Menu.MenuScreen;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyStage;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokin.game.dontonext.MyBaseClasses.UI.MyLabel;
import hu.tokin.game.dontonext.MyBaseClasses.UI.MyTextButton;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by davim on 2018. 02. 02..
 */

public class LevelSelectStage extends MyStage{

    MyGdxGame game;

    public LevelSelectStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);

        game = gam;
        Gdx.input.setInputProcessor(this);
        Gdx.input.setCatchBackKey(true);



        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.MENU_BG)){
            @Override
            public void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
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


        /*addActor(new MyTextButton("1",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(200, 400);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new GameScreen(game));
                    }
                });
            }
        });*/

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.L1)){
            @Override
            public void init() {
                super.init();
                setPosition(200, 400);
                setSize(100, 100);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Globals.level = 0;
                        game.setScreen(new GameScreen(game));
                    }
                });
            }
        });
        if(Globals.unlocked[1])
            addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.L2)){
            @Override
            public void init() {
                super.init();
                setPosition(400, 400);
                setSize(100, 100);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Globals.level = 1;
                        game.setScreen(new GameScreen(game));
                    }
                });
            }
        });
        if(Globals.unlocked[2])
            addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.L3)){
                @Override
                public void init() {
                    super.init();
                    setPosition(600, 400);
                    setSize(100, 100);
                    addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            Globals.level = 2;
                            game.setScreen(new GameScreen(game));
                        }
                    });
                }
            });
        if(Globals.unlocked[3])
            addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.L4)){
                @Override
                public void init() {
                    super.init();
                    setPosition(200, 200);
                    setSize(100, 100);
                    addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            Globals.level = 3;
                            game.setScreen(new GameScreen(game));
                        }
                    });
                }
            });
        if(Globals.unlocked[4])
            addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.L5)){
                @Override
                public void init() {
                    super.init();
                    setPosition(400, 200);
                    setSize(100, 100);
                    addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            Globals.level = 4;
                            game.setScreen(new GameScreen(game));
                        }
                    });
                }
            });
        if(Globals.unlocked[5])
            addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.L6)){
                @Override
                public void init() {
                    super.init();
                    setPosition(600, 200);
                    setSize(100, 100);
                    addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event, float x, float y) {
                            super.clicked(event, x, y);
                            Globals.level = 5;
                            game.setScreen(new GameScreen(game));
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
