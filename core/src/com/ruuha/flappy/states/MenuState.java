package com.ruuha.flappy.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ruuha.flappy.AdHandler;
import com.ruuha.flappy.FlappyDemo;


/**
 * Created by ruuha on 04-11-2017.
 */
public class MenuState extends State{

    private Texture background;
    AdHandler handler;

    public MenuState(GameStateManager gsm, AdHandler handler) {
        super(gsm);
        this.handler = handler;
        cam.setToOrtho(false, FlappyDemo.WIDTH / 2, FlappyDemo.HEIGHT / 2);
        background = new Texture("backgrounds/home_hs.png");
        handler.showAds(true);
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm, handler));
            handler.showAds(false);
        }

        if (Gdx.input.isKeyPressed(Input.Keys.BACK)) {
            if (FlappyDemo.toggleBack) {
                Gdx.app.exit();
            }
        }
        else{
            FlappyDemo.toggleBack = true;
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(background, 0, 0, 0,0,background.getWidth(), background.getHeight());
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
    }
}
