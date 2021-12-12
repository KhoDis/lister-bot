package io.khodis.lister.command;

import io.khodis.lister.service.SendMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command {
    public StartCommand(SendMessageService sendMessageService) {
    }

    @Override
    public boolean execute(Update update) {

        return false;
    }
}
