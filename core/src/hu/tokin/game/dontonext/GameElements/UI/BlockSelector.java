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

    private BlockSelectButton b0, b1, b2, b3, b4, b5, b6, b7;


    OneSpriteStaticActor nyil;


    public BlockSelector() {
        super();
        this.setSize(600,400);
        this.setPosition(Globals.WORLD_WIDTH - 100, Globals.WORLD_HEIGHT/2f - this.getHeight()/2f);

        addActor(new OneSpriteStaticActor(Assets.manager.get(Assets.TRAY)){
            @Override
            public void init() {
                super.init();
                this.setSize(BlockSelector.this.getWidth(),BlockSelector.this.getHeight());
                this.setPosition(0,0);
            }
        });

        addActor(nyil = new OneSpriteStaticActor(Assets.manager.get(Assets.ARROW)){
            @Override
            public void init() {
                super.init();
                this.setSize(100, 60);
                setPosition(40, 295);
            }
        });


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

        //addActor(b0 = new BlockSelectButton(150, 275, this, 0, Assets.manager.get(Assets.CUE_2)));
        addActor(b0 = new BlockSelectButton(10, 250, this, 1, Assets.manager.get(Assets.FAN_STATIONARY)){
            @Override
            public void init() {
                super.init();
                this.setRotation(0);

            }
        });

        addActor(b1 = new BlockSelectButton(105, 250, this, 1, Assets.manager.get(Assets.FAN_STATIONARY)){
            @Override
            public void init() {
                super.init();

                this.setRotation(45);

            }
        });

        addActor(b2 = new BlockSelectButton(200, 250, this, 1, Assets.manager.get(Assets.FAN_STATIONARY)){
            @Override
            public void init() {
                super.init();

                this.setRotation(90);

            }
        });

        addActor(b3 = new BlockSelectButton(295, 250, this, 1, Assets.manager.get(Assets.FAN_STATIONARY)){
            @Override
            public void init() {
                super.init();

                this.setRotation(135);

            }
        });

        addActor(b4 = new BlockSelectButton(390, 250, this, 1, Assets.manager.get(Assets.FAN_STATIONARY)){
            @Override
            public void init() {
                super.init();

                this.setRotation(180);

            }
        });

        addActor(b5 = new BlockSelectButton(10, 100, this, 1, Assets.manager.get(Assets.CUE_2)){
            @Override
            public void init() {
                super.init();

                this.setRotation(135);

            }
        });

        addActor(b6 = new BlockSelectButton(200, 100, this, 1, Assets.manager.get(Assets.CUE_2)){
            @Override
            public void init() {
                super.init();

                this.setRotation(0);

            }
        });

        addActor(b7 = new BlockSelectButton(390, 100, this, 1, Assets.manager.get(Assets.CUE_2)){
            @Override
            public void init() {
                super.init();
                this.setRotation(45);

            }
        });

    }

    private void slideOut(){
        moving = true;
        state = State.OUT;
        this.addAction(sequence(moveTo(Globals.WORLD_WIDTH - 500, getY(), 0.5f), run(new Runnable() {
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

        switch(id){
            case 0:
                Globals.selectedBlock = Globals.Selectable.CUE;
                nyil.setPosition(40, 295);
                break;
            case 1:
                Globals.selectedBlock = Globals.Selectable.FAN;
                nyil.setPosition(40, 170);
                break;
            case 2:
                //Globals.selectedBlock = Globals.Selectable.OTHERTURRET;
                nyil.setPosition(275, 45);
                break;

        }
        System.out.println(Globals.selectedBlock);
    }




    private enum State{
        IN,OUT
    }


}