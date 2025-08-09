package org.example.dmensionalityClasses;

public class CornerCourse implements Argumenteble{
    private int Course;

    public CornerCourse(int Course) {
        this.Course = Course;
    }

    public int getCourse() {
        return Course;
    }

    public void setCourse(int course) {
        this.Course = course;
    }
}
