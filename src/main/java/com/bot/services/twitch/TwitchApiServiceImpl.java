package com.bot.services.twitch;

import com.bot.services.feignclients.twitch.clients.TwitchAuthTokenClient;
import com.bot.services.feignclients.twitch.clients.TwitchStreamClient;
import com.bot.services.feignclients.twitch.dtos.RequestTwitchTokenDto;
import com.bot.services.feignclients.twitch.dtos.ResponseTwitchStreamDto;
import com.bot.services.feignclients.twitch.dtos.ResponseTwitchTokenDto;
import com.bot.utils.Message;
import feign.FeignException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TwitchApiServiceImpl implements TwitchService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwitchApiServiceImpl.class);

    @Autowired
    TwitchAuthTokenClient twitchAuthTokenClient;
    @Autowired
    TwitchStreamClient twitchStreamClient;

    @Value("${twitch.client.id}")
    private String clientId;
    @Value("${twitch.client.secret}")
    private String clientSecret;
    @Value("${twitch.grant.type}")
    private String grantType;
    @Value("${twitch.streamer.id}")
    private String streamerId;

    LocalDateTime expires = null;
    ResponseTwitchTokenDto responseToken = null;


    public ResponseTwitchStreamDto getStream() {
        LocalDateTime now = LocalDateTime.now();
        try {
            if (expires == null || expires.compareTo(now) < 0) {
                responseToken = twitchAuthTokenClient.getTwitchToken(RequestTwitchTokenDto.builder()
                        .client_id(clientId)
                        .client_secret(clientSecret)
                        .grant_type(grantType)
                        .build());
                expires = now.plusSeconds(responseToken.getExpires_in() - 100);
            }
            return twitchStreamClient.getStreamByUserId(streamerId, "Bearer " + responseToken.getAccess_token(), clientId);
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
