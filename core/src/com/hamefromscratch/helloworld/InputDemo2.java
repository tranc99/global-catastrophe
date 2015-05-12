package com.hamefromscratch.helloworld;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ten on 5/8/15.
 */
public class InputDemo2 implements ApplicationListener, InputProcessor {

    private SpriteBatch batch;
    private BitmapFont font;
    private String message = "What now, Sherlock?";
    private int w,h;

    class TouchInfo {
        public float touchx = 0;
        public float touchy = 0;
        public boolean touched = false;
    }


    private Map<Integer, TouchInfo> touches = new HashMap<Integer, TouchInfo>();

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont(false);
        font.setColor(Color.RED);
        w = Gdx.graphics.getWidth();
        h = Gdx.graphics.getHeight();
        Gdx.input.setInputProcessor(this);
        for(int i = 0; i < 5; i++) {
            touches.put(i, new TouchInfo());
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();

        message = "";
        for(int i = 0; i < 5; i++) {
            if(touches.get(i).touched) {
                message += "Finger:" + Integer.toString(i) + " touch at:" +
                        Float.toString(touches.get(i).touchx) +
                        "," +
                        Float.toString(touches.get(i).touchy) +
                        "\n";
            }
        }
        float x = w/2 - font.getScaleX()/2;
        float y = h/2 + font.getScaleY()/2;
        font.draw(batch, message, x, y);

        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;

    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;

    }

    @Override
    public boolean touchDown(int screenx, int screeny, int pointer, int button) {
        if(pointer < 5) {
            touches.get(pointer).touchx = screenx;
            touches.get(pointer).touchy = screeny;
            touches.get(pointer).touched = true;
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenx, int screeny, int pointer, int button) {
        if(pointer < 5) {
            touches.get(pointer).touchx = 0;
            touches.get(pointer).touchy = 0;
            touches.get(pointer).touched = false;
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenx, int screeny, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenx, int screeny) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

}
