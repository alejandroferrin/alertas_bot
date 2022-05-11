package com.bot.persistence.twitch.repositories;

import com.bot.persistence.twitch.entities.StreamDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreamRepository extends JpaRepository<StreamDto, String> {
}
