package com.bot.persistence.rss.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FeedsRss {
    @Id
    private String url;
    private String nombreCanal;
    private String medio;
}
