package org.example.rotation;

import org.example.dmensionalityClasses.AngularVelocity;
import org.example.dmensionalityClasses.CornerCourse;
import org.example.object.UObject;

public class RotationObjectAdapter implements IRotationObject {

    UObject object;

    public RotationObjectAdapter(UObject object) {
        this.object = object;
    }

    @Override
    public CornerCourse getCourse() throws Exception {
        return (CornerCourse) object.get("Course");
    }

    @Override
    public AngularVelocity getAVelocity() throws Exception {
        return (AngularVelocity) object.get("AVelocity");
    }

    @Override
    public void setCourse(CornerCourse newValue) {
        object.set("Course", newValue);
    }
}
