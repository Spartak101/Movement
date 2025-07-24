package org.example.dmensionalityClasses;

import org.example.object.Object;

public class Velocity extends Object {
    private int VelocityComponentOne;
    private int VelocityComponentTwo;

    public Velocity(int velocityComponentOne, int velocityComponentTwo) {
        VelocityComponentOne = velocityComponentOne;
        VelocityComponentTwo = velocityComponentTwo;
    }

    public int getVelocityComponentOne() {
        return VelocityComponentOne;
    }

    public void setVelocityComponentOne(int velocityComponentOne) {
        VelocityComponentOne = velocityComponentOne;
    }

    public int getVelocityComponentTwo() {
        return VelocityComponentTwo;
    }

    public void setVelocityComponentTwo(int velocityComponentTwo) {
        VelocityComponentTwo = velocityComponentTwo;
    }
}
