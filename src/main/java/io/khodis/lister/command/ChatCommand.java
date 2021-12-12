package io.khodis.lister.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface ChatCommand extends Command {
    void cancel(Update update);
}
