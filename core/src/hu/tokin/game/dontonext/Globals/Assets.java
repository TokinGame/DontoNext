package hu.tokin.game.dontonext.Globals;

/**
 * Created by M on 1/5/2018.
 */



import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.FileHandleResolver;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;
import com.badlogic.gdx.graphics.g2d.freetype.FreetypeFontLoader;


public class Assets {

    public static AssetManager manager;
    public static final String CHARS = "0123456789öüóqwertzuiopőúasdfghjkléáűíyxcvbnm'+!%/=()ÖÜÓQWERTZUIOPŐÚASDFGHJKLÉÁŰÍYXCVBNM?:_*<>#&@{}[],-.";


    static final FreetypeFontLoader.FreeTypeFontLoaderParameter fontParameter = new FreetypeFontLoader.FreeTypeFontLoaderParameter();
    static {
        fontParameter.fontFileName = "calibril.ttf";////
        fontParameter.fontParameters.size = 50;
        fontParameter.fontParameters.characters = CHARS;
        fontParameter.fontParameters.color = Color.WHITE;
    }
    public static final AssetDescriptor<BitmapFont> CALIBRI_FONT = new AssetDescriptor<BitmapFont>(fontParameter.fontFileName, BitmapFont.class, fontParameter);


    public static final AssetDescriptor<Texture> BADLOGIC_TEXTURE = new AssetDescriptor<Texture>("badlogic.jpg", Texture.class);
    public static final AssetDescriptor<Texture> EMPTY = new AssetDescriptor<Texture>("OtherTextures/zolipls.png", Texture.class);
    public static final AssetDescriptor<Music> MAIN_MUSIC = new AssetDescriptor<Music>("music/music.wav", Music.class);
    public static final AssetDescriptor<Texture> MUSIC_ON = new AssetDescriptor<Texture>("music/musicon.png", Texture.class);
    public static final AssetDescriptor<Texture> MUSIC_OFF = new AssetDescriptor<Texture>("music/musicoff.png", Texture.class);
    public static final AssetDescriptor<Texture> BACKGROUND_TABLE = new AssetDescriptor<Texture>("GameTextures/asztal.png", Texture.class);
    public static final AssetDescriptor<Texture> CUE_1 = new AssetDescriptor<Texture>("GameTextures/dako/egyik.png", Texture.class);
    public static final AssetDescriptor<Texture> CUE_2 = new AssetDescriptor<Texture>("GameTextures/dako/masik.png", Texture.class);
    public static final AssetDescriptor<Texture> TOKIN = new AssetDescriptor<Texture>("OtherTextures/tokin.png", Texture.class);
    public static final AssetDescriptor<Texture> PEN = new AssetDescriptor<Texture>("OtherTextures/PEN.png", Texture.class);
    public static final AssetDescriptor<Texture> BALL = new AssetDescriptor<Texture>("GameTextures/golyo.png", Texture.class);
    public static final AssetDescriptor<Texture> MENU_BG = new AssetDescriptor<Texture>("GameTextures/menu_bg.png", Texture.class);

    public static final AssetDescriptor<Texture> TRAY = new AssetDescriptor<Texture>("GameTextures/talca.png", Texture.class);
    public static final AssetDescriptor<Texture> BUTTON = new AssetDescriptor<Texture>("GameTextures/gomb.png", Texture.class);

    public static final AssetDescriptor<Texture> FAN_STATIONARY = new AssetDescriptor<Texture>("OtherTextures/1.png", Texture.class);

    public static final AssetDescriptor<Texture> SPIN = new AssetDescriptor<Texture>("GameTextures/nyil.png", Texture.class);
    public static final AssetDescriptor<Texture> CIRCLE = new AssetDescriptor<Texture>("GameTextures/kor.png", Texture.class);







    public static void prepare() {
        manager = new AssetManager();
        Texture.setAssetManager(manager);
    }

    public static void load() {
        FileHandleResolver resolver = new InternalFileHandleResolver();
        manager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(resolver));
        manager.setLoader(BitmapFont.class, ".ttf", new FreetypeFontLoader(resolver));
        manager.setLoader(BitmapFont.class, ".otf", new FreetypeFontLoader(resolver));
        manager.load(BADLOGIC_TEXTURE);
        manager.load(CALIBRI_FONT);
        manager.load(MUSIC_OFF);
        manager.load(MUSIC_ON);
        manager.load(EMPTY);

        manager.load(BACKGROUND_TABLE);
        manager.load(MAIN_MUSIC);
        manager.load(PEN);
        manager.load(TOKIN);

        manager.load(CUE_1);
        manager.load(CUE_2);
        manager.load(BALL);
        manager.load(MENU_BG);
        manager.load(TRAY);
        manager.load(BUTTON);
        manager.load(FAN_STATIONARY);
        manager.load(CIRCLE);
        manager.load(SPIN);

        manager.load(MAIN_MUSIC);


    }

    public static void afterLoaded() {

        manager.get(MAIN_MUSIC).setLooping(true);
        if (Globals.music) manager.get(MAIN_MUSIC).play();

    }

    public static void unload() {
        manager.dispose();
    }
}

