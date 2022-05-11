package com.bot.persistence.rss.services;

import com.bot.persistence.rss.entities.FeedsRss;
import com.bot.persistence.rss.repositories.FeedRssRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RssFeedDataServiceImpl implements RssFeedDataService {

    @Autowired
    FeedRssRepository repository;

    @Override
    public List<FeedsRss> findAll() {
        return repository.findAll();
    }
}
