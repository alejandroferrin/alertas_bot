package com.bot.services.rss;

import com.bot.persistence.rss.entities.RssEntry;

import java.util.List;

public interface RssReaderService {

    public List<RssEntry> getListOfEntries();

}
