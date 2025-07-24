package org.example.move;

import org.example.dmensionalityClasses.Point;
import org.example.dmensionalityClasses.Velocity;

public class Move implements IMoveingObject {
    IMoveingObject mo;

    public Move(IMoveingObject mo) {
        this.mo = mo;
    }

    public void Execute() throws Exception {
        Point po = mo.getLocation();
        Velocity ve = mo.getVelocity();
        int coordinateOne = po.getCoordinateOne();
        int coordinateTwo = po.getCoordinateTwo();
        int VelocityComponentOne = ve.getVelocityComponentOne();
        int VelocityComponentTwo = ve.getVelocityComponentTwo();
        po.setCoordinateOne(coordinateOne + VelocityComponentOne);
        po.setCoordinateTwo(coordinateTwo + VelocityComponentTwo);
        mo.setLocation(po);
    }

    @Override
    public Point getLocation() throws Exception {
        return mo.getLocation();
    }

    @Override
    public Velocity getVelocity() throws Exception {
        return mo.getVelocity();
    }

    @Override
    public void setLocation(Point newValue) {
        mo.setLocation(newValue);
    }
}
