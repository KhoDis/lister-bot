package io.khodis.lister.command;

import io.khodis.lister.service.SendMessageService;
import io.khodis.lister.service.UserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand extends BaseCommand {
    private UserService userService;

    public StartCommand(SendMessageService sendMessageService, UserService userService) {
        super(sendMessageService);
        this.userService = userService;
    }

    @Override
    public CommandStatus execute(Update update) {
        int telegramId = update.getMessage().getFrom().getId();
        if (userService.exists(telegramId)) {
            sendMessageService.sendMessage(update.getMessage().getChatId(),
                    "You are already registered. Type /help to know what I can do for you!");
        } else {
            userService.register(telegramId);
            sendMessageService.sendMessage(update.getMessage().getChatId(),
                    "You've been successfully registered. Type /help to know what I can do for you!");
        }
        return CommandStatus.EXIT;
    }
}
