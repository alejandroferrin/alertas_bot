package com.bot.services.feignclients.twitch.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestTwitchTokenDto {

    private String client_id;
    private String client_secret;
    private String grant_type;

}
