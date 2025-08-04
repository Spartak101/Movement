package org.example.tasks;

public interface Taskable {
    Object object = null;

    void Execute() throws Exception;

    default Object getObject() {
        return object;
    }
}
