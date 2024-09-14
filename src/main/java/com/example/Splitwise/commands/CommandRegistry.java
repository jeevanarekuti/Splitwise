package com.example.Splitwise.commands;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CommandRegistry {
    private Map<String, Command> map;
    private static CommandRegistry INSTANCE = null;

    private CommandRegistry() {
        map = new HashMap<String, Command>();
    }

    //TODO we can add synchronized function(Block) here to use multi threading
    //TODO If we use synchronized method only one thread is able to execute the function.
    public synchronized static CommandRegistry getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CommandRegistry();
        }
        return INSTANCE;
    }

    public Command getCommand(String input) {
        for (Map.Entry<String, Command> entry : map.entrySet()) {
            String key = entry.getKey();
            if (input.contains(key)) {
                return entry.getValue();
            }
        }
        throw new UnsupportedOperationException("Operation " + input + " is not supported");
    }

    public void addCommand(String key, Command command) {
        map.put(key, command);
    }



}
