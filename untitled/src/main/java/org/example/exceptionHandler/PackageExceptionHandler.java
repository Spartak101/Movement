package org.example.exceptionHandler;

import org.example.TaskQueue;
import org.example.commands.Command;
import org.example.tasks.LogTask;

import java.util.logging.Logger;

public class PackageExceptionHandler implements IExceptionHandler{

    private TaskQueue queue;
    private Command command;
    private Exception e;
    private Logger logger;

    public PackageExceptionHandler(TaskQueue queue, Command command, Exception e, Logger logger) {
        this.queue = queue;
        this.command = command;
        this.e = e;
        this.logger = logger;
    }

    @Override
    public void hand() {
        queue.add(new LogTask(logger, e, command));
    }
}
