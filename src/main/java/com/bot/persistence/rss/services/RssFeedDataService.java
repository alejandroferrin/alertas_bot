package com.bot.persistence.rss.services;

import com.bot.persistence.rss.entities.FeedsRss;

import java.util.List;

public interface RssFeedDataService {
    public List<FeedsRss> findAll();
}
