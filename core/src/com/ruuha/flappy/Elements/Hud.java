package com.ruuha.flappy.Elements;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.ruuha.flappy.sprites.Library;

/**
 * Created by ruuha on 04-11-2017.
 */
public class Hud implements Disposable {

    private BitmapFont font;
    private String a;
    private Texture heart;


    public Hud() {
        font = new BitmapFont();
        font.setColor(Color.WHITE);
        font.getData().setScale(0.75f);

        heart = new Texture("Graphics/heart.png");

    }

    public void drawHud(SpriteBatch sb, float x, float y, Library library){
      //  sb.draw(heart, x - heart.getWidth() - 5, y - heart.getHeight() - 5);

        for(int i=1; i <= library.getLives() ; i++){
            sb.draw(heart, x - (heart.getWidth()*i) - 5, y - heart.getHeight() - 5);
        }
    }

    @Override
    public void dispose() {
        font.dispose();
    }
}
