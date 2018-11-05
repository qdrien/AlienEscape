package be.ac.umons.alienescape.utils;

import com.badlogic.gdx.physics.box2d.Body;
import be.ac.umons.alienescape.box2d.UserData;

public class BodyUtils {

    public static boolean bodyInBounds(Body body) {
        UserData userData = (UserData) body.getUserData();

        switch (userData.getUserDataType()) {
            case RUNNER:
            case ENEMY:
                return body.getPosition().x + userData.getWidth() / 2 > 0;
        }

        return true;
    }
}