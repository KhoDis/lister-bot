package io.khodis.lister.command;

import io.khodis.lister.service.SendMessageService;

import java.util.Hashtable;

import static io.khodis.lister.command.CommandDesignation.START;

public class CommandContainer {
    private final Command unknownCommand;
    private final Hashtable<String, Command> commands;

    public CommandContainer(SendMessageService sendMessageService) {
        this.commands = new Hashtable<>() {{
            put(START.getDesignation(), new StartCommand(sendMessageService));
        }};

        unknownCommand = new UnknownCommand();
    }

    public Command getCommand(String commandIdentifier) {
        return commands.getOrDefault(commandIdentifier, unknownCommand);
    }
}
