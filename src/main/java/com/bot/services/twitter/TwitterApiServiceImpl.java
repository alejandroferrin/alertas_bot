package com.bot.services.twitter;

import com.bot.services.feignclients.twitch.dtos.RequestTwitchTokenDto;
import com.bot.services.feignclients.twitch.dtos.ResponseTwitchTokenDto;
import com.bot.services.feignclients.twitter.clients.TwitterTimelineClient;
import com.bot.services.feignclients.twitter.dtos.ResponseTwitterTimelineDto;
import com.bot.utils.Message;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TwitterApiServiceImpl implements TwitterService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterApiServiceImpl.class);

    @Autowired
    TwitterTimelineClient apiClient;

    @Value("${twitter.bearer.token}")
    private String token;
    @Value("${twitter.timeline.id}")
    private Long id;

    private final String exludes = "retweets,replies";


    public ResponseTwitterTimelineDto getTweets() {
        try {
            return apiClient.getTweetsFromTimeline(10, exludes, id, "Bearer " + token);
        } catch (FeignException e) {
            LOGGER.error(Message.builder()
                    .class_("TwitchApiServiceImpl")
                    .method("getStream")
                    .error(e.getMessage())
                    .build().toString());
            return null;
        }
    }

}
