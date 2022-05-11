package com.bot.services.feignclients.twitch.dtos;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Stream {
    private String id;
    private String user_id;
    private String user_login;
    private String user_name;
    private String game_id;
    private String game_name;
    private String type;
    private String title;
    private int viewer_count;
    private String started_at;
    private String language;
    private String thumbnail_url;
    private ArrayList<String> tag_ids;
    private boolean is_mature;
}
