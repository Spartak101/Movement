package org.example.move;

import org.example.dmensionalityClasses.Point;
import org.example.dmensionalityClasses.Velocity;

public interface IMoveingObject {
    Point getLocation() throws Exception;
    Velocity getVelocity() throws Exception;
    void setLocation(Point newValue);
}
