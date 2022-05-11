package com.bot.persistence.twitter.services;

import com.bot.persistence.twitch.entities.StreamDto;
import com.bot.persistence.twitter.entities.TweetDto;

import java.util.Optional;

public interface TweetsService {
    void saveEntity(TweetDto dto);
    Optional<TweetDto> getTweet(String id);
}
