package com.chernyavsky.telegram.bot;

import com.chernyavsky.telegram.dto.CityDto;
import com.chernyavsky.telegram.service.CityService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class UpdateReceiver {

    private static CityService cityService;


    public UpdateReceiver(CityService cityService) {
        this.cityService = cityService;
    }

    public static CityDto handle(Update update) {
        try {
            if (!update.getMessage().getText().isEmpty()) {
                final Message message = update.getMessage();
                return cityService.getCityByName(message.getText());
            }
        } catch (UnsupportedOperationException e) {
            e.getMessage();
        }
        return null;
    }
}
