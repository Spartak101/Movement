package org.example.fuel;

import org.example.dmensionalityClasses.Fuel;

public interface IActionsWithFuel {
    Fuel getFuel() throws Exception;
    void setFuel(Fuel newValue);
}
