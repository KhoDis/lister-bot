package io.khodis.lister.command;

import io.khodis.lister.service.SendMessageService;

public abstract class BaseCommand implements Command {
    protected SendMessageService sendMessageService;

    BaseCommand(SendMessageService sendMessageService) {
        this.sendMessageService = sendMessageService;
    }
}
