package com.bot.persistence.rss.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RssEntry {

    @Id
    private String url;
    private String nombreCanal;
    private String medio;
    private String title;
    private String description;

}
