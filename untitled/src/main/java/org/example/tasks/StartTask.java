package org.example.tasks;

import org.example.commands.Command;

public class StartTask implements Taskable{

    private Command command;

    public StartTask(Command command) {
        this.command = command;
    }

    @Override
    public void Execute() throws Exception {
        command.Execute();
    }

    @Override
    public Command getCommand() {
        return command;
    }

}
