package com.bot.services.feignclients.twitter.dtos;

import lombok.Data;

@Data
public class Meta {
    public String next_token;
    public int result_count;
    public String newest_id;
    public String oldest_id;
}
