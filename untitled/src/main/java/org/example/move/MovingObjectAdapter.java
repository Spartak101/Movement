package org.example.move;

import org.example.object.UObject;
import org.example.dmensionalityClasses.Point;
import org.example.dmensionalityClasses.Velocity;

public class MovingObjectAdapter implements IMoveingObject {
    UObject object;

    public MovingObjectAdapter(UObject object) {
        this.object = object;
    }

    @Override
    public Point getLocation() throws Exception {
        return (Point) object.get("location");
    }

    @Override
    public Velocity getVelocity() throws Exception {
        return (Velocity) object.get("velocity");
    }

    @Override
    public void setLocation(Point newValue) {
        object.set("location", newValue);
    }
}
