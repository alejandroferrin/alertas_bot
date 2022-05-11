package com.bot.persistence.rss.services;

import com.bot.persistence.rss.entities.RssEntry;

import java.util.Optional;

public interface RssEntryDataService {
    void saveEntity(RssEntry rssEntry);
    Optional<RssEntry> getRssEntry(String url);
}
