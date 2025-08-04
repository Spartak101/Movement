package org.example.commands;

public interface Executable {
    Object object = null;

    void Execute() throws Exception;

    default Object getObject() {
        return object;
    }
}
