package com.gtbr.vaultbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaultBotApplication {

    private static JDA jda;
    private static final String DISCORD_TOKEN = System.getenv("DISCORD_TOKEN");

    public static void main(String[] args) throws LoginException {
        SpringApplication.run(VaultBotApplication.class, args);
        jda = JDABuilder.createDefault(DISCORD_TOKEN).build();
    }

    public static JDA getJda(){
        return jda;
    }

}
