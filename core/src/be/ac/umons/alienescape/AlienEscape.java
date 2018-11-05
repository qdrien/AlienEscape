package be.ac.umons.alienescape;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import be.ac.umons.alienescape.stages.GameStage;

/*
* Based on http://williammora.com/a-running-game-with-libgdx-part-1
* */

public class AlienEscape extends ApplicationAdapter {
	SpriteBatch batch;
	private GameStage stage;

    @Override
	public void create () {
		batch = new SpriteBatch();
		stage = new GameStage();
	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.draw();
		stage.act(Gdx.graphics.getDeltaTime());
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
