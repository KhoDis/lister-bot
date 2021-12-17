package io.khodis.lister.command;

import io.khodis.lister.service.SendMessageService;
import io.khodis.lister.service.UserService;

import java.util.Hashtable;

import static io.khodis.lister.command.CommandDesignation.*;

public class CommandContainer {
    private final Command unknownCommand;
    private final Hashtable<String, Command> commands;

    public CommandContainer(SendMessageService sendMessageService, UserService userService) {
        this.commands = new Hashtable<>() {{
            put(START.getDesignation(), new StartCommand(sendMessageService, userService));
            put(HELLO.getDesignation(), new HelloCommand(sendMessageService));
        }};

        unknownCommand = new UnknownCommand(sendMessageService);
    }

    public Command getCommand(String commandIdentifier) {
        return commands.getOrDefault(commandIdentifier, unknownCommand);
    }
}
