package hu.tokin.game.dontonext.GameElements.UI;

import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.tokin.game.dontonext.Game.GameStage;
import hu.tokin.game.dontonext.Globals.Assets;
import hu.tokin.game.dontonext.Globals.Globals;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveTo;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

/**
 * Created by M on 2/2/2018.
 */

public class BlockSelector extends Group {

    private boolean moving = false;
    private State state;

    private BlockSelectButton b0, b1, b2;


    OneSpriteStaticActor nyil;


    public BlockSelector() {
        super();
        this.setSize(400,400);
        this.setPosition(Globals.WORLD_WIDTH - 100, Globals.WORLD_HEIGHT/2f - this.getHeight()/2f);

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.BADLOGIC_TEXTURE)){
            @Override
            public void init() {
                super.init();
                this.setSize(BlockSelector.this.getWidth(),BlockSelector.this.getHeight());
                this.setPosition(0,0);
            }
        });
/*
        addActor(nyil = new OneSpriteStaticActor(Assets.manager.get(Assets.MENHAJ)){
            @Override
            public void init() {
                super.init();
                this.setSize(100, 60);
                setPosition(275, 295);
            }
        });

        addActor(new MyLabel(Globals.costs[0]+" Ft", gameStage.game.getLabelStyle_White_DarkBG()){
            @Override
            public void init() {
                super.init();
                setPosition(10, 295);
            }
        });
        addActor(new MyLabel(Globals.costs[1]+" Ft", gameStage.game.getLabelStyle_White_DarkBG()){
            @Override
            public void init() {
                super.init();
                setPosition(10, 170);
            }
        });
        addActor(new MyLabel(Globals.costs[2]+" Ft", gameStage.game.getLabelStyle_White_DarkBG()){
            @Override
            public void init() {
                super.init();
                setPosition(10, 45);
            }
        });
*/
        state = State.IN;
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(!moving){
                    switch (state){
                        case IN:
                            slideOut();
                            break;
                        case OUT:
                            slideIn();
                            break;
                    }
                }
            }
        });

        addActor(b0 = new BlockSelectButton(150, 275, this, 0, Assets.manager.get(Assets.BADLOGIC_TEXTURE)));
        addActor(b1 = new BlockSelectButton(150, 150, this, 1, Assets.manager.get(Assets.BADLOGIC_TEXTURE)));
        addActor(b2 = new BlockSelectButton(150, 25, this, 2, Assets.manager.get(Assets.BADLOGIC_TEXTURE)));

    }

    private void slideOut(){
        moving = true;
        state = State.OUT;
        this.addAction(sequence(moveTo(Globals.WORLD_WIDTH - 300, getY(), 0.5f), run(new Runnable() {
            public void run () {
                moving = false;
                BlockSelector.this.removeAction(BlockSelector.this.getActions().first());
            }
        })));
    }

    private void slideIn(){
        moving = true;
        state = State.IN;
        this.addAction(sequence(moveTo( Globals.WORLD_WIDTH - 100, getY(), 0.5f), run(new Runnable() {
            public void run () {
                moving = false;
                BlockSelector.this.removeAction(BlockSelector.this.getActions().first());
            }
        })));
    }

    public void selected(int id){
        /*
        switch(id){
            case 0:
                Globals.selectedBlock = Globals.Selectable.WALL;
                nyil.setPosition(275, 295);
                break;
            case 1:
                Globals.selectedBlock = Globals.Selectable.TURRET;
                nyil.setPosition(275, 170);
                break;
            case 2:
                Globals.selectedBlock = Globals.Selectable.OTHERTURRET;
                nyil.setPosition(275, 45);
                break;

        }
        System.out.println(Globals.selectedBlock);*/
    }




    private enum State{
        IN,OUT
    }


}