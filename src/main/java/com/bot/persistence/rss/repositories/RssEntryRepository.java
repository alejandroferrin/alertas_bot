package com.bot.persistence.rss.repositories;

import com.bot.persistence.rss.entities.RssEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RssEntryRepository extends JpaRepository<RssEntry, String> {

    Optional<RssEntry> findByUrl(String url);

}
