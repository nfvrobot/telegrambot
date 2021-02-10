package com.chernyavsky.telegram.bot;

import com.chernyavsky.telegram.dto.CityDto;
import com.chernyavsky.telegram.util.TelegramUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;

@Component
public class Bot extends TelegramLongPollingBot {

    private static final Logger log = Logger.getLogger(Bot.class);



    @Value("${bot.name}")
    private String name;

    @Value("${bot.token}")
    private String token;

    @Override
    public void onUpdateReceived(Update update) {
        log.debug("Receive new Update. updateID: " + update.getUpdateId());
        if (update.hasMessage()) {
            Message message = update.getMessage();
            SendMessage response = TelegramUtil.createMessageTemplate(message);
            CityDto cityDto = UpdateReceiver.handle(update);
            if (cityDto == null) {
                response.setText("Такого города нет в базе...");
            }
            response.setText(cityDto.getInfo());
            try {
                execute(response);
                log.info("Sent message " + " to: " + message.getChatId());
            } catch (TelegramApiException | IllegalArgumentException e) {
                log.error("Failed to send message due to error: " + e.getMessage());
            }
        }
    }
    @Override
    public String getBotUsername() {
        return name;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @PostConstruct
    public void start() {
        log.info("name: " + name + " token: " + token);
    }
}