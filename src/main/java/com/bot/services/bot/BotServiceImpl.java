package com.bot.services.bot;

import com.bot.utils.Message;
import de.raysha.lib.telegram.bot.api.BotAPI;
import de.raysha.lib.telegram.bot.api.TelegramBot;
import de.raysha.lib.telegram.bot.api.exception.BotException;
import de.raysha.lib.telegram.bot.api.model.ChatId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class BotServiceImpl implements BotService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BotServiceImpl.class);

    @Value("${telegram.bot.token}")
    private String token;
    @Value("${telegram.channel.id}")
    private String channelId;

    private BotAPI telegramBot;
    private ChatId chatId;

    @PostConstruct
    private void init() {
        telegramBot = new TelegramBot(token);
        chatId = new ChatId(channelId);
    }

    @Override
    public void sendMessage(String message) {

        try {
            telegramBot.sendMessage(chatId, message);
        } catch (BotException e) {
/*
            LOGGER.error(Message.builder()
                    .class_("BotServiceImpl")
                    .method("sendMessage")
                    .error(e.getMessage())
                    .build().toString());
*/
        }


    }
}
