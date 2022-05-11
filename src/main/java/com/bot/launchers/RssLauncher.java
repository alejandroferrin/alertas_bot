package com.bot.launchers;

import com.bot.persistence.rss.entities.RssEntry;
import com.bot.persistence.rss.services.RssEntryDataService;
import com.bot.persistence.rss.services.RssEntryDataServiceImpl;
import com.bot.services.bot.BotService;
import com.bot.services.rss.RssReaderService;
import com.bot.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RssLauncher {

    @Autowired
    RssReaderService rssReaderService;
    @Autowired
    BotService botService;
    @Autowired
    RssEntryDataService rssEntryDataService;

    @Scheduled(cron = "${rss.cron}", zone = "Europe/Madrid")
    public void launch() {
        rssReaderService.getListOfEntries().forEach(rssEntry -> {
            if (rssEntryDataService.getRssEntry(rssEntry.getUrl()).isEmpty()) {
                if (rssEntry.getMedio().equals(Constants.PODCAST)) {
                    if (rssEntry.getNombreCanal().equals(Constants.ECONOMIA)) {
                        if (rssEntry.getDescription().matches(".*Jordi Llatzer.*")) {
                            processPodcastEconomia(rssEntry);
                        } else {
                            rssEntry.setDescription("Audio en el que no colabora Jordi");
                            int length = rssEntry.getTitle().length();
                            rssEntry.setTitle(rssEntry.getTitle().substring(length));
                            rssEntryDataService.saveEntity(rssEntry);
                        }
                    } else {
                        processPodcast(rssEntry);
                    }
                }
            }
        });
    }

    private void processPodcastEconomia(RssEntry rssEntry) {
        StringBuilder message = new StringBuilder();
        message.append(Constants.MENSAJE_ECONOMIA);
        message.append("\n");
        message.append(rssEntry.getTitle());
        message.append("\n");
        message.append(rssEntry.getUrl());
        botService.sendMessage(message.toString());
        rssEntry.setDescription(Constants.ECONOMIA_MSG);
        rssEntry.setTitle(rssEntry.getTitle().length() > 20 ? rssEntry.getTitle().substring(0, 20) : rssEntry.getTitle());
        rssEntryDataService.saveEntity(rssEntry);
    }

    private void processPodcast(RssEntry rssEntry) {
        StringBuilder message = new StringBuilder();
        message.append(Constants.MENSAJE_IVOOX);
        message.append(rssEntry.getNombreCanal());
        message.append("\n");
        message.append(rssEntry.getTitle());
        message.append("\n");
        message.append(rssEntry.getUrl());
        botService.sendMessage(message.toString());
        rssEntry.setDescription(Constants.PODCAST_MSG);
        rssEntry.setTitle(rssEntry.getTitle().length() > 20 ? rssEntry.getTitle().substring(0, 20) : rssEntry.getTitle());
        rssEntryDataService.saveEntity(rssEntry);
    }

}
