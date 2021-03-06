package hu.tokin.game.dontonext.Game;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

import hu.tokin.game.dontonext.GameElements.UI.BlockSelector;
import hu.tokin.game.dontonext.GameElements.UI.PlaceableActor;
import hu.tokin.game.dontonext.GameElements.UI.RotateButton;
import hu.tokin.game.dontonext.Globals.Assets;
import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.MyStage;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;
import hu.tokin.game.dontonext.MyBaseClasses.UI.MyLabel;
import hu.tokin.game.dontonext.MyBaseClasses.UI.MyTextButton;
import hu.tokin.game.dontonext.MyGdxGame;

/**
 * Created by davim on 2018. 01. 11..
 */

public class ControlStage extends MyStage {
    private GameStage gameStage;

    OneSpriteStaticActor actor;

    private boolean dragging = false;

    private float selectedRotation = 0;
    private PlaceableActor.Type type;

    private float difX = 0, difY = 0;

    private BlockSelector blockSelector;

    MyTextButton startbutton, restartButton;


    public ControlStage(Viewport viewport, Batch batch, final MyGdxGame game, GameStage gameStage) {
        super(viewport, batch, game);
        this.gameStage = gameStage;
        setUpDrag();

        addActor(blockSelector = new BlockSelector(this));

        addActor(startbutton = new MyTextButton("Start", game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                this.setPosition(Globals.WORLD_WIDTH /2f - getWidth() / 2f, Globals.WORLD_HEIGHT - getHeight());
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        start();
                        System.out.println("asdklfjklasdj");
                    }
                });
            }
        });

    }

    private void setUpDrag(){
        addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                for (Actor placable: getActors()) {
                    if(placable instanceof PlaceableActor){
                        if(((PlaceableActor) placable).isPressed()){
                            difX = x - placable.getX();
                            difY = y - placable.getY();
                            dragging = true;
                        }
                    }
                }
                if(!dragging && x < Globals.WORLD_WIDTH - 105 && blockSelector.getState() == BlockSelector.State.IN){
                    build(x,y);
                }
                dragging = false;
                return true;
            }

            @Override
            public void touchDragged(InputEvent event, float x, float y, int pointer) {
                super.touchDragged(event, x, y, pointer);
                for (Actor placable: getActors()) {
                    if(placable instanceof PlaceableActor){
                        if(((PlaceableActor) placable).isPressed()) {
                            placable.setPosition(x - difX, y - difY);
                        }
                    }
                }
            }

            @Override
            public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
                super.touchUp(event, x, y, pointer, button);
            }
        });
    }


    public void build(final float x, final float y){
        addActor(new PlaceableActor(type, this, selectedRotation){
            @Override
            public void init() {
                super.init();
                setPosition(x, y);
            }
        });
    }


    public void start(){
        ArrayList<PlaceableActor> plc = new ArrayList<PlaceableActor>();
        for (Actor placable: getActors()) {
            if(placable instanceof PlaceableActor){
                plc.add((PlaceableActor) placable);
            }
        }
        for (Actor placable: getActors()) {
            if(placable instanceof PlaceableActor){
                placable.remove();
            }
        }
        gameStage.buildMap(plc);
        gameStage.spawn();
        gameStage.ballplace.remove();
        startbutton.setVisible(false);
        addActor(restartButton = new MyTextButton("Újra", game.getTextButtonStyle()){
            @Override
            public void init() {
                super.init();
                this.setPosition(Globals.WORLD_WIDTH /2f - getWidth() / 2f+300, Globals.WORLD_HEIGHT - getHeight());
                addListener(new ClickListener(){
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        super.clicked(event, x, y);
                        game.setScreen(new GameScreen(game), false);
                        System.out.println("asdklfjklasdj");
                    }
                });
            }
        });

    }


    public void setDragging(boolean dragging) {
        this.dragging = dragging;
    }

    public void setSelectedRotation(float selectedRotation) {
        this.selectedRotation = selectedRotation;
    }

    public void setType(PlaceableActor.Type type) {
        this.type = type;
    }

    @Override
    public void init() {
    }

    @Override
    public void act(float delta) {
        super.act(delta);

    }


}
