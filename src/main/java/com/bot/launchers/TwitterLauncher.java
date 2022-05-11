package com.bot.launchers;

import com.bot.persistence.twitch.entities.StreamDto;
import com.bot.persistence.twitter.entities.TweetDto;
import com.bot.persistence.twitter.services.TweetsService;
import com.bot.services.bot.BotService;
import com.bot.services.feignclients.twitch.dtos.ResponseTwitchStreamDto;
import com.bot.services.feignclients.twitch.dtos.Stream;
import com.bot.services.feignclients.twitter.dtos.ResponseTwitterTimelineDto;
import com.bot.services.twitch.TwitchService;
import com.bot.services.twitter.TwitterService;
import com.bot.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TwitterLauncher {

    @Autowired
    TwitterService twitchService;
    @Autowired
    BotService botService;
    @Autowired
    TweetsService dataService;

    @Value(("${twitter.channel.name}"))
    private String channelName;


    @Scheduled(cron = "${twitter.cron}", zone = "Europe/Madrid")
    public void launch() {
        ResponseTwitterTimelineDto response = twitchService.getTweets();
        if (!response.getData().isEmpty()) {
            response.getData().forEach(tweet -> {
                if (dataService.getTweet(tweet.getId()).isEmpty()) {

                    StringBuilder url = new StringBuilder();
                    url.append("https://twitter.com/");
                    url.append(channelName);
                    url.append("/status/");
                    url.append(tweet.getId());

                    StringBuilder message = new StringBuilder();
                    message.append(Constants.MENSAJE_TWITTER);
                    message.append("\n");
                    message.append(tweet.getText());
                    message.append("\n");
                    message.append("\n");
                    message.append(url.toString());
                    botService.sendMessage(message.toString());
                    dataService.saveEntity(TweetDto.builder()
                            .id(tweet.getId())
                            .text(url.toString())
                            .build());
                }
            });
        }
    }
}
