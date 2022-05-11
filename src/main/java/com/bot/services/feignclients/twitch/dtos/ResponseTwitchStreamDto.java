package com.bot.services.feignclients.twitch.dtos;

import lombok.Data;

import java.util.ArrayList;

@Data
public class ResponseTwitchStreamDto {

    private ArrayList<Stream> data;
    private Object pagination;

}



