package com.bot.persistence.rss.repositories;

import com.bot.persistence.rss.entities.FeedsRss;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedRssRepository extends JpaRepository<FeedsRss, String> {
}
