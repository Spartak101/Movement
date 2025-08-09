package org.example.commands;

import org.example.dmensionalityClasses.Fuel;
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
            throw new ObjectException("Топлива нет!");
        } else if (fuel.getFuel() < requiredQuantity) {
            throw new ObjectException("Топлива меньше необходимого");
        }
    }

    @Override
    public Object getObject() {
        return Executable.super.getObject();
    }
}
