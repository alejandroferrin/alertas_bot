package com.bot.persistence.rss.services;

import com.bot.persistence.rss.entities.RssEntry;
import com.bot.persistence.rss.repositories.RssEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RssEntryDataServiceImpl implements RssEntryDataService {

    @Autowired
    RssEntryRepository repository;

    @Override
    public void saveEntity(RssEntry rssEntry) {
        repository.save(rssEntry);
    }

    @Override
    public Optional<RssEntry> getRssEntry(String url) {
        return repository.findByUrl(url);
    }
}
