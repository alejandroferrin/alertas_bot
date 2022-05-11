package com.bot.services.feignclients.twitter.dtos;

import com.bot.persistence.twitter.entities.TweetDto;
import lombok.Data;

import java.util.ArrayList;

@Data
public class ResponseTwitterTimelineDto {
    public ArrayList<TweetDto> data;
    public Meta meta;
}
