package org.example.dmensionalityClasses;

import org.example.object.Object;

public class Point extends Object {
    private int CoordinateOne;
    private int CoordinateTwo;

    public Point(int coordinateOne, int coordinateTwo) {
        CoordinateOne = coordinateOne;
        CoordinateTwo = coordinateTwo;
    }

    public int getCoordinateOne() {
        return CoordinateOne;
    }

    public void setCoordinateOne(int coordinateOne) {
        CoordinateOne = coordinateOne;
    }

    public int getCoordinateTwo() {
        return CoordinateTwo;
    }

    public void setCoordinateTwo(int coordinateTwo) {
        CoordinateTwo = coordinateTwo;
    }
}
