package io.khodis.lister.service.impl;

import io.khodis.lister.Bot;
import io.khodis.lister.service.SendMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Component
public class SendMessageServiceImpl implements SendMessageService {
    private final Bot bot;

    public SendMessageServiceImpl(Bot bot) {
        this.bot = bot;
    }

    @Override
    public void sendMessage(long chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error(e.toString(), e);
        }
    }
}
