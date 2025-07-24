package org.example.rotation;

import org.example.dmensionalityClasses.AngularVelocity;
import org.example.dmensionalityClasses.CornerCourse;

public interface IRotationObject {
    CornerCourse getCourse() throws Exception;
    AngularVelocity getAVelocity() throws Exception;
    void setCourse(CornerCourse newValue);
}
