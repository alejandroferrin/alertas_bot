package com.bot.persistence.twitter.entities;

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
public class TweetDto {

    @Id
    private String id;
    private String text;
}
