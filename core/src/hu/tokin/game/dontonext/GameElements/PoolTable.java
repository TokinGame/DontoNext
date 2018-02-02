package hu.tokin.game.dontonext.GameElements;

import hu.tokin.game.dontonext.Globals.Assets;
import hu.tokin.game.dontonext.MyBaseClasses.Scene2D.OneSpriteStaticActor;

/**
 * Created by M on 2/2/2018.
 */

public class PoolTable extends OneSpriteStaticActor {

    public PoolTable() {
        // TODO: 2/2/2018 Texture
        super(Assets.manager.get(Assets.BADLOGIC_TEXTURE));
        this.setPosition(0,0);
        this.setSize(1280,720);
    }

}
