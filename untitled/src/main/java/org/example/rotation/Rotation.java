package org.example.rotation;

import org.example.dmensionalityClasses.AngularVelocity;
import org.example.dmensionalityClasses.CornerCourse;

public class Rotation {

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
}
