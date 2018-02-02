package hu.tokin.game.dontonext.Globals;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by M on 1/11/2018.
 */

public class Globals {

    public static final boolean DEBUG = true;
    public static final int FAN_WIDTH=150;
    public static final int FAN_HEIGHT=   150;
    public static final int PLANK_HEIGHT= 20;
    public static final int PLANK_WIDTH= 300;
    public static final int WORLD_WIDTH = 1280;
    public static final int WORLD_HEIGHT = 720;

    public static enum Selectable{CUE, FAN}

    public static Selectable selectedBlock = Selectable.CUE;


    public static final Preferences prefs = Gdx.app.getPreferences("main");

    public static boolean soundFX = true;
    //public static boolean music = prefs.getBoolean("music",true);
    public static boolean music = true;

    public static Preferences getPrefs(){
        return prefs;
    }





}
