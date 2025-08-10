package org.example.dmensionalityClasses;


public class Point implements Argumenteble {
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
