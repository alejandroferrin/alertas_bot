package com.bot.persistence.twitch.services;

import com.bot.persistence.twitch.entities.StreamDto;
import com.bot.persistence.twitch.repositories.StreamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TwitchStreamServiceImpl implements TwitchStreamService {

    @Autowired
    StreamRepository repository;

    @Override
    public void saveEntity(StreamDto dto) {
        repository.save(dto);
    }

    @Override
    public Optional<StreamDto> getStream(String id) {
        return repository.findById(id);
    }

}
