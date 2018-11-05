package be.ac.umons.alienescape.box2d;

import com.badlogic.gdx.math.Vector2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EnemyUserDataTest {

    /**
     * This test is an example of what you should not be doing as the tested function
     * ({@link EnemyUserData#setLinearVelocity(Vector2)}) is a simple setter.
     * You should only test parts of your code that are complex enough to potentially fail.
     */
    @Test
    public void setLinearVelocityUselessTest() {
        //Since we will not be rendering anything, we can simply set the textureRegions parameter to "null"
        EnemyUserData enemyUserData = new EnemyUserData(1f, 1f, null);

        enemyUserData.setLinearVelocity(Vector2.Zero);
        assertEquals(Vector2.Zero, enemyUserData.getLinearVelocity());
        enemyUserData.setLinearVelocity(new Vector2(1f, 2f));
        assertEquals(new Vector2(1f, 2f), enemyUserData.getLinearVelocity());
    }
}