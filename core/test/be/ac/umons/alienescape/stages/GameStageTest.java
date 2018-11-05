package be.ac.umons.alienescape.stages;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.World;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import be.ac.umons.alienescape.actors.Runner;
import be.ac.umons.alienescape.box2d.EnemyUserData;
import be.ac.umons.alienescape.box2d.RunnerUserData;
import be.ac.umons.alienescape.box2d.UserData;
import be.ac.umons.alienescape.utils.WorldUtils;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.when;

public class GameStageTest {

    private static HeadlessApplication application;
    private Contact contact;
    private World world;
    private SpriteBatch batch;

    @BeforeClass
    public static void init() {
        application = new HeadlessApplication(new ApplicationListener() {
            @Override
            public void create() {
            }

            @Override
            public void resize(int width, int height) {
            }

            @Override
            public void render() {
            }

            @Override
            public void pause() {
            }

            @Override
            public void resume() {
            }

            @Override
            public void dispose() {
            }
        });
        Gdx.gl20 = Mockito.mock(GL20.class);
        Gdx.gl = Gdx.gl20;
    }

    @Before
    public void setUp() {
        contact = Mockito.mock(Contact.class);
        world = new World(Vector2.Zero, true);
        batch = Mockito.mock(SpriteBatch.class);
    }

    @Test
    public void RunnerVsEnemyHitTest() {

        System.out.println("Working Directory = " +
                System.getProperty("user.dir"));

        @SuppressWarnings("unchecked")
        Animation<TextureRegion> animationMock = Mockito.mock(Animation.class);
        TextureRegion textureMock = Mockito.mock(TextureRegion.class);
        Runner runner = new Runner(WorldUtils.createRunner(world), animationMock, textureMock, textureMock, textureMock);
        GameStage gameStage = new GameStage(batch, runner);

        Body bodyA = Mockito.mock(Body.class);
        Fixture fixtureA = Mockito.mock(Fixture.class);
        UserData userDataA = new RunnerUserData(1f, 1f);
        when(bodyA.getUserData()).thenReturn(userDataA);
        when(fixtureA.getBody()).thenReturn(bodyA);
        when(contact.getFixtureA()).thenReturn(fixtureA);

        Body bodyB = Mockito.mock(Body.class);
        Fixture fixtureB = Mockito.mock(Fixture.class);
        UserData userDataB = new EnemyUserData(1f, 1f, null);
        when(bodyB.getUserData()).thenReturn(userDataB);
        when(fixtureB.getBody()).thenReturn(bodyB);
        when(contact.getFixtureB()).thenReturn(fixtureB);

        assertFalse(runner.isHit());
        gameStage.beginContact(contact);
        assertTrue(runner.isHit());
    }

    @AfterClass
    public static void cleanup() {
        application.exit();
    }
}