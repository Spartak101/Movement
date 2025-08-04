package org.example.exceptionHandler;

import org.example.TaskQueue;
import org.example.commands.Command;
import org.example.exceptions.CommandException;
import org.example.exceptions.ObjectException;
import org.example.exceptions.PackageException;

import java.util.logging.Logger;

public class ExceptionHandler implements IExceptionHandler{
    private TaskQueue queue;
    private Command command;
    private Exception e;
    private Logger logger;

    public ExceptionHandler(TaskQueue queue, Command command, Exception e, Logger logger) {
        this.queue = queue;
        this.command = command;
        this.e = e;
        this.logger = logger;
    }

    @Override
    public void hand() {
        if (e instanceof CommandException) {
            new CommandExceptionHandler(queue, command, e, logger);
        } else if (e instanceof ObjectException) {
            new ObjectExceptionHandler(queue, command, e, logger);
        } else if (e instanceof PackageException) {
            new PackageExceptionHandler(queue, command, e, logger);
        } else {
            new OtherExceptionHandler(queue, command, e, logger);
        }
    }
}
