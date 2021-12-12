package io.khodis.lister.command;

import org.telegram.telegrambots.meta.api.objects.Update;

public class HelloCommand implements Command {
    @Override
    public boolean execute(Update update) {

        return false;
    }
}
