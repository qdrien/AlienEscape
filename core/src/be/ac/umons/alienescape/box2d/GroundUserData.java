package be.ac.umons.alienescape.box2d;

import be.ac.umons.alienescape.enums.UserDataType;

public class GroundUserData extends UserData {

    public GroundUserData(float width, float height) {
        super(width, height);
        userDataType = UserDataType.GROUND;
    }
}
