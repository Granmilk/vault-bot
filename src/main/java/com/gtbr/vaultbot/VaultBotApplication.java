package com.gtbr.vaultbot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import com.gtbr.vaultbot.config.ConfigVariables;
import com.gtbr.vaultbot.listener.MessageListener;
import com.gtbr.vaultbot.utils.SpringContext;

import javax.security.auth.login.LoginException;

import java.util.Arrays;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VaultBotApplication {

    private static JDA jda;
    private static final String DISCORD_TOKEN = System.getenv("DISCORD_TOKEN");


    public static void main(String[] args) throws LoginException {
        SpringApplication.run(VaultBotApplication.class, args);

        ConfigVariables configVariables = SpringContext.getBean(ConfigVariables.class);
        Flyway flyway = Flyway.configure().dataSource(configVariables.getDataBaseUrl(), configVariables.getDataBaseUser(), configVariables.getDataBasePassword()).load();
        if (Arrays.stream(args).anyMatch(arg -> arg.equalsIgnoreCase("MIGRATE")))
            flyway.migrate();

        jda = JDABuilder.createDefault(DISCORD_TOKEN)
                .addEventListeners(MessageListener.class)
                .build();
    }

    public static JDA getJda(){
        return jda;
    }

}
