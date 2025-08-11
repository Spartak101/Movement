package org.example.commands;

import org.example.dmensionalityClasses.Fuel;
import org.example.exceptions.FuelException;
import org.example.exceptions.ObjectException;

public class CheckFuel implements Executable {

    private Fuel fuel;
    private int requiredQuantity;

    public CheckFuel(Fuel fuel, int requiredQuantity) {
        this.fuel = fuel;
        this.requiredQuantity = requiredQuantity;
    }

    @Override
    public void Execute() throws Exception {
        if (fuel.getFuel() == 0) {
            throw new FuelException("Топлива нет!");
        } else if (fuel.getFuel() < requiredQuantity) {
            throw new FuelException("Топлива меньше необходимого");
        }
    }

    @Override
    public Fuel getObject() {
        return fuel;
    }
}
