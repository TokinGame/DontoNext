package hu.tokin.game.dontonext.Settings;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import hu.tokin.game.dontonext.Globals.Assets;
import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyStage;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokin.game.dontonext.MyBaseClasses.UI.MyTextButton;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by zoltan on 2018.02.02..
 */

public class SettingsStage extends MyStage {



    MyGdxGame game;
    boolean musicToggle=true;
    public static final String SOUDNFX_LABEL = "Hangeffektek: ", MUSIC_LABEL = "Zene: ";
    OneSpriteStaticActor Zene;
    OneSpriteStaticActor NemZene;
    public SettingsStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);

        game = gam;

        /*addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BACKGROUND_NOCON)){
            @Override
            public void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
                setPosition(0,0);
            }
        });*/


        addActor(Zene=new OneSpriteStaticActor(Assets.manager.get(Assets.MUSIC_ON)){
            @Override
            public void init() {
                super.init();
                setSize(50, 50);
                setPosition((Globals.WORLD_WIDTH/2-this.getWidth()/2)+100, 400);
                if (!Globals.music) setTexture(Assets.manager.get(Assets.MUSIC_OFF));
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        musicToggle = !musicToggle;
                        Globals.music = !Globals.music;

                        if (musicToggle) {
                            setTexture(Assets.manager.get(Assets.MUSIC_ON));
                            Assets.manager.get(Assets.MAIN_MUSIC).play();
                        } else {
                            setTexture(Assets.manager.get(Assets.MUSIC_OFF));
                            Assets.manager.get(Assets.MAIN_MUSIC).pause();
                        }
                    }
                });
            }
        });
        addActor(new MyTextButton(MUSIC_LABEL, game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                this.setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 400);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Globals.music = !Globals.music;
                        if(Globals.music)Assets.manager.get(Assets.MAIN_MUSIC).play();
                        else Assets.manager.get(Assets.MAIN_MUSIC).pause();
                        Globals.getPrefs().putBoolean("music", Globals.music);
                        Globals.getPrefs().flush();
                        setText(MUSIC_LABEL + (Globals.music ? "Be" : "Ki"));
                    }
                });
            }
        });


        /*addActor(new MyTextButton(SOUDNFX_LABEL, game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                this.setText(SOUDNFX_LABEL + (Globals.soundFX ? "Be" : "Ki"));
                this.setPosition(Globals.WORLD_WIDTH/2-this.getWidth()/2, 500);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Globals.soundFX = !Globals.soundFX;
                        Globals.getPrefs().putBoolean("soundFX", Globals.soundFX);
                        Globals.getPrefs().flush();
                        setText(SOUDNFX_LABEL + (Globals.soundFX ? "Be" : "Ki"));
                    }
                });
            }
        });*/


        addActor(new MyTextButton("Vissza",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(10, 10);
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreenBackByStackPop();
                    }
                });
            }
        });




    }

    @Override
    public void init() {

    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }

}
