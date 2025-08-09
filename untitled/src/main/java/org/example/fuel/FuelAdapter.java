package org.example.fuel;

import org.example.dmensionalityClasses.Fuel;
import org.example.object.UObject;

public class FuelAdapter implements IActionsWithFuel {
    UObject object;

    public FuelAdapter(UObject object) {
        this.object = object;
    }

    @Override
    public Fuel getFuel() throws Exception {
        return (Fuel) object.get("fuel");
    }

    @Override
    public void setFuel(Fuel newValue) {
        object.set("fuel", newValue);
    }
}
