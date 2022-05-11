package com.bot.persistence.twitter.services;

import com.bot.persistence.twitch.entities.StreamDto;
import com.bot.persistence.twitch.repositories.StreamRepository;
import com.bot.persistence.twitch.services.TwitchStreamService;
import com.bot.persistence.twitter.entities.TweetDto;
import com.bot.persistence.twitter.repositories.TweetsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TweetsServiceImpl implements TweetsService {

    @Autowired
    TweetsRepository repository;

    @Override
    public void saveEntity(TweetDto dto) {
        repository.save(dto);
    }

    @Override
    public Optional<TweetDto> getTweet(String id) {
        return repository.findById(id);
    }
}
