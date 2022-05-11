package com.bot.services.feignclients.twitch.clients;

import com.bot.services.feignclients.twitch.dtos.ResponseTwitchStreamDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        value = "twitchStreams"
        , url = "https://api.twitch.tv/helix"
)
public interface TwitchStreamClient {


    @RequestMapping(method = RequestMethod.GET, value = "/streams")
    ResponseTwitchStreamDto getStreamByUserId(@RequestParam(name = "user_id") String channelId,
                                              @RequestHeader("Authorization") String bearer,
                                              @RequestHeader("Client-id") String clientToken);


}
