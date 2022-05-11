package com.bot.persistence.twitter.repositories;

import com.bot.persistence.twitch.entities.StreamDto;
import com.bot.persistence.twitter.entities.TweetDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetsRepository extends JpaRepository<TweetDto, String> {
}
