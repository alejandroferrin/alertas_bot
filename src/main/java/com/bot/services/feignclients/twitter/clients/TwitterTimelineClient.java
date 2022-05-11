package com.bot.services.feignclients.twitter.clients;

import com.bot.services.feignclients.twitch.dtos.ResponseTwitchStreamDto;
import com.bot.services.feignclients.twitter.dtos.ResponseTwitterTimelineDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(
        value = "twitterTimelineClient"
        , url = "https://api.twitter.com/2"
)
public interface TwitterTimelineClient {


    @RequestMapping(method = RequestMethod.GET, value = "/users/{id}/tweets")
    ResponseTwitterTimelineDto getTweetsFromTimeline(@RequestParam(name = "max_results") int quantityOfResults,
                                                     @RequestParam(name = "exclude") String exclude,
                                                     @PathVariable("id") Long userId,
                                                     @RequestHeader("Authorization") String bearer);


}


