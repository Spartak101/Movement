package org.example.commands;

import org.example.TaskQueue;
import org.example.exceptionHandler.ExceptionHandler;
import org.example.exceptions.CommandException;
import org.example.tasks.Taskable;

import java.util.ArrayList;
import java.util.logging.Logger;

public class MultiCommand implements Executable {

    private ArrayList<Executable> arrayTask;
    private TaskQueue queue;
    private Logger logger;

    public MultiCommand(ArrayList<Executable> arrayTask, TaskQueue queue, Logger logger) {
        this.arrayTask = arrayTask;
        this.queue = queue;
        this.logger = logger;
    }

    @Override
    public void Execute() throws Exception {

        for (Executable command : arrayTask) {
            if (command == null) {
                continue;
            }
            try {
                command.Execute();
            } catch (Exception e){
                new ExceptionHandler(queue, (Command) command, e, logger);
            }
        }
    }

        @Override
        public Object getObject () {
            return arrayTask;
        }
    }
