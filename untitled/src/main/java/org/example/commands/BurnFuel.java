package org.example.commands;

import org.example.dmensionalityClasses.Fuel;

public class BurnFuel implements Executable{

    private Fuel fuel;
    private int requiredQuantity;

    public BurnFuel(Fuel fuel, int requiredQuantity) {
        this.fuel = fuel;
        this.requiredQuantity = requiredQuantity;
    }

    @Override
    public void Execute() throws Exception {
        fuel.setFuel(fuel.getFuel() - requiredQuantity);
    }

    @Override
    public Fuel getObject() {
        return fuel;
    }
}
