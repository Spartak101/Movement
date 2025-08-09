package org.example.commands;

import org.example.dmensionalityClasses.Velocity;

public class ChangeVelocity implements Executable {

    private Velocity velocity;
    private int boostComponentOne;
    private int boostComponentTwo;

    public ChangeVelocity(Velocity velocity, int boostComponentOne, int boostComponentTwo) {
        this.velocity = velocity;
        this.boostComponentOne = boostComponentOne;
        this.boostComponentTwo = boostComponentTwo;
    }

    @Override
    public void Execute() throws Exception {
        velocity.setVelocityComponentOne(velocity.getVelocityComponentOne() + boostComponentOne);
        velocity.setVelocityComponentTwo(velocity.getVelocityComponentTwo() + boostComponentTwo);
    }

    @Override
    public Velocity getObject() {
        return velocity;
    }
}
