package org.example.tasks;

import org.example.TaskQueue;
import org.example.commands.Command;

import java.util.logging.Logger;

public class TwoExceptionsTask implements Taskable{

    private Logger logger;
    private Command command;
    private Exception e;
    private TaskQueue queue;

    public TwoExceptionsTask(Logger logger, Command command, Exception e, TaskQueue queue) {
        this.logger = logger;
        this.command = command;
        this.e = e;
        this.queue = queue;
    }

    @Override
    public void Execute() throws Exception {
        queue.add(new LogTask(logger, e, command));
    }

    @Override
    public Object getObject() {
        return Taskable.super.getObject();
    }
}
