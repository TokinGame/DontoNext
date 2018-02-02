package hu.tokin.game.dontonext.Credits;

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

public class CreditsStage2 extends MyStage {

    MyGdxGame game;

    public CreditsStage2(Viewport viewport, Batch batch, MyGdxGame gam) {
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
        });*/

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.TOKIN)){
            @Override
            public void init() {
                super.init();
                setSize(100, 100);
                setPosition((Globals.WORLD_WIDTH/2-this.getWidth()/2)-200, 10);
            }
        });
        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.PEN)){
            @Override
            public void init() {
                super.init();
                setSize(100,100);
                setPosition((Globals.WORLD_WIDTH/2-this.getWidth()/2)+200, 10);
            }
        });

        addActor(new MyLabel("Köszönjük, hogy részt vehettünk idén is a döntőben,\nhatalmas élménnyekkel, és tapasztalattal gazdagodtunk.\n Továbbá óriási nagy köszönet Tüske Balázs Tanárúrnak,\naki rengetek időt áldozott segítésünkre, és felkészítésünkre.\nNélküle semmiképpen nem jutottunk volna el idáig.", game.getLabelStyle_White()){
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH/2-getWidth()/2, 200);
                setAlignment(2);
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
                        game.setScreen(new CreditsScreen(game));
                    }
                });
            }
        });
        addActor(new MyTextButton("Menü",game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                setPosition(Globals.WORLD_WIDTH-10-this.getWidth()-10, 10);
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
