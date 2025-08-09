package org.example.tasks;

import org.example.TaskQueue;
import org.example.commands.Command;

public class RestartTask implements Taskable{

    private Command command;
    private TaskQueue queue;

    public RestartTask(Command command, TaskQueue queue) {
        this.command = command;
        this.queue = queue;
    }

    @Override
    public void Execute() throws Exception {
            queue.add(new StartTask(command));
    }

    @Override
    public Command getCommand() {
        return command;
    }

    public TaskQueue getQueue() {
        return queue;
    }
}
