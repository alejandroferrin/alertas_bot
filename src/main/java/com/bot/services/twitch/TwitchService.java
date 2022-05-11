package com.bot.services.twitch;

import com.bot.services.feignclients.twitch.dtos.ResponseTwitchStreamDto;

public interface TwitchService {

    public ResponseTwitchStreamDto getStream();

}
