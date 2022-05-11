package com.bot.services.feignclients.twitch.dtos;

import lombok.Data;

@Data
public class ResponseTwitchTokenDto {

    private String access_token;
    private int expires_in;
    private String token_type;

}
