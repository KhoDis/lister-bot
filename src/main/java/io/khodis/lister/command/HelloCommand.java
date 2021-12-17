package io.khodis.lister.command;

import io.khodis.lister.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;

public class HelloCommand extends BaseCommand {
    HelloCommand(SendMessageService sendMessageService) {
        super(sendMessageService);
    }

    @Override
    public CommandStatus execute(Update update) {
        User user = update.getMessage().getFrom();
        sendMessageService.sendMessage(update.getMessage().getChatId(), "Hello, your data:\n" +
                "id: " + user.getId() +
                "\nfirst name: " + user.getFirstName() +
                "\nlast name: " + user.getLastName() +
                "\nuser name: " + user.getUserName() +
                "\nlanguage: " + user.getLanguageCode() +
                "\nis bot: " + user.getIsBot());
        return CommandStatus.EXIT;
    }
}
