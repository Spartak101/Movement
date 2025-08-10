package org.example.exceptionHandler;

import org.example.TaskQueue;
import org.example.commands.Command;
import org.example.tasks.RestartTask;
import org.example.tasks.TwoExceptionsTask;

import java.util.logging.Logger;

public class CommandExceptionHandler implements IExceptionHandler{

    private TaskQueue queue;
    private Command command;
    private Exception e;
    private Logger logger;

    public CommandExceptionHandler(TaskQueue queue, Command command, Exception e, Logger logger) {
        this.queue = queue;
        this.command = command;
        this.e = e;
        this.logger = logger;
    }

    @Override
    public void hand() {
        if (command.getNumberOfCalls() < 2) {
            queue.add(new RestartTask(command, queue));
        } else if (command.getNumberOfCalls() == 2) {
            queue.add(new TwoExceptionsTask(logger,command, e, queue));
        }
    }
}
