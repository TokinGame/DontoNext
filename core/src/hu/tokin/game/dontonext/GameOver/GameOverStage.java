package hu.tokin.game.dontonext.GameOver;

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
import hu.tokin.game.dontonext.MyBaseClasses.UI.MyTextButton;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by zoltan on 2018.02.02..
 */

public class GameOverStage extends MyStage {

    MyGdxGame game;


    public GameOverStage(Viewport viewport, Batch batch, MyGdxGame gam) {
        super(viewport, batch, gam);

        game = gam;
        Gdx.input.setCatchBackKey(true);


        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.GAMEOVER)) {
            @Override
            public void init() {
                super.init();
                setSize(Globals.WORLD_WIDTH, Globals.WORLD_HEIGHT);
                setPosition(0, 0);
            }
        });


        addActor(new MyTextButton("Biztosan ki akarsz lépni?", game.getTextButtonStyle()) {
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH / 2 - this.getWidth() / 2, Globals.WORLD_HEIGHT / 2 - this.getHeight() / 2);
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreenBackByStackPop();
                    }
                });
            }
        });
        addActor(new MyTextButton("Igen", game.getTextButtonStyle()) {
            @Override
            public void init() {
                super.init();
                setPosition(10, 10);
                addListener(new ClickListener() {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        Gdx.app.exit();
                    }
                });
            }
        });
        addActor(new MyTextButton("Menü", game.getTextButtonStyle()) {
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH - this.getWidth() - 10, 10);
                addListener(new ClickListener() {
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
        if (keycode == Input.Keys.BACK) {
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
