package com.bot.launchers;

import com.bot.persistence.twitch.entities.StreamDto;
import com.bot.persistence.twitch.services.TwitchStreamService;
import com.bot.services.bot.BotService;
import com.bot.services.feignclients.twitch.dtos.ResponseTwitchStreamDto;
import com.bot.services.feignclients.twitch.dtos.Stream;
import com.bot.services.twitch.TwitchService;
import com.bot.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TwitchLauncher {

    @Autowired
    TwitchService twitchService;
    @Autowired
    BotService botService;
    @Autowired
    TwitchStreamService dataService;

    @Value("${twitch.streamer.id}")
    private String streamerId;
    @Value("${twitch.url}")
    private String twitchUrl;


    @Scheduled(cron = "${twitch.cron}", zone = "Europe/Madrid")
    public void launch() {
        ResponseTwitchStreamDto response = twitchService.getStream();
        if (!response.getData().isEmpty()) {
            Stream stream = response.getData().get(0);
            if (dataService.getStream(stream.getId()).isEmpty()) {
                StringBuilder message = new StringBuilder();
                message.append(Constants.MENSAJE_TWITCH);
                message.append("\n\n");
                message.append(stream.getTitle());
                message.append("\n");
                message.append(twitchUrl).append(stream.getUser_name());
                botService.sendMessage(message.toString());
                dataService.saveEntity(StreamDto.builder()
                        .id(stream.getId())
                        .title(stream.getTitle().length() > 20 ? stream.getTitle().substring(0, 20) : stream.getTitle())
                        .build());
            }
        }
    }
}
