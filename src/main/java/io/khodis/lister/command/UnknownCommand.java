package io.khodis.lister.command;

import io.khodis.lister.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class UnknownCommand implements Command {
    private final SendMessageService sendMessageService;

    public UnknownCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }

    @Override
    public CommandStatus execute(Update update) {
        sendMessageService.sendMessage(update.getMessage().getChatId(), "what is that " + update.getMessage().getText() + " command");
        return CommandStatus.EXIT;
    }
}
