package org.example.tasks;

import org.example.commands.Command;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogTask implements Taskable{

    private Logger logger;
    private Exception e;
    private Command command;

    public LogTask(Logger logger, Exception e, Command command) {
        this.logger = logger;
        this.e = e;
        this.command = command;
    }

    @Override
    public void Execute() {
        logger.log(Level.SEVERE, command.getClass().getName(), e);
    }

    @Override
    public Object getObject() {
        return command;
    }

    public Exception getE() {
        return e;
    }

    public Logger getLogger() {
        return logger;
    }
}
