package com.chernyavsky.telegram.util;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

public class TelegramUtil {

    public static SendMessage createMessageTemplate(Message message) {
        Long chatId = message.getChatId();
        SendMessage newMessage = new SendMessage();
        newMessage.setChatId(String.valueOf(chatId));
        return newMessage;
    }
}
