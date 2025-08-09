package org.example.tasks;

import org.example.commands.Command;

public interface Taskable {

    void Execute() throws Exception;

     Command getCommand();
}
