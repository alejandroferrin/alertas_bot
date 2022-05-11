package com.bot.services.feignclients.twitch.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TwitchAuthToken {
    private String access_token;
    private int expires_in;
    private String token_type;
}
