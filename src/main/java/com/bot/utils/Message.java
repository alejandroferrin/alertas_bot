package com.bot.utils;

import lombok.Builder;

@Builder
public class Message {

    private String class_;
    private String method;
    private String message;
    private String error;

    @Override
    public String toString() {
        String m, e;
        if (message == null) {
            m = "";
        } else {
            m = " Message= " + message;
        }
        if (error == null) {
            e = "";
        } else {
            e = " Error= " + error;
        }
        return " Class= " + class_ +
                " Method= " + method +
                m +
                e;
    }
}
