package org.example.commands;

import org.example.exceptions.CommandException;

public class Command implements Executable {

    private Executable object;
    private int numberOfCalls;

    public Command(Object object) {
        numberOfCalls = 0;
        this.object = (Executable) object;

    }

    @Override
    public void Execute() {
        numberOfCalls++;
        try {
            object.Execute();
        } catch (Exception e) {
            throw new CommandException("Ошибка при запуске метода Execute()", e);
        }
    }

    public Object getObject() {
        return object;
    }

    public int getNumberOfCalls() {
        return numberOfCalls;
    }
}
