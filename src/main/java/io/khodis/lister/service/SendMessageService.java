package io.khodis.lister.service;

import org.springframework.stereotype.Component;

public interface SendMessageService {
    void sendMessage(long chatId, String message);
}
