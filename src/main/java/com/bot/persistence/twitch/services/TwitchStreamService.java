package com.bot.persistence.twitch.services;

import com.bot.persistence.twitch.entities.StreamDto;

import java.util.Optional;

public interface TwitchStreamService {
    void saveEntity(StreamDto dto);
    Optional<StreamDto> getStream(String id);
}
