package com.bot.services.feignclients.twitch.clients;


import com.bot.services.feignclients.twitch.dtos.RequestTwitchTokenDto;
import com.bot.services.feignclients.twitch.dtos.ResponseTwitchTokenDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(
        value = "twitchAuth"
        , url = "https://id.twitch.tv/oauth2"
)
public interface TwitchAuthTokenClient {

    @RequestMapping(method = RequestMethod.POST, value = "/token")
    ResponseTwitchTokenDto getTwitchToken(RequestTwitchTokenDto dto);

}
