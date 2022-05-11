package com.bot;

import com.bot.launchers.RssLauncher;
import com.bot.launchers.TwitchLauncher;
import com.bot.launchers.TwitterLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableFeignClients
public class AlertasJordiBotApplication implements CommandLineRunner {

    @Value(("${run.now}"))
    private boolean run;

    @Autowired
    RssLauncher rssLauncher;
    @Autowired
    TwitchLauncher twitchLauncher;
    @Autowired
    TwitterLauncher twitterLauncher;

    public static void main(String[] args) {
        SpringApplication.run(AlertasJordiBotApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        if (run) {
            rssLauncher.launch();
            twitchLauncher.launch();
            twitterLauncher.launch();
        }

    }
}
