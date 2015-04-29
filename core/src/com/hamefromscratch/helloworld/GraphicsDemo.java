package com.hamefromscratch.helloworld;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GraphicsDemo implements ApplicationListener {
	
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;

	
	@Override
	public void create() {
        Gdx.app.log("AssetPath", Gdx.files.internal("data/image.png").file().getAbsolutePath());
        batch = new SpriteBatch();
        //texture = new Texture(Gdx.files.internal("data/image.png"));
        texture = new Texture(Gdx.files.getFileHandle("data/image.png", Files.FileType.Internal));
        sprite = new Sprite(texture);

	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		batch.begin();
		sprite.draw(batch);
		batch.end();

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
		
	}

}
