package hu.tokin.game.dontonext.GameElements.UI;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by M on 2/2/2018.
 */

public class BlockSelectButton extends OneSpriteStaticActor {
    BlockSelector blockSelector;
    private final int id;
    private PlaceableActor.Type type;

    public BlockSelectButton(float x, float y, BlockSelector bs, int i, Texture texture, final PlaceableActor.Type type) {
        super(texture);
        this.type = type;
        blockSelector = bs;
        setPosition(x, y);
        setSize(100, 100);
        id = i;
        addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                blockSelector.selected(type, getRotation());
            }
        });
    }


}
