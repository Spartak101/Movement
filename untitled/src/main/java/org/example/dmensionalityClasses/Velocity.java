package org.example.dmensionalityClasses;

public class Velocity implements Argumenteble{
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
