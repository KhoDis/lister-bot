package io.khodis.lister;

import io.khodis.lister.command.ChatCommand;
import io.khodis.lister.command.CommandContainer;
import io.khodis.lister.command.CommandDesignation;
import io.khodis.lister.config.BotProperties;
import io.khodis.lister.service.impl.SendMessageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.regex.Pattern;

@Component
@Slf4j
public class Bot extends TelegramLongPollingBot {
    private static final String COMMAND_PREFIX = "/";
    private final BotProperties properties;
    private final CommandContainer commandContainer;
    private final Pattern cancelCommandPattern = Pattern.compile("^" + CommandDesignation.CANCEL + "[a-zA-Z]+");
    private ChatCommand chatCommand;

    public Bot(BotProperties properties) {
        this.commandContainer = new CommandContainer(new SendMessageServiceImpl(this));
        this.properties = properties;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (handleChatCommand(update)) return;

        handleCommand(update);
    }

    private void handleCommand(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandIdentifier = message.split(" ")[0].toLowerCase();

                commandContainer.getCommand(commandIdentifier).execute(update);
            }
        }
    }

    private boolean handleChatCommand(Update update) {
        if (chatCommand != null) {
            if (update.hasMessage() && update.getMessage().hasText()) {
                if (cancelCommandPattern.matcher(update.getMessage().getText()).matches()) {
                    chatCommand.cancel(update);
                }
            }
            return chatCommand.execute(update);
        }
        return false;
    }

    @Override
    public String getBotUsername() {
        return properties.getName();
    }

    @Override
    public String getBotToken() {
        return properties.getToken();
    }
}
