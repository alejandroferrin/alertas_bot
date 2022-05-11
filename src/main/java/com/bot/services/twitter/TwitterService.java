package com.bot.services.twitter;

import com.bot.services.feignclients.twitter.dtos.ResponseTwitterTimelineDto;

public interface TwitterService {

    public ResponseTwitterTimelineDto getTweets();

}
