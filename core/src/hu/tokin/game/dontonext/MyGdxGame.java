package hu.tokin.game.dontonext;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import hu.tokin.game.dontonext.Globals.Assets;
import hu.tokin.game.dontonext.Loading.LoadingScreen;
import hu.tokin.game.dontonext.MyBaseClasses.Game.MyGame;


public class MyGdxGame extends MyGame {
	SpriteBatch batch;
	Texture img;

	public Label.LabelStyle getLabelStyle_Yellow() {
		Label.LabelStyle style;
		style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
		style.font = Assets.manager.get(Assets.CALIBRI_FONT);
		style.fontColor = Color.YELLOW;
		return style;
	}

	public Label.LabelStyle getLabelStyle_Red() {
		Label.LabelStyle style;
		style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
		style.font = Assets.manager.get(Assets.CALIBRI_FONT);
		style.fontColor = Color.RED;
		return style;
	}

	public Label.LabelStyle getLabelStyle_Green() {
		Label.LabelStyle style;
		style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
		style.font = Assets.manager.get(Assets.CALIBRI_FONT);
		style.fontColor = Color.GREEN;
		return style;
	}

	public Label.LabelStyle getLabelStyle_White() {
		Label.LabelStyle style;
		style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
		style.font = Assets.manager.get(Assets.CALIBRI_FONT);
		style.fontColor = Color.WHITE;
		return style;
	}

	public Label.LabelStyle getLabelStyle_White_DarkBG() {
		Label.LabelStyle style;
		style = new com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle();
		//style.background = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.LABEL_BG)));
		style.font = Assets.manager.get(Assets.CALIBRI_FONT);
		style.fontColor = Color.WHITE;
		return style;
	}

	public TextField.TextFieldStyle getTextFieldStyle() {
		// TODO: 1/5/2018 textfield texture
		TextField.TextFieldStyle style = new TextField.TextFieldStyle();
		// style.background = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.TEXTBOX_TEXTURE)));
		style.background.setLeftWidth(style.background.getLeftWidth()+20);
		style.background.setRightWidth(style.background.getRightWidth()+20);
		style.font = Assets.manager.get(Assets.CALIBRI_FONT);
		// style.cursor = new TextureRegionDrawable(new TextureRegion(new TextureRegion(Assets.manager.get(Assets.CURSOR_TEXTURE))));
		// style.cursor.setMinWidth(50);
		style.fontColor = Color.BLACK;
		// style.selection = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BLUE_TEXTURE)));
		return style;
	}


	public TextButton.TextButtonStyle getTextButtonStyle() {
		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.font = Assets.manager.get(Assets.CALIBRI_FONT);
		// TODO: 1/5/2018 Button texture
/*
		textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BUTTON)));
		textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BUTTON)));
		textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BUTTON)));
*/
		return textButtonStyle;
	}


	public TextButton.TextButtonStyle getTextButtonStyle_Background() {
		TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
		textButtonStyle.font = Assets.manager.get(Assets.CALIBRI_FONT);
		// TODO: 1/5/2018 Button texture

		textButtonStyle.up = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BUTTON)));
		textButtonStyle.over = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BUTTON)));
		textButtonStyle.down = new TextureRegionDrawable(new TextureRegion(Assets.manager.get(Assets.BUTTON)));

		return textButtonStyle;
	}



	@Override
	public void create() {
		Assets.prepare();
		Gdx.input.setCatchBackKey(true);
		setScreen(new LoadingScreen(this));
	}

	@Override
	public void resume() {
		super.resume();
		Assets.manager.update();
	}

	@Override
	public void dispose() {
		super.dispose();
		Assets.unload();
	}
}
