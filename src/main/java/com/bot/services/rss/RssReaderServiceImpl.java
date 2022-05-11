package com.bot.services.rss;

import com.bot.persistence.rss.entities.RssEntry;
import com.bot.persistence.rss.services.RssFeedDataService;
import com.bot.utils.Message;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Component
public class RssReaderServiceImpl implements RssReaderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RssReaderServiceImpl.class);

    @Autowired
    RssFeedDataService rssFeedDataService;

    @Override
    public List<RssEntry> getListOfEntries() {

        List<RssEntry> list = new ArrayList<>();

        rssFeedDataService.findAll().forEach(rss -> {
            try {
                URL feedUrl = new URL(rss.getUrl());

                SyndFeedInput input = new SyndFeedInput();
                SyndFeed feed = input.build(new XmlReader(feedUrl));

                feed.getEntries().forEach(syndEntry -> {
                    list.add(RssEntry.builder()
                            .medio(rss.getMedio())
                            .title(syndEntry.getTitle())
                            .url(syndEntry.getLink())
                            .nombreCanal(rss.getNombreCanal())
                            .description(syndEntry.getDescription().getValue())
                            .build());
                });
            } catch (Exception e) {
                LOGGER.error(Message.builder()
                        .class_("IvooxRssServiceImpl")
                        .method("getLastAudiosFromIvoox")
                        .error(e.getMessage())
                        .build().toString());
            }
        });
        return list;
    }
}
