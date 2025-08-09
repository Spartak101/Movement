package org.example.commands;

import org.example.exceptions.CommandException;
import org.example.tasks.Taskable;

import java.util.ArrayList;

public class MultiCommand implements Executable {

    private ArrayList<Taskable> arrayTask;

    public MultiCommand(ArrayList<Taskable> arrayTask) {
        this.arrayTask = arrayTask;
    }

    @Override
    public void Execute() throws Exception {

        arrayTask.forEach(taskable -> {
            try {
                taskable.Execute();
            } catch (Exception e) {
                throw new CommandException(e);
            }
        });
    }

    @Override
    public Object getObject() {
        return arrayTask;
    }
}
