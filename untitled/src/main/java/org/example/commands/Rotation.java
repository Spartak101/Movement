package org.example.commands;

import org.example.dmensionalityClasses.AngularVelocity;
import org.example.dmensionalityClasses.CornerCourse;
import org.example.rotation.IRotationObject;

public class Rotation implements IRotationObject {

    IRotationObject ro;

    public Rotation(IRotationObject ro) {
        this.ro = ro;
    }

    public void Execute() throws Exception {
        CornerCourse co = ro.getCourse();
        AngularVelocity av = ro.getAVelocity();
        int course = co.getCourse();
        int velocity = av.getAVelocity();
        co.setCourse(course + velocity);
        ro.setCourse(co);
    }

    @Override
    public CornerCourse getCourse() throws Exception {
        return ro.getCourse();
    }

    @Override
    public AngularVelocity getAVelocity() throws Exception {
        return ro.getAVelocity();
    }

    @Override
    public void setCourse(CornerCourse newValue) {
        ro.setCourse(newValue);
    }
}
