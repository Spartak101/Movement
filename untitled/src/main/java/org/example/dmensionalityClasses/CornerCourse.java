package org.example.dmensionalityClasses;

import org.example.object.Object;

public class CornerCourse extends Object {
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
